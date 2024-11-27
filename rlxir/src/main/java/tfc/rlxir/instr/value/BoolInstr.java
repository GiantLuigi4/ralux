package tfc.rlxir.instr.value;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.BooleanOp;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;

public class BoolInstr extends ValueInstr {
    public final BooleanOp op;
    public final ValueInstr left, right;

    public BoolInstr(BooleanOp op, ValueInstr left, ValueInstr right) {
        this.op = op;
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
        return InstrType.BOOLEAN_OP;
    }

    @Override
    public boolean isConst() {
        // TODO: impl
        return false;
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public boolean isOne() {
        return false;
    }

    @Override
    public boolean dependsOn(RlxInstr other) {
        return left == other || right == other || left.dependsOn(other) || right.dependsOn(other);
    }
}
