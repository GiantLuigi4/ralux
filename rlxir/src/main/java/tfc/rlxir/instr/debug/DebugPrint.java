package tfc.rlxir.instr.debug;

import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.PrimitiveType;

public class DebugPrint extends BaseInstr {
    public final ValueInstr value;

    public DebugPrint(ValueInstr toPrint) {
        if (
                toPrint.valueType().type != PrimitiveType.INT
        ) {
            if (
                    !(toPrint.valueType().isArray() &&
                            toPrint.valueType().debox().type == PrimitiveType.BYTE)
            ) {
                throw new RuntimeException("For simplicity reasons, debug print is only available for integers and byte arrays.");
            }
        }
        this.value = toPrint;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public InstrType type() {
        return InstrType.DEBUG_PRINT;
    }

    @Override
    public boolean isConst() {
        return false;
    }
}
