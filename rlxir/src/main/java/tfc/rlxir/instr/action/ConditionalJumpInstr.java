package tfc.rlxir.instr.action;

import tfc.rlxir.RlxBlock;
import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;

public class ConditionalJumpInstr extends BaseInstr {
    public final ValueInstr condition;
    public final RlxBlock targetTrue;
    public final RlxBlock targetFalse;

    public ConditionalJumpInstr(ValueInstr condition, RlxBlock targetTrue, RlxBlock targetFalse) {
        this.condition = condition;
        this.targetTrue = targetTrue;
        this.targetFalse = targetFalse;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public InstrType type() {
        return InstrType.COND_JUMP;
    }

    @Override
    public boolean isConst() {
        return false;
    }
}
