package tfc.rlxir.instr.debug;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;

public class DebugHasInput extends ValueInstr {
    @Override
    public boolean hasDependencies() {
        return false;
    }

    @Override
    public RlxType valueType() {
        return RlxTypes.BOOLEAN;
    }

    @Override
    public InstrType type() {
        return InstrType.DEBUG_HAS_INPUT;
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

    @Override
    public boolean dependsOn(RlxInstr other) {
        return false;
    }

    @Override
    public boolean canBeOrganized() {
        return false;
    }
}
