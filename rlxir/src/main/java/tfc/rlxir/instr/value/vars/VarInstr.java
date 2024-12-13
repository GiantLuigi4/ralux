package tfc.rlxir.instr.value.vars;

import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

public class VarInstr extends BaseInstr {
    public final RlxType type;
    public final int paramFrom;
    String debugName = "var";

    public VarInstr(RlxType type) {
        this.type = type;
        this.paramFrom = -1;
    }

    public VarInstr(RlxType type, int paramFrom) {
        this.type = type;
        this.paramFrom = paramFrom;
    }

    public VarInstr setDebugName(String debugName) {
        this.debugName = debugName;
        return this;
    }

    public void set(ValueInstr value) {
        if (type != value.valueType()) {
            throw new RuntimeException(type + " variable cannot be set as a " + value.valueType() + ". Are you missing a cast?");
        }
        function.addInstr(new SetInstr(this, value));
    }

    public ValueInstr get(RlxFunction function) {
        if (function != this.function) throw new RuntimeException("Cannot get var from another function");
        return get();
    }

    @Deprecated(forRemoval = true)
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

    @Override
    public boolean dependsOn(RlxInstr other) {
        return true;
    }

    @Override
    public boolean canBeOrganized() {
        return false;
    }
}
