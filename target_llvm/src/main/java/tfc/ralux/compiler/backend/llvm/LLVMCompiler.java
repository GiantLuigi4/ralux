package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMPassManagerBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMPassManagerRef;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;
import tfc.ralux.compiler.backend.llvm.util.helper.target.CPU;
import tfc.ralux.compiler.backend.llvm.util.helper.target.Target;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.Architecture;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.Environment;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.OperatingSystem;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.Vendor;
import tfc.rlxir.RlxBlock;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.RlxModule;
import tfc.rlxir.typing.PrimitiveType;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.util.rt.RlxRt;

import java.io.File;
import java.util.List;

public class LLVMCompiler extends Compiler {
    RlxModule compiling;
    BuilderRoot root;
    LLVMConversions conversions;

    boolean enableVerbose = false;

    public LLVMCompiler(RlxModule module) {
        this.compiling = module;
        root = new BuilderRoot(module.getName());
        conversions = new LLVMConversions(root);
    }

    private void compileFunction(RlxCls cls, RlxFunction function) {
        FunctionBuilder builder = function.getCompilerData();
        List<RlxBlock> blocks = function.getBlocks();
        if (enableVerbose)
            System.out.println("Compiling function " + function.enclosure + " for class " + cls.qualifiedName());
        new FunctionCompiler(this, conversions, root, cls, function, builder, blocks).compile();
    }

    private void compileClass(RlxCls aClass) {
        for (RlxFunction function : aClass.getFunctions()) {
            compileFunction(aClass, function);
        }
    }

    @Override
    public void compile() {
        for (RlxCls aClass : compiling.getClasses()) {
            compileClass(aClass);
        }

        if (compiling.getMainFunction() != null) {
            RlxFunction function = compiling.getMainFunction();
            FunctionBuilder builder = root.function("main", new FunctionType(
                    root, root.getIntType(32)
            ).build());
            BlockBuilder blockBuilder = builder.block("entry");
            root.buildBlock(blockBuilder);
            PointerPointer<LLVMValueRef> args = new PointerPointer<>(0);
            root.track(args);
            LLVMValueRef valOut = root.integer(0, 32);

            root.track(LLVM.LLVMBuildCall(
                    root.getBuilder(),
                    ((FunctionBuilder) compiling.rt.rtInit.getCompilerData()).getDirect(),
                    args, 0,
                    ""
            ));

            if (function.enclosure.result.type == PrimitiveType.INT) {
                root.track(valOut = LLVM.LLVMBuildCall(
                        root.getBuilder(),
                        ((FunctionBuilder) function.getCompilerData()).getDirect(),
                        args, 0,
                        "call_main"
                ));
            } else {
                root.track(LLVM.LLVMBuildCall(
                        root.getBuilder(),
                        ((FunctionBuilder) function.getCompilerData()).getDirect(),
                        args, 0,
                        ""
                ));
            }

            blockBuilder.ret(valOut);
        }

        if (enableVerbose) {
            root.dump();
        }

        root.validate();
    }

    @Override
    public Compiler verbose() {
        enableVerbose = true;
        return this;
    }

    private void stubFunction(RlxCls cls, RlxFunction function) {
        if (enableVerbose) {
            System.out.println("Stubbing function " + function.enclosure + " for class " + cls.qualifiedName());
        }

        RlxType type = function.enclosure.result;
        LLVMTypeRef typeRef = conversions.typeFor(type);
        FunctionType funcType = new FunctionType(root, typeRef);

        for (RlxType rlxType : function.enclosure.descr) {
            funcType.withArgs(conversions.typeFor(rlxType));
        }

        String exportName = exportNameFor(cls, function);
        function.setCompilerData(root.function(
                exportName,
                funcType.build()
        ));
    }

    public String exportNameFor(RlxCls owner, RlxFunction function) {
        String exportName = function.getExportName();
        if (exportName == null) exportName = owner.qualifiedName() + "#" + function.enclosure.name;
        return exportName;
    }

    private void stubClass(RlxCls cls) {
        if (enableVerbose) {
            System.out.println("Stubbing class " + cls.qualifiedName());
        }

        // TODO: should stub to a struct
        for (RlxFunction function : cls.getFunctions()) {
            stubFunction(cls, function);
        }
    }

    @Override
    public void stub() {
        for (RlxCls aClass : compiling.getClasses()) {
            stubClass(aClass);
        }
    }

    @Override
    public void optimize(int backend, int rlx, boolean lowerIntrinsics) {
        LLVMPassManagerBuilderRef builderRef = LLVM.LLVMPassManagerBuilderCreate();
        LLVM.LLVMPassManagerBuilderSetOptLevel(builderRef, backend);

        LLVMPassManagerRef pass = LLVM.LLVMCreatePassManager();
        LLVM.LLVMAddAlignmentFromAssumptionsPass(pass);
        LLVM.LLVMAddTypeBasedAliasAnalysisPass(pass);
        LLVM.LLVMAddBasicAliasAnalysisPass(pass);
        if (rlx >= 5) {
            LLVM.LLVMAddLowerExpectIntrinsicPass(pass);
            LLVM.LLVMAddLowerConstantIntrinsicsPass(pass);
            LLVM.LLVMAddLowerSwitchPass(pass); // h?

            LLVM.LLVMAddUnifyFunctionExitNodesPass(pass);
            LLVM.LLVMAddInternalizePass(pass, 1);
            LLVM.LLVMAddGlobalOptimizerPass(pass);
            LLVM.LLVMAddFunctionAttrsPass(pass);
            LLVM.LLVMAddLICMPass(pass);
            LLVM.LLVMAddDeadArgEliminationPass(pass);
            LLVM.LLVMAddAlwaysInlinerPass(pass);
            LLVM.LLVMAddMergeFunctionsPass(pass);
            LLVM.LLVMAddFunctionInliningPass(pass);
            LLVM.LLVMAddAggressiveDCEPass(pass);
            LLVM.LLVMAddGlobalDCEPass(pass);
            LLVM.LLVMAddScalarReplAggregatesPass(pass);
            LLVM.LLVMAddArgumentPromotionPass(pass);
            LLVM.LLVMAddPruneEHPass(pass);
            LLVM.LLVMAddCalledValuePropagationPass(pass);
            LLVM.LLVMAddCorrelatedValuePropagationPass(pass);
            LLVM.LLVMAddUnifyFunctionExitNodesPass(pass);
            LLVM.LLVMAddIPSCCPPass(pass);
            LLVM.LLVMAddLICMPass(pass);
            root.hyperAggressiveOptimizer(false, pass);
            LLVM.LLVMAddDeadArgEliminationPass(pass);
            LLVM.LLVMAddInternalizePass(pass, 1);
            LLVM.LLVMAddAlwaysInlinerPass(pass);
            LLVM.LLVMAddMergeFunctionsPass(pass);
            LLVM.LLVMAddLICMPass(pass);
            LLVM.LLVMAddStripSymbolsPass(pass);
            LLVM.LLVMAddCFGSimplificationPass(pass);
            LLVM.LLVMAddUnifyFunctionExitNodesPass(pass);
            root.hyperAggressiveOptimizer(false, pass);
            LLVM.LLVMAddReassociatePass(pass);
            LLVM.LLVMAddGVNPass(pass);
            LLVM.LLVMAddNewGVNPass(pass);
            LLVM.LLVMPassManagerBuilderPopulateModulePassManager(builderRef, pass);
            LLVM.LLVMAddSLPVectorizePass(pass);
            LLVM.LLVMAddAggressiveInstCombinerPass(pass);
            LLVM.LLVMAddAlignmentFromAssumptionsPass(pass);
            LLVM.LLVMAddCFGSimplificationPass(pass);
            LLVM.LLVMAddStripSymbolsPass(pass);
            LLVM.LLVMAddAggressiveInstCombinerPass(pass);
        } else {
            if (rlx >= 4) {
                LLVM.LLVMAddAlignmentFromAssumptionsPass(pass);
                LLVM.LLVMAddFunctionAttrsPass(pass);
                root.hyperAggressiveOptimizer(false, pass);
            } else {
                // passes for cleanup; always used for lower optimization levels
                LLVM.LLVMAddCFGSimplificationPass(pass);
                LLVM.LLVMAddPromoteMemoryToRegisterPass(pass);
                LLVM.LLVMAddEarlyCSEPass(pass);
                LLVM.LLVMAddDCEPass(pass);
                LLVM.LLVMAddConstantMergePass(pass);
                LLVM.LLVMAddInstructionSimplifyPass(pass);
                LLVM.LLVMAddCFGSimplificationPass(pass);

                if (rlx >= 1) {
                    LLVM.LLVMAddFunctionAttrsPass(pass);
                    LLVM.LLVMAddCFGSimplificationPass(pass);
                    LLVM.LLVMAddReassociatePass(pass);
                    LLVM.LLVMAddLoopUnrollAndJamPass(pass);
                    LLVM.LLVMAddReassociatePass(pass);
                    LLVM.LLVMAddCFGSimplificationPass(pass);

                    if (rlx >= 2) {
                        if (rlx == 3) {
                            LLVM.LLVMAddAlignmentFromAssumptionsPass(pass);
                            LLVM.LLVMAddEarlyCSEPass(pass);
                            LLVM.LLVMAddReassociatePass(pass);
                            LLVM.LLVMAddLoopRotatePass(pass);
                            LLVM.LLVMAddLoopUnrollPass(pass);
                            LLVM.LLVMAddLoopDeletionPass(pass);
                            LLVM.LLVMAddLoopIdiomPass(pass);
                            LLVM.LLVMAddLoopRerollPass(pass);
                            LLVM.LLVMAddCFGSimplificationPass(pass);
                            LLVM.LLVMAddAggressiveDCEPass(pass);
                        }

                        LLVM.LLVMAddJumpThreadingPass(pass);
                        LLVM.LLVMAddLoopVectorizePass(pass);
                        LLVM.LLVMAddSLPVectorizePass(pass);
                        LLVM.LLVMAddNewGVNPass(pass);
                        LLVM.LLVMAddCFGSimplificationPass(pass);
                        LLVM.LLVMAddInstructionCombiningPass(pass);
                    }

                    LLVM.LLVMAddSLPVectorizePass(pass);
                }
            }
            LLVM.LLVMPassManagerBuilderPopulateModulePassManager(builderRef, pass);
        }

        if (lowerIntrinsics) {
            LLVM.LLVMAddInternalizePass(pass, 1);
            LLVM.LLVMPassManagerBuilderPopulateModulePassManager(builderRef, pass);
            if (rlx >= 5) {
                LLVM.LLVMAddSLPVectorizePass(pass);
                LLVM.LLVMAddAggressiveInstCombinerPass(pass);
                LLVM.LLVMAddAlignmentFromAssumptionsPass(pass);
                LLVM.LLVMAddCFGSimplificationPass(pass);
                LLVM.LLVMAddStripSymbolsPass(pass);
                LLVM.LLVMAddAggressiveInstCombinerPass(pass);
            }
        }

//        LLVM.LLVMAddScalarizerPass(pass);
//        LLVM.LLVMAddVerifierPass(pass);

        LLVM.LLVMRunPassManager(pass, root.getModule());
        LLVM.LLVMDisposePassManager(pass);
        LLVM.LLVMPassManagerBuilderDispose(builderRef);

        if (enableVerbose) root.dump();
    }

    @Override
    public void write() {
        root.toTargetMachine(
                new Target(
                        Architecture.X86_64,
                        Vendor.APPLE,
                        OperatingSystem.WINDOWS,
                        Environment.UCLIBC
                ),
                CPU.GENERIC,
                3
        );
        root.writeToFile(new File(compiling.getName() + ".obj").getAbsolutePath());
        try {
            System.out.flush();
            System.err.flush();
//            Thread.sleep(2000);

            String linkCmd = "lld-link.exe " +
                    "/libpath:\"C:/Program Files/LLVM-13.0.1/lib/clang/13.0.1/lib/windows\" " +
                    "/libpath:lib " +
                    "/defaultlib:clang_rt.builtins-x86_64.lib " +
                    "/defaultlib:RlxRt " +
                    "/defaultlib:msvcrt " +
                    "/defaultlib:libcmt " +
                    "/defaultlib:ucrt " +
                    "/defaultlib:user32 " +
                    "/defaultlib:kernel32 " +
                    "/defaultlib:vcruntime " +
                    "/subsystem:console " +
                    "/fixed /cetcompat /incremental:no /ltcg " +
                    "/release /debug:none /verbose " +
                    "/merge:.text=.text " +
                    "-opt:ref -opt:icf -opt:lbr " +
                    "-entry:main module.obj /out:module.exe";

            System.out.println("Linking using:");
            System.out.println(linkCmd);
            Process proc = Runtime.getRuntime().exec(linkCmd);
            while (proc.isAlive()) {
                while (proc.inputReader().ready()) System.out.println(proc.inputReader().readLine());
                while (proc.errorReader().ready()) System.out.println(proc.errorReader().readLine());
            }
            while (proc.inputReader().ready()) System.out.println(proc.inputReader().readLine());
            while (proc.errorReader().ready()) System.out.println(proc.errorReader().readLine());
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
    }
}
