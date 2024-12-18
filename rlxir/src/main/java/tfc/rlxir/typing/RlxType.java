package tfc.rlxir.typing;

import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxField;
import tfc.rlxir.instr.enumeration.CastOp;
import tfc.rlxir.instr.enumeration.MathVariant;
import tfc.rlxir.util.CompilerDataHolder;

import java.util.Objects;

public class RlxType extends CompilerDataHolder<RlxType> {
    public final PrimitiveType type;
    public final RlxCls clazz;
    public final RlxType arrayOf;

    public RlxType(PrimitiveType type) {
        this.type = type;
        this.clazz = null;
        this.arrayOf = null;
    }

    public RlxType(RlxCls cls) {
        this.type = PrimitiveType.PTR;
        this.clazz = cls;
        this.arrayOf = null;
    }

    public RlxType(RlxType arrayOf) {
        this.type = PrimitiveType.PTR;
        this.clazz = null; // TODO: array class
        this.arrayOf = arrayOf;
    }

    public static RlxType array(RlxType baseType) {
        return new RlxType(baseType);
    }

    /**
     * Deboxes an rlx type
     * Example: array types will get the base type
     *
     * @return the deboxed type
     */
    public RlxType debox() {
        if (arrayOf == null) return this;
        return arrayOf;
    }

    public CastOp valueCastOp(RlxType toType) {
        if (type == toType.type) {
            if (this == RlxTypes.VOID_PTR_PTR &&
                    this.clazz == null
            ) {
                return CastOp.RLX;
            }
            return CastOp.NONE;
        }


        if (type == RlxTypes.BOOLEAN.type) {
            if (toType.type.typ == 'i') return CastOp.EXTEND;
            if (toType.type.typ == 'f') return CastOp.INT_FLOAT;
            throw new RuntimeException("TODO");
        } else if (toType == RlxTypes.BOOLEAN) return CastOp.NONE;

        if (type.typ == toType.type.typ && type.typ == 'i') {
            if (type.bits < toType.type.bits) {
                return CastOp.EXTEND;
            } else if (type.bits == toType.type.bits) {
                throw new RuntimeException("Should already have been handled...");
            } else {
                return CastOp.TRUNCATE;
            }
        } else if (type.typ == toType.type.typ && type.typ == 'f') {
            if (type.bits != toType.type.bits)
                return CastOp.FLOAT_FLOAT;
            throw new RuntimeException("Should already have been handled...");
        } else if (type.typ == 'i' && toType.type.typ == 'f') {
            return CastOp.INT_FLOAT;
        } else if (type.typ == 'f' && toType.type.typ == 'i') {
            return CastOp.FLOAT_INT;
        }
        throw new RuntimeException("Illegal cast");
    }

    public CastOp bitCastOp(RlxType toType) {
        if (type == toType.type) return CastOp.NONE;

        if (type == RlxTypes.BOOLEAN.type) {
            if (toType.type.typ == 'i') return CastOp.EXTEND;
            if (toType.type.typ == 'f') return CastOp.BIT;
            throw new RuntimeException("TODO");
        } else if (toType == RlxTypes.BOOLEAN) return CastOp.NONE;

        if (type.bits < toType.type.bits) {
            return CastOp.EXTEND;
        } else if (type.bits == toType.type.bits) {
            return CastOp.BIT;
        } else {
            return CastOp.TRUNCATE;
        }
    }

    public boolean isOperable(RlxType rlxType) {
        return rlxType.type == this.type;
    }

    @Override
    public String toString() {
        if (isArray()) {
            return "[" + arrayOf.toString() + "]";
        }
        if (type == PrimitiveType.PTR) return clazz.qualifiedName();
        return type.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RlxType type1 = (RlxType) object;
        return type == type1.type && Objects.equals(clazz, type1.clazz) && Objects.equals(arrayOf, type1.arrayOf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, clazz, arrayOf);
    }

    public boolean isAssignableFrom(RlxType rlxType) {
        if (type == rlxType.type) {
            if (rlxType == RlxTypes.VOID_PTR_PTR &&
                    rlxType.clazz == null
            ) return true;

            if (this == RlxTypes.VOID_PTR_PTR &&
                    this.clazz == null
            ) return true;
        }

        if (rlxType.type.typ == 'i' && type.typ == 'i') {
            if (rlxType.type.bits <= type.bits) {
                return true;
            }
        }
        if (rlxType.type.typ == 'f' && type.typ == 'f') {
            if (rlxType.type.bits <= type.bits) {
                return true;
            }
        }
        if (rlxType.type.typ == 'i' && type.typ == 'f') {
            if (rlxType.type.bits <= type.bits) {
                return true;
            }
        }
        if (rlxType.type.typ == 'f' && type.typ == 'i') {
            if (rlxType.type.bits <= type.bits) {
                return true;
            }
        }
        // TODO:
        return this == rlxType;
    }

    public RlxType coercionType(RlxType rlxType) {
        if (this == rlxType) return this;

        // TODO: incompatibility checking for bools
        if (this.type == PrimitiveType.BOOLEAN) return rlxType;
        if (rlxType.type == PrimitiveType.BOOLEAN) return this;

        if (rlxType.type.bits >= this.type.bits) {
            if (this.type.typ == 'f' && rlxType.type.typ == 'f')
                return rlxType;
            if (this.type.typ == 'i' && rlxType.type.typ == 'i')
                return rlxType;

            if (this.type.typ == 'f' && rlxType.type.typ == 'i')
                return RlxTypes.FLOATING_POINT(rlxType.type.bytes);
            if (this.type.typ == 'i' && rlxType.type.typ == 'f')
                return RlxTypes.FLOATING_POINT(rlxType.type.bytes);
        }
        if (this.type.bits >= rlxType.type.bits) {
            if (this.type.typ == 'f' && rlxType.type.typ == 'f')
                return this;
            if (this.type.typ == 'i' && rlxType.type.typ == 'i')
                return this;

            if (this.type.typ == 'f' && rlxType.type.typ == 'i')
                return this;
            if (this.type.typ == 'i' && rlxType.type.typ == 'f')
                return RlxTypes.FLOATING_POINT(this.type.bytes);
        }
        throw new RuntimeException("Unsupported coercion: " + this + " to " + rlxType);
    }

    public MathVariant mathVariant() {
        return switch (type.typ) {
            case 'i' -> MathVariant.SINT;
            case 'c' -> MathVariant.UINT;
            case 'f' -> MathVariant.FLOAT;
            default -> throw new RuntimeException("Math unsupported for " + this);
        };
    }

    public boolean isArray() {
        return arrayOf != null;
    }

    public int getByteSizeObj() {
        if (isArray()) return 8;
        if (type == PrimitiveType.PTR) {
            if (clazz != null) {
                int sz = 0;
                for (RlxField field : clazz.getFields())
                    sz += field.type.getElementByteSize();
                return sz;
            }

            // TODO: should be total size of instance fields (and function ptrs)
            return 0;
        }
        return type.bytes;
    }

    public int getElementByteSize() {
        return type.bytes;
    }

    public boolean isPtr() {
        return clazz != null;
    }
}
