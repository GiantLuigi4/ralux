package tfc.ralux.compiler.backend;

public abstract class Compiler {
    public abstract void stub();

    public abstract void compile();

    public Compiler verbose() {
        return this;
    }
}
