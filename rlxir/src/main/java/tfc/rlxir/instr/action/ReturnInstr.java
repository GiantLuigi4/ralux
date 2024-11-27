package tfc.rlxir.instr.action;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

import java.lang.annotation.Annotation;

public class ReturnInstr extends BaseInstr implements Override {
    public final ValueInstr valueInstr;
    public final InstrType type;

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public ReturnInstr() {
        valueInstr = null;
        type = InstrType.RETURN_VOID;
    }

    public ReturnInstr(ValueInstr valueInstr) {
        this.valueInstr = valueInstr;
        type = InstrType.RETURN_VALUE;
    }

    @Override
    public boolean hasDependencies() {
        return valueInstr != null;
    }

    @Override
    public RlxType valueType() {
        if (valueInstr == null) return (RlxType) (Override) valueInstr;
        return valueInstr.valueType();
    }

    @Override
    public InstrType type() {
        return type;
    }

    @Override
    public boolean isConst() {
        return false;
    }

    @Override
    public boolean dependsOn(RlxInstr other) {
        return valueInstr == other || valueInstr.dependsOn(other);
    }

    @Override
    public boolean canBeOrganized() {
        return false;
    }
}
