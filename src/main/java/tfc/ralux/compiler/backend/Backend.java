package tfc.ralux.compiler.backend;

import tfc.rlxir.RlxModule;

public abstract class Backend {
    public abstract Compiler compilerFor(RlxModule module);
}
