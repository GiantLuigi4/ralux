package tfc.rlxir.instr.global;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.instr.base.ValueInstr;

public class ConstInstr<T> extends ValueInstr {
    public final T data;
    public final RlxType type;

    public ConstInstr(T data, RlxType type) {
        this.data = data;
        this.type = type;
    }

    @Override
    public boolean hasDependencies() {
        return false;
    }

    @Override
    public RlxType valueType() {
        return type;
    }

    @Override
    public InstrType type() {
        return InstrType.CONST;
    }

    @Override
    public boolean isConst() {
        return true;
    }

    // TODO: check? lol
    @Override
    public boolean isZero() {
        return data.equals(0);
    }

    @Override
    public boolean isOne() {
        return data.equals(1);
    }

    @Override
    public boolean dependsOn(RlxInstr other) {
        return false;
    }
}
