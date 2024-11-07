package tfc.rlxir.instr.value.vars;

import tfc.rlxir.RlxBranch;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

public class VarInstr extends BaseInstr {
    public final RlxType type;

    public VarInstr(RlxType type) {
        this.type = type;
    }

    public void set(ValueInstr value) {
        if (!type.isOperable(value.valueType())) {
            throw new RuntimeException(type + " cannot be set as a " + value.valueType() + ". Are you missing a cast?");
        }
        function.addInstr(new SetInstr(this, value));
    }

    public ValueInstr get() {
        return new GetInstr(this);
    }

    @Override
    public boolean hasDependencies() {
        return false;
    }

    @Override
    public InstrType type() {
        return InstrType.DEFINE_VAR;
    }

    @Override
    public boolean isConst() {
        return false;
    }
}
