package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.llvm.LLVM.LLVMPassManagerBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMPassManagerRef;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
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
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.typing.RlxType;

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

    private void compileFunction(RlxCls aClass, RlxFunction function) {
        FunctionBuilder builder = function.getCompilerData();
        List<RlxBlock> blocks = function.getBlocks();
        new FunctionCompiler(conversions, root, aClass, function, builder, blocks).compile();
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

        if (enableVerbose) {
            root.dump();
        }

        root.validate();

        if (enableVerbose) {
            root.dump();
        }
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

        String exportName = function.getExportName();
        if (exportName == null) exportName = cls.qualifiedName() + "#" + function.enclosure.name;
        function.setCompilerData(root.function(
                exportName,
                funcType.build()
        ));
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
            LLVM.LLVMAddLICMPass(pass);
            LLVM.LLVMAddStripSymbolsPass(pass);
            LLVM.LLVMAddLowerExpectIntrinsicPass(pass);
            LLVM.LLVMAddLowerConstantIntrinsicsPass(pass);
            LLVM.LLVMAddLowerSwitchPass(pass); // h?
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
                LLVM.LLVMAddStripSymbolsPass(pass);
            }
        }

        LLVM.LLVMAddScalarizerPass(pass);
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
            Process proc = Runtime.getRuntime().exec(
                    "lld-link.exe module.obj -entry:main " +
//                            "/libpath:\"C:/Program Files/LLVM/lib/clang/8.0.1/lib/windows\" clang_rt.builtins-x86_64.lib " +
                            "/libpath:\"C:/Program Files/LLVM-13.0.1/lib/clang/13.0.1/lib/windows\" clang_rt.builtins-x86_64.lib " +
                            "/defaultlib:msvcrt " +
                            "/defaultlib:ucrt " +
                            "/defaultlib:libcmt " +
                            "/subsystem:console /verbose " +
                            "-opt:ref -opt:icf -opt:lbr " +
                            "/fixed /cetcompat /release /incremental:no /ltcg /debug:none "
            );
            System.out.println(proc.waitFor());

            System.out.println(new String(proc.getInputStream().readAllBytes()));
            System.err.println(new String(proc.getErrorStream().readAllBytes()));
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
    }
}
