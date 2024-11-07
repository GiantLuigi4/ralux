package tfc.rlxir;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.action.ReturnInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.CastOp;
import tfc.rlxir.instr.enumeration.MathOp;
import tfc.rlxir.instr.value.CastInstr;
import tfc.rlxir.instr.value.MathInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.util.CompilerDataHolder;

import java.util.ArrayList;
import java.util.List;

public class RlxFunction extends CompilerDataHolder<RlxFunction> {
    // 0: private, 1: protected, 2: public, 3: package protected
    public final int access;
    public final boolean isStatic;
    public final boolean isFinal;
    public final RlxEnclosure enclosure;

    List<RlxInstr> instrs = new ArrayList<>();

    public RlxFunction(int access, boolean isStatic, boolean isFinal, RlxEnclosure enclosure) {
        this.access = access;
        this.isStatic = isStatic;
        this.isFinal = isFinal;
        this.enclosure = enclosure;
    }

    public boolean attachesToObj(RlxCls clz) {
        if (clz.isFunctionInherited(this)) {
            return true;
        }
        if (isStatic || isFinal || access == 0)
            return false;
        return true;
    }

    public boolean staticReferrable() {
        return isStatic || isFinal || access == 0;
    }

    public <T, V> MathInstr sum(ValueInstr left, ValueInstr right) {
        ValueInstr lv = left;
        ValueInstr rv = right;
        CastOp op = lv.valueType().valueCastOp(rv.valueType());
        RlxType coercionType = lv.valueType();
        if (op != CastOp.NONE) {
            coercionType = lv.valueType().coercionType(rv.valueType());
            if (lv.valueType() != coercionType)
                lv = new CastInstr(lv, coercionType, op);
            if (rv.valueType() != coercionType)
                rv = new CastInstr(rv, coercionType, op);
        }
        MathInstr res;
        addInstr(res = new MathInstr(
                MathOp.SUM, coercionType.mathVariant(),
                lv, rv
        ));
        if (res.isConst()) {
            return res.eval();
        }
        return res;
    }

    public void addInstr(RlxInstr instr) {
        instrs.add(instr);
        instr.setFunction(this);
    }

    public VarInstr makeVar(RlxType rlxType) {
        VarInstr instr = new VarInstr(rlxType);
        addInstr(instr);
        return instr;
    }

    public VarInstr makeVar(RlxType rlxType, ValueInstr value) {
        VarInstr instr = makeVar(rlxType);
        instr.set(value);
        return instr;
    }

    public VarInstr makeVar(ValueInstr value) {
        VarInstr instr = makeVar(value.valueType());
        instr.set(value);
        return instr;
    }

    public void ret(ValueInstr var) {
        addInstr(new ReturnInstr(var));
        endBlock();
    }

    public void ret(VarInstr var) {
        addInstr(new ReturnInstr(var.get()));
        endBlock();
    }

    public void ret() {
        addInstr(new ReturnInstr());
        endBlock();
    }

    private void endBlock() {
        // TODO:
    }

    public List<RlxInstr> getInstructions() {
        // TODO: read only list
        return instrs;
    }
}
