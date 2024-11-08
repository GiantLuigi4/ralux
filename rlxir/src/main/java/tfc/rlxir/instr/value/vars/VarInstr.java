package tfc.rlxir.instr.value.vars;

import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

public class VarInstr extends BaseInstr {
    public final RlxType type;
    String debugName = "var";

    public VarInstr(RlxType type) {
        this.type = type;
    }

    public VarInstr setDebugName(String debugName) {
        this.debugName = debugName;
        return this;
    }

    public void set(ValueInstr value) {
        if (!type.isOperable(value.valueType())) {
            throw new RuntimeException(type + " variable cannot be set as a " + value.valueType() + ". Are you missing a cast?");
        }
        function.addInstr(new SetInstr(this, value));
    }

    public ValueInstr get() {
        GetInstr instr = new GetInstr(this);
        function.addInstr(instr);
        return instr;
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

    public String debugName() {
        return debugName;
    }
}
