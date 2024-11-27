package tfc.rlxir.instr.value.arrays;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

public class ArrayGet extends ValueInstr {
    public final ValueInstr array;
    public final ValueInstr index;

    public ArrayGet(
            ValueInstr array,
            ValueInstr index
    ) {
        this.array = array;
        this.index = index;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        return array.valueType().debox();
    }

    @Override
    public InstrType type() {
        return InstrType.ARRAY_GET;
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
        return other == array || other == index || array.dependsOn(other) || index.dependsOn(other);
    }

    @Override
    public boolean canBeOrganized() {
        return false;
    }
}
