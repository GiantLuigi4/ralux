package tfc.rlxir.instr.value.obj;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

public class AllocInstr extends ValueInstr {
    public boolean detachFromGC;
    public final RlxType type;

    public AllocInstr(RlxType type) {
        this.type = type;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        return type;
    }

    @Override
    public InstrType type() {
        return InstrType.ALLOC;
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
    public boolean isZero() {
        return false;
    }

    @Override
    public boolean isOne() {
        return false;
    }
}
