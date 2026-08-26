package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.javacpp.Loader;
import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.rlxir.RlxModule;

import static org.bytedeco.llvm.global.LLVM.*;

public class RLXToLLVM extends Backend {
    static {
	    LLVMInitializeAllTargetInfos();
	    LLVMInitializeNativeTarget();
	    LLVMInitializeNativeAsmPrinter();
        LLVMInitializeAllTargets();
        LLVMInitializeAllAsmPrinters();
	    LLVMInitializeAllAsmParsers();
    }

    @Override
    public Compiler compilerFor(RlxModule module) {
        return new LLVMCompiler(module);
    }
}
