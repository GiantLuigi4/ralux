package tfc.ralux.compiler.frontend;

import tfc.rlxir.RlxModule;

public abstract class Translator {
    public abstract void parse(RlxModule module, String file);
}
