package tfc.rlxir.instr.value.arrays;

import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

public class ArraySet extends ValueInstr {
    public final ValueInstr array;
    public final ValueInstr index;
    public final ValueInstr value;

    public ArraySet(
            ValueInstr array,
            ValueInstr index,
            ValueInstr value
    ) {
        if (!array.valueType().debox().isOperable(value.valueType())) {
            throw new RuntimeException(array.valueType() + "'s elements are not able to be set as a " + value.valueType() + ". Are you missing a cast?");
        }
        this.array = array;
        this.index = index;
        this.value = value;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        return value.valueType();
    }

    @Override
    public InstrType type() {
        return InstrType.ARRAY_SET;
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
}
