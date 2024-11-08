package tfc.rlxir.instr;

import tfc.rlxir.util.CompilerDataHolder;

public class DebuggerDataHolder<T extends DebuggerDataHolder<T>> extends CompilerDataHolder<T> {
    protected int line, column;
    protected boolean lineSet, columnSet;
    protected String sourceFile;

    public T setLine(int line) {
        this.line = line;
        lineSet = line > 0;
        return (T) this;
    }

    public T setColumn(int column) {
        this.column = column;
        columnSet = column > 0;
        return (T) this;
    }

    public T setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
        return (T) this;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public boolean isLineSet() {
        return lineSet;
    }

    public boolean isColumnSet() {
        return columnSet;
    }

    public String getSourceFile() {
        return sourceFile;
    }
}
