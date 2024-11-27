package tfc.rlxir.instr.action;

import tfc.rlxir.RlxBlock;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.enumeration.InstrType;

public class JumpInstr extends BaseInstr {
    public final RlxBlock target;

    public JumpInstr(RlxBlock target) {
        this.target = target;
    }

    @Override
    public boolean hasDependencies() {
        return false;
    }

    @Override
    public InstrType type() {
        return InstrType.CONST_JUMP;
    }

    @Override
    public boolean isConst() {
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
