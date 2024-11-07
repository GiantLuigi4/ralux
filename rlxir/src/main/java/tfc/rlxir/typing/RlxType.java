package tfc.rlxir.typing;

import tfc.rlxir.RlxCls;
import tfc.rlxir.instr.enumeration.CastOp;
import tfc.rlxir.instr.enumeration.MathVariant;
import tfc.rlxir.util.CompilerDataHolder;

import java.util.Objects;

public class RlxType extends CompilerDataHolder<RlxType> {
    public final PrimitiveType type;
    public final RlxCls clazz;

    public RlxType(PrimitiveType type) {
        this.type = type;
        this.clazz = null;
    }

    public RlxType(RlxCls cls) {
        this.type = PrimitiveType.PTR;
        this.clazz = cls;
    }

    public CastOp valueCastOp(RlxType toType) {
        if (type == toType.type) return CastOp.NONE;

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
        if (type == PrimitiveType.PTR) return clazz.qualifiedName();
        return type.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RlxType rlxType = (RlxType) object;
        return type == rlxType.type && Objects.equals(clazz, rlxType.clazz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, clazz);
    }

    public boolean isAssignableFrom(RlxType rlxType) {
        // TODO:
        return this == rlxType;
    }

    public RlxType coercionType(RlxType rlxType) {
        if (this == rlxType) return this;
        else throw new RuntimeException("TODO: type coercions");
    }

    public MathVariant mathVariant() {
        return switch (type.typ) {
            case 'i' -> MathVariant.SINT;
            case 'c' -> MathVariant.UINT;
            case 'f' -> MathVariant.FLOAT;
            default -> throw new RuntimeException("Math unsupported for " + this);
        };
    }
}
