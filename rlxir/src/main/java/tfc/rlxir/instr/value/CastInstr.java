package tfc.rlxir.instr.value;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.enumeration.CastOp;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.instr.base.ValueInstr;

public class CastInstr extends ValueInstr {
    public final ValueInstr value;
    public final RlxType toType;
    public final CastOp mode;

    public CastInstr(ValueInstr value, RlxType toType, boolean valueCast) {
        this.value = value;
        this.toType = toType;
        if (valueCast) {
            this.mode = value.valueType().valueCastOp(toType);
        } else {
            this.mode = value.valueType().bitCastOp(toType);
        }
    }

    public CastInstr(ValueInstr value, RlxType toType, CastOp mode) {
        this.value = value;
        this.toType = toType;
        this.mode = mode;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        return toType;
    }

    public RlxType fromType() {
        return value.valueType();
    }

    @Override
    public InstrType type() {
        return InstrType.CAST;
    }

    public CastOp castMode() {
        return mode;
    }

    @Override
    public boolean isConst() {
        return value.isConst();
    }

    @Override
    public boolean isZero() {
        return value.isZero();
    }

    @Override
    public boolean isOne() {
        return value.isOne();
    }

    @Override
    public boolean dependsOn(RlxInstr other) {
        return other == value || value.dependsOn(other);
    }
}
