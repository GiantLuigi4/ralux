package tfc.rlxir.typing;

import tfc.rlxir.util.CompilerDataHolder;
import tfc.rlxir.util.CompilerDataReference;

public enum PrimitiveType {
    VOID(-1, 'v'),

    PTR(8, 'p'),

    CHAR(2, 'c'),
    BOOLEAN(0, 'i'), BYTE(1, 'i'), SHORT(2, 'i'), INT(4, 'i'), LONG(8, 'i'), WIDE(16, 'i'),
    HALF(2, 'f'), FLOAT(4, 'f'), DOUBLE(8, 'f'), QUADRUPLE(16, 'f');

    public final int bits;
    public final char typ;
    public final CompilerDataReference compilerData = new CompilerDataReference();

    PrimitiveType(int bytes, char typ) {
        if (bytes == 0) this.bits = 1;
        else this.bits = bytes << 3;
        this.typ = typ;
    }

    @Override
    public String toString() {
        return switch (typ) {
            case 'i' -> "int" + bits;
            case 'f' -> "float" + bits;
            case 'c' -> "char" + bits;
            case 'v' -> "void";
            case 'p' -> "pointer";
            default -> throw new RuntimeException("qhat");
        };
    }
}
