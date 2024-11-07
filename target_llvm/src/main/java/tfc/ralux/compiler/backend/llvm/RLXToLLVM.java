package tfc.ralux.compiler.backend.llvm;

import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.rlxir.RlxModule;

public class RLXToLLVM extends Backend {
    @Override
    public Compiler compilerFor(RlxModule module) {
        return new LLVMCompiler(module);
    }
}
