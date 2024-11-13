package tfc.rlxir.instr.debug;

import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;

public class TwoValueDebug extends ValueInstr {
    InstrType type;
    public final ValueInstr left, right;

    public TwoValueDebug(InstrType type, ValueInstr left, ValueInstr right) {
        this.type = type;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        return RlxTypes.INT;
    }

    @Override
    public InstrType type() {
        return type;
    }

    @Override
    public boolean isConst() {
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
}
