package tfc.rlxir.instr.value.obj;

import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.RlxModule;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.typing.RlxType;

import java.util.List;

public class CallInstr extends ValueInstr {
    public final RlxCls owner;
    public final String name;
    public final List<ValueInstr> params;
    public final RlxModule module;
    public final RlxFunction toCall;

    public CallInstr(RlxModule module, RlxCls owner, String name, List<ValueInstr> params) {
        this.module = module;
        this.owner = owner;
        this.name = name;
        this.params = params;
        this.toCall = module.findMethod(owner, name, params);
    }

    public CallInstr(RlxModule module, RlxFunction toCall, RlxCls owner, String name, List<ValueInstr> params) {
        this.module = module;
        this.owner = owner;
        this.name = name;
        this.params = params;
        this.toCall = toCall;
    }

    @Override
    public boolean hasDependencies() {
        return !params.isEmpty();
    }

    @Override
    public RlxType valueType() {
        return toCall.enclosure.result;
    }

    @Override
    public InstrType type() {
        return InstrType.CALL;
    }

    @Override
    public boolean isConst() {
        return false;
    }

    @Override
    public boolean dependsOn(RlxInstr other) {
        for (ValueInstr instr : params) if (instr == other) return true;
        for (ValueInstr instr : params) if (instr.dependsOn(other)) return true;
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
