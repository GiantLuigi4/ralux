package tfc.rlxir.instr.debug;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.PrimitiveType;
import tfc.rlxir.typing.RlxType;

public class DebugWriteString extends BaseInstr {
    public final ValueInstr value;

    public DebugWriteString(ValueInstr toPrint) {
		RlxType type = toPrint.valueType();
		if (!type.isArray()) throw new RuntimeException("Can only print a char[] with writeString");
		if (type.arrayOf.type != PrimitiveType.CHAR) throw new RuntimeException("Can only print a char[] with writeString");
		this.value = toPrint;
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public InstrType type() {
        return InstrType.DEBUG_WRITE;
    }

    @Override
    public boolean isConst() {
        return false;
    }

    @Override
    public boolean dependsOn(RlxInstr other) {
        return other == value || value.dependsOn(other);
    }

    @Override
    public boolean canBeOrganized() {
        return false;
    }
}
