package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.*;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;
import tfc.ralux.compiler.util.linker.LLD;
import tfc.ralux.compiler.util.linker.Linker;
import tfc.ralux.compiler.util.natives.CLibraries;
import tfc.rlxir.util.ProgramLocator;
import tfc.ralux.compiler.backend.llvm.util.helper.LLVMOptimizer;
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

import java.io.File;
import java.nio.file.Path;
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
            ClassObjCompiler.compileClass(
                    compiling.rt,
                    this, root, aClass,
                    compiling
            );
        }

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
			
	        LLVMValueRef valOut = root.integer(0, 32);
	        PointerPointer<LLVMValueRef> args = new PointerPointer<>(0);
	        root.track(args);
			
	        if (compiling.rt != null) {
	            root.track(LLVM.LLVMBuildCall2(
			            root.getBuilder(),
			            ((FunctionBuilder) compiling.rt.rtInit.getCompilerData()).getType(),
			            ((FunctionBuilder) compiling.rt.rtInit.getCompilerData()).getDirect(),
			            args, 0,
			            ""
	            ));
            }

            if (function.enclosure.result.type == PrimitiveType.INT) {
                root.track(valOut = LLVM.LLVMBuildCall2(
                        root.getBuilder(),
						((FunctionBuilder) function.getCompilerData()).getType(),
                        ((FunctionBuilder) function.getCompilerData()).getDirect(),
                        args, 0,
                        "call_main"
                ));
            } else {
                root.track(LLVM.LLVMBuildCall2(
                        root.getBuilder(),
		                ((FunctionBuilder) function.getCompilerData()).getType(),
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
	
	private void dbgFunction(RlxFunction function) {
		FunctionBuilder builder = function.getCompilerData();
		if (builder == null) return;
		LLVMValueRef vr = builder.getDirect();
		LLVM.LLVMSetLinkage(vr, LLVM.LLVMExternalLinkage);
		
		LLVM.LLVMSetDLLStorageClass(vr, 2);
		builder.addAttr("dso_local");
		
		String rawName = function.getExportName();
		if (rawName == null) return;
		String safeName = rawName.replace('#', '_')
				.replace('.', '_')
				.replace("::", "_");
		LLVM.LLVMSetValueName(vr, safeName);
		LLVM.LLVMSetVisibility(vr, LLVM.LLVMDefaultVisibility);
	}
	
	@Override
	public void setupDebug() {
		for (RlxCls aClass : compiling.getClasses()) {
			for (RlxFunction function : aClass.getFunctions()) {
				if (function.getExportName() == null) {
					dbgFunction(function);
				}
			}
		}
		dbgFunction(compiling.getMainFunction());
	}
	
	@Override
	public void optimize(int backend, int rlx, boolean lowerIntrinsics) {
		LLVMOptimizer optimizer = new LLVMOptimizer();
		
//		optimizer.globalVarOpt();
//		optimizer.assumeAlignment();
		optimizer.inferAttributes();
		
		if (rlx >= 5) {
			optimizer.internalize("main");
			
			// lower intrinsics
			optimizer.lowerExpect();
			optimizer.lowerConstantIntrinsics();
			optimizer.lowerSwitch();
			optimizer.lowerAtomic();
			optimizer.simplifyControlFlow();
			optimizer.convertMem2Reg();
			optimizer.aggregatesToScalars();
			optimizer.earlyCSEMemSSA();
			optimizer.eliminateDeadCode();
			
			// IPO
			optimizer.calledValuePropagation();
			optimizer.correlatedPropagation();
			optimizer.ipSCCP();
			optimizer.globalVarOpt();
			optimizer.mergeConstants();
			optimizer.globalDCE();
			optimizer.deadArgElim();

			// force aggressive inlining
			optimizer.internalize("main");
			optimizer.partialInline();
			optimizer.alwaysInline();
			optimizer.inlineFunctions();
			optimizer.argPromotion(); // Turns pointer args into scalar args
			optimizer.mergeFunctions(); // Merges identical functions (ICF)

			// Optimize loops
			optimizer.loopClosedFormSSA();
			optimizer.loopIdiom();
			optimizer.loopRotate();
			optimizer.loopUnrollAndJam();
			optimizer.loopClosedFormSSA();
			optimizer.loopLICM();
			optimizer.loopUnswitch();
//			optimizer.loopLICM();
			optimizer.loopDeletion();
//			optimizer.loopReroll();
			optimizer.loopIndVar();
			optimizer.sink();

			// Optimize math
			optimizer.reassociate();
			optimizer.combineInstructionsAggressive();
			optimizer.gvn();
			optimizer.conditionalConstantSparsePropagation();
			optimizer.optimizeMemCpy();
			optimizer.deadStoreElim();
			optimizer.mldstMotion();
			optimizer.combineInstructions();

			// first O3
			optimizer.opt(backend);
			optimizer.sink();

			// O3 may have exposed more optimization potential
			optimizer.functionAttrs();
			optimizer.deadArgElim();
			optimizer.globalDCE();
			optimizer.mergeFunctions();

			// prepare
			optimizer.simplifyControlFlow();
			optimizer.globalVarOpt();
			optimizer.functionAttrs();
			optimizer.deadArgElim();
			optimizer.aggressiveDCE();
			optimizer.globalDCE();
			optimizer.aggregatesToScalars();
			optimizer.argPromotion();
			optimizer.calledValuePropagation();
			optimizer.correlatedPropagation();
			optimizer.ipSCCP();
			optimizer.sink();

			// hyperAggressiveOptimizer
			root.hyperAggressiveOptimizer(false, optimizer);

			// force inline
			optimizer.simplifyControlFlow();
			optimizer.internalize("main");
			optimizer.partialInline();
			optimizer.alwaysInline();
			optimizer.mergeFunctions();
			optimizer.inlineFunctions();

			// simplify
			optimizer.calledValuePropagation();
			optimizer.correlatedPropagation();
			optimizer.aggregatesToScalars();
			optimizer.functionAttrs();
			optimizer.ipSCCP();
			optimizer.deadArgElim();

			// another round
			optimizer.simplifyControlFlow();
			optimizer.aggressiveDCE();
			optimizer.stripSymbols();
			root.hyperAggressiveOptimizer(false, optimizer);

			optimizer.reassociate();
			optimizer.gvn();
			optimizer.globalVarOpt();
			optimizer.simplifyControlFlow();
			optimizer.tailCallElimination();

			optimizer.functionAttrs();
			optimizer.partialInline();
			optimizer.reassociate();
			optimizer.optimizeMemCpy();
			optimizer.functionAttrs();

			optimizer.opt(backend);
			optimizer.sink();

			// Post populate
			optimizer.slpVectorize();
			optimizer.combineInstructionsAggressive();
			optimizer.functionAttrs();
			optimizer.assumeAlignment();
			optimizer.simplifyControlFlow();
			optimizer.combineInstructionsAggressive();
			optimizer.slpVectorize();
			optimizer.stripSymbols();
		} else {
			if (rlx >= 4) {
				optimizer.functionAttrs();
				root.hyperAggressiveOptimizer(false, optimizer);
			} else {
				optimizer.simplifyControlFlow();
				optimizer.convertMem2Reg();
				optimizer.earlyCSE();
				optimizer.eliminateDeadCode();
				optimizer.mergeConstants();
				optimizer.combineInstructions();
				optimizer.simplifyControlFlow();

				if (rlx >= 1) {
					optimizer.functionAttrs();
					optimizer.simplifyControlFlow();
					optimizer.reassociate();
					optimizer.loopUnrollAndJam();
					optimizer.reassociate();
					optimizer.simplifyControlFlow();

					if (rlx >= 2) {
						if (rlx == 3) {
							optimizer.assumeAlignment();
							optimizer.earlyCSE();
							optimizer.reassociate();
							optimizer.loopRotate();
							optimizer.loopUnroll();
							optimizer.loopDeletion();
							optimizer.loopIdiom();
							optimizer.loopReroll();
							optimizer.simplifyControlFlow();
							optimizer.aggressiveDCE();
						}

						optimizer.jumpThreading();
						optimizer.loopVectorize();
						optimizer.slpVectorize();
						optimizer.gvn();
						optimizer.simplifyControlFlow();
						optimizer.combineInstructions();
					}

					optimizer.slpVectorize();
				}
			}

			optimizer.opt(backend);
		}

		if (lowerIntrinsics) {
			if (rlx >= 5) {
				optimizer.vectorizeSlp();
				optimizer.combineInstructionsAggressive();
				optimizer.assumeAlignment();
				optimizer.simplifyControlFlow();
				optimizer.stripSymbols();
				optimizer.combineInstructionsAggressive();
			}
			optimizer.lowerExpect();
			optimizer.lowerConstantIntrinsics();
		}
		
		// Create Options
		LLVMPassBuilderOptionsRef options = LLVM.LLVMCreatePassBuilderOptions();
		if (rlx >= 4) {
			LLVM.LLVMPassBuilderOptionsSetMergeFunctions(options, 1);
			LLVM.LLVMPassBuilderOptionsSetLoopInterleaving(options, 1);
			LLVM.LLVMPassBuilderOptionsSetLoopUnrolling(options, 1);
			LLVM.LLVMPassBuilderOptionsSetLoopVectorization(options, 1);
			LLVM.LLVMPassBuilderOptionsSetSLPVectorization(options, 1);
		}
		
		LLVMTargetMachineRef tm = root.getTarget();
		optimizer.invoke(root.getModule(), tm, options);
		
		LLVM.LLVMDisposePassBuilderOptions(options);
		
		if (enableVerbose) root.dump();
	}
	
	@Override
	public void prepareMachine() {
		// for mold: clang --target=x86_64-unknown-linux-gnu -c module.ll -o module.o
		// mold -m elf_x86_64 -static -o module.exe module.o
		
		root.toTargetMachine(
				new Target(
						Architecture.X86_64,
						Vendor.APPLE,
						OperatingSystem.WINDOWS,
						Environment.MSVC
				),
				CPU.GENERIC,
				LLVM.LLVMCodeGenLevelAggressive
		);
		
		try {
			PointerPointer<LLVMMemoryBufferRef> memBufPtr = root.track(new PointerPointer<>(1));
			BytePointer errMsg = new BytePointer(8);

			int result = LLVM.LLVMCreateMemoryBufferWithContentsOfFile(
					"lib/RlxRt.ll", memBufPtr, errMsg);
			if (result != 0) {
				String err = new String(errMsg.getStringBytes(), "UTF8");
				throw new RuntimeException("Failed to read file: " + err);
			}
			LLVMMemoryBufferRef memBuf = root.track(new LLVMMemoryBufferRef(root.track(memBufPtr.get(0))));

			errMsg = new BytePointer(8);
			PointerPointer<LLVMModuleRef> modulePtr = root.track(new PointerPointer<>(1));
			result = LLVM.LLVMParseIRInContext(
					root.getContext(),
					root.track(memBuf.getPointer(0)),
					modulePtr,
					errMsg
			);
			if (result != 0) {
				String err = new String(errMsg.getStringBytes(), "UTF-8");
				throw new RuntimeException("Parse failed: " + err);
			}
			LLVMModuleRef module = root.track(new LLVMModuleRef(modulePtr.get(0)));
			LLVM.LLVMLinkModules2(root.getModule(), module);
		} catch (Throwable ignored) {
			throw new RuntimeException(ignored);
		}
	}

    @Override
    public void write() {
        root.dumpToFile(new File(compiling.getName() + ".ll").getAbsolutePath());
        root.writeToFile(new File(compiling.getName() + ".obj").getAbsolutePath());
//        root.writeAssemblyToFile(new File(compiling.getName() + ".asm").getAbsolutePath());
        try {
            System.out.flush();
            System.err.flush();
//            Thread.sleep(2000);

	        Path locClang = ProgramLocator.find("clang");
			if (locClang == null) {
				System.err.println("Could not find a clang install, build may fail.");
			}
			File fl = new File(locClang.getParent().getParent() + "/lib/clang/");
	        for (File file : fl.listFiles()) {
				fl = file;
		        break;
	        }
	        
			String platform = "windows";
			
	        Linker linker = new LLD(platform);
			
			linker.addLibPath(fl + "/lib/" + platform);
			linker.addLibPath("lib");
			
//			linker.addLibrary("RlxRt");
	  
			// clang runtime
	        linker.addLibrary("clang_rt.builtins-x86_64.lib");
	        
	        for (String necessaryLibrary : CLibraries.necessaryLibraries(platform)) {
		        linker.addLibrary(necessaryLibrary);
	        }
			
//			if (platform.equals("windows")) {
//				// windows runtime
//				linker.addLibrary("user32");
//				linker.addLibrary("kernel32");
//				linker.addLibrary("advapi32");
//			}
			
			linker.release(true).debug("strip");
	        
	        linker.protectDataExecution(true)
			        .merge(".text")
			        .verbose(true)
					.useLTO(true)
			        .allowRelocations(false)
			        .incrementalLink(false)
			        .enforceControlFlow(true)
			        .protectDataExecution(true);
			
			linker
					.opt("dead_ref", true)
					.opt("comdat_folding", true)
					.opt("long_branches", true)
			;
			
			linker.entrypoint("main");
			linker.link("module.exe", "module.obj");
			
			String linkCmd = linker.buildCommand();

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
	
	public LLVMTypeRef typeData(RlxType rlxType) {
		LLVMTypeRef tr = rlxType.getCompilerData();
		if (tr != null)
			return tr;
		
		if (rlxType.type.isFloat()) {
			tr = root.getFloatType(rlxType.type.bits);
		} else {
			tr = root.getIntType(rlxType.type.bits);
		}
		
		if (rlxType.isArray()) {
//			throw new RuntimeException("TODO");
			// TODO: proper rlx array type
			tr = root.pointerType(typeData(rlxType.arrayOf));
		}
		if (rlxType.isPtr()) {
//			throw new RuntimeException("TODO");
			// TODO: allow more specific ptr type
			tr = root.pointerType(
					root.getIntType(8)
			);
		}
		
		rlxType.setCompilerData(tr);
		return tr;
	}
}
