package tfc.rlxir.instr.value.vars;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

public class GetInstr extends ValueInstr {
    public final VarInstr var;

    public GetInstr(VarInstr var) {
        this.var = var;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        return var.type;
    }

    @Override
    public InstrType type() {
        return InstrType.GET_VAR;
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
