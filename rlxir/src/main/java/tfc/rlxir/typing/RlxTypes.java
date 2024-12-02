package tfc.rlxir.typing;

import java.util.Collections;
import java.util.List;

public class RlxTypes {
    public static final RlxType VOID = new RlxType(PrimitiveType.VOID);
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
    public static final RlxType VOID_PTR = new RlxType(RlxTypes.VOID);
    public static final RlxType VOID_PTR_PTR = new RlxType(RlxTypes.VOID_PTR);
    public static final RlxType OBJ = VOID_PTR_PTR;
    public static final List<RlxType> EMPTY_LIST = Collections.emptyList();
    public static final RlxType[] INTS = new RlxType[]{BYTE, SHORT, INT, LONG, WIDE};
    public static final RlxType[] FLOATS = new RlxType[]{HALF, FLOAT, DOUBLE, QUADRUPLE};

    public static RlxType FLOATING_POINT(int bytes) {
        return switch (bytes) {
            case 2 -> HALF;
            case 4 -> FLOAT;
            case 8 -> DOUBLE;
            case 16 -> QUADRUPLE;
            default -> throw new RuntimeException("Invalid byte count for float: " + bytes);
        };
    }

    public static RlxType INTEGER(int bytes) {
        return switch (bytes) {
            case 1 -> BYTE;
            case 2 -> SHORT;
            case 4 -> INT;
            case 8 -> LONG;
            case 16 -> WIDE;
            default -> throw new RuntimeException("Invalid byte count for float: " + bytes);
        };
    }

    public static RlxType typeByName(String text) {
        return switch (text) {
            case "void" -> VOID;
            case "byte" -> BYTE;
            case "int" -> INT;
            case "short" -> SHORT;
            case "long" -> LONG;
            case "wide" -> WIDE;
            case "half" -> HALF;
            case "float" -> FLOAT;
            case "double" -> DOUBLE;
            case "quadruple" -> QUADRUPLE;
            case "boolean" -> BOOLEAN;
            case "char" -> CHAR;
            default -> throw new RuntimeException("Unknown data type " + text);
        };
    }
}
