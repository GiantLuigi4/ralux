package tfc.rlxir.instr.value.vars;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;

public class SetInstr extends BaseInstr {
    public final VarInstr var;
    public final ValueInstr value;

    public SetInstr(VarInstr var, ValueInstr value) {
        this.var = var;
        this.value = value;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public InstrType type() {
        return InstrType.SET_VAR;
    }

    @Override
    public boolean isConst() {
        return false;
    }

    @Override
    public boolean dependsOn(RlxInstr other) {
        return value == other || value.dependsOn(other);
    }

    @Override
    public boolean canBeOrganized() {
        return false;
    }
}
