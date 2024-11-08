package tfc.rlxir.util;

import tfc.rlxir.instr.RlxInstr;

public abstract class CompilerDataHolder<V extends CompilerDataHolder<V>> {
    private Object compilerData;

    public <T> T getCompilerData() {
        return (T) compilerData;
    }

    public <T> V setCompilerData(T compilerData) {
        this.compilerData = compilerData;
        return (V) this;
    }
}
