package tfc.rlxir.instr.value;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

public class NegInstr extends ValueInstr {
    public final ValueInstr source;

    public NegInstr(ValueInstr source) {
        this.source = source;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        return source.valueType();
    }

    @Override
    public InstrType type() {
        return InstrType.NEGATE;
    }

    @Override
    public boolean isConst() {
        return source.isConst();
    }

    @Override
    public boolean dependsOn(RlxInstr other) {
        return source == other || source.dependsOn(other);
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
