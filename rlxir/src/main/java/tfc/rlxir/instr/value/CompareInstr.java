package tfc.rlxir.instr.value;

import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.CompareOp;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.instr.enumeration.MathVariant;
import tfc.rlxir.typing.PrimitiveType;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;

public class CompareInstr extends ValueInstr {
    public final CompareOp op;
    public final MathVariant variant;
    public final ValueInstr left;
    public final ValueInstr right;

    public CompareInstr(
            CompareOp op,
            MathVariant variant,
            ValueInstr left,
            ValueInstr right
    ) {
        this.op = op;
        this.variant = variant;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        return RlxTypes.BOOLEAN;
    }

    @Override
    public InstrType type() {
        return InstrType.COMPARISON;
    }

    @Override
    public boolean isConst() {
        return left.isConst() && right.isConst();
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public boolean isOne() {
        return false;
    }

    public ValueInstr eval() {
        // TODO:
        return this;
    }
}
