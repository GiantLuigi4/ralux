package tfc.rlxir.instr.base;

import tfc.rlxir.instr.RlxInstr;

public abstract class ValueInstr extends RlxInstr {
    @Override
    public boolean providesValue() {
        return true;
    }

    public abstract boolean isZero();
    public abstract boolean isOne();
}
