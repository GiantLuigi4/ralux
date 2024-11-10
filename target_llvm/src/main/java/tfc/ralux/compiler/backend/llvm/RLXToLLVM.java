package tfc.ralux.compiler.backend.llvm;

import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.rlxir.RlxModule;

import static org.bytedeco.llvm.global.LLVM.*;

public class RLXToLLVM extends Backend {
    static {
        LLVMInitializeNativeTarget();
        LLVMInitializeNativeAsmPrinter();
        LLVMInitializeAllTargets();
        LLVMInitializeAllAsmPrinters();
    }

    @Override
    public Compiler compilerFor(RlxModule module) {
        return new LLVMCompiler(module);
    }
}
