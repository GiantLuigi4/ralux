package tfc.rlxir.typing;

import java.util.Collections;
import java.util.List;

public class RlxTypes {
    public static final RlxType BOOLEAN = new RlxType(PrimitiveType.BOOLEAN);
    public static final RlxType CHAR = new RlxType(PrimitiveType.CHAR);
    public static final RlxType BYTE = new RlxType(PrimitiveType.BYTE);
    public static final RlxType INT = new RlxType(PrimitiveType.INT);
    public static final RlxType SHORT = new RlxType(PrimitiveType.SHORT);
    public static final RlxType LONG = new RlxType(PrimitiveType.LONG);
    public static final RlxType WIDE = new RlxType(PrimitiveType.WIDE);
    public static final RlxType HALF = new RlxType(PrimitiveType.HALF);
    public static final RlxType FLOAT = new RlxType(PrimitiveType.FLOAT);
    public static final RlxType DOUBLE = new RlxType(PrimitiveType.DOUBLE);
    public static final RlxType QUADRUPLE = new RlxType(PrimitiveType.QUADRUPLE);
    public static final List<RlxType> EMPTY_LIST = Collections.emptyList();

    public static RlxType FP(int bytes) {
        return switch (bytes) {
            case 2 -> HALF;
            case 4 -> FLOAT;
            case 8 -> DOUBLE;
            case 16 -> QUADRUPLE;
            default -> throw new RuntimeException("Invalid byte count for float: " + bytes);
        };
    }
}
