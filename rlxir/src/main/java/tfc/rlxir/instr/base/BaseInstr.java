package tfc.rlxir.instr.base;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.typing.RlxType;

public abstract class BaseInstr extends RlxInstr {
    @Override
    public boolean providesValue() {
        return false;
    }

    @Override
    public RlxType valueType() {
        return null;
    }
}
