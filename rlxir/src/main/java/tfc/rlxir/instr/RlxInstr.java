package tfc.rlxir.instr;

import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.util.CompilerDataHolder;

public abstract class RlxInstr extends DebuggerDataHolder<RlxInstr> {
    protected RlxFunction function;
    public abstract boolean hasDependencies();
    public abstract boolean providesValue();
    public abstract RlxType valueType();
    public abstract InstrType type();
    public abstract boolean isConst();
    public abstract boolean dependsOn(RlxInstr other);

    public boolean canBeOrganized() {
        return true;
    }

    public RlxInstr setFunction(RlxFunction function) {
        if (this.function != null) throw new RuntimeException("Instructions cannot be reassigned between functions.");
        this.function = function;
        return this;
    }

    public RlxFunction getFunction() {
        return function;
    }
}
