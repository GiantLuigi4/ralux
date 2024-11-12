package tfc.rlxir.instr.value.arrays;

import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

public class MArrayInstr extends ValueInstr {
    public final ValueInstr size;
    public final RlxType baseType;

    public MArrayInstr(ValueInstr size, RlxType baseType) {
        this.size = size;
        this.baseType = baseType;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        return RlxType.array(baseType);
    }

    @Override
    public InstrType type() {
        return InstrType.MAKE_ARRAY;
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
