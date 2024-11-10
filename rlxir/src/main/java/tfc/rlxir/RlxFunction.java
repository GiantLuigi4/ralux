package tfc.rlxir;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.action.ConditionalJumpInstr;
import tfc.rlxir.instr.action.JumpInstr;
import tfc.rlxir.instr.action.ReturnInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.debug.DebugPrint;
import tfc.rlxir.instr.debug.DebugReadInt;
import tfc.rlxir.instr.enumeration.CastOp;
import tfc.rlxir.instr.enumeration.CompareOp;
import tfc.rlxir.instr.enumeration.MathOp;
import tfc.rlxir.instr.value.CastInstr;
import tfc.rlxir.instr.value.CompareInstr;
import tfc.rlxir.instr.value.MathInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.PrimitiveType;
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

    List<RlxBlock> blocks = new ArrayList<>();
    RlxBlock currentBlock;

    public RlxBlock makeBlock(String name) {
        RlxBlock block = new RlxBlock(name);
        blocks.add(block);
        return block;
    }

    public void buildBlock(RlxBlock block) {
        this.currentBlock = block;
    }

    String exportName;

    public RlxFunction exportName(String name) {
        this.exportName = name;
        return this;
    }

    public String getExportName() {
        return exportName;
    }

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

    public void addInstr(RlxInstr instr) {
        if (currentBlock == null) {
            currentBlock = new RlxBlock("entry");
            blocks.add(currentBlock);
        }
        currentBlock.instrs.add(instr);
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

    public ValueInstr autoCast(ValueInstr value, RlxType toType) {
        ValueInstr lv = value;
        CastOp op = lv.valueType().valueCastOp(toType);
        RlxType coercionType = lv.valueType();
        if (op != CastOp.NONE) {
            coercionType = lv.valueType().coercionType(toType);
            if (lv.valueType() != coercionType) {
                lv = new CastInstr(lv, coercionType, op);
                addInstr(lv);
            }
        }
        return lv;
    }

    public void ret(ValueInstr var) {
        addInstr(new ReturnInstr(autoCast(var, enclosure.result)));
        currentBlock = null;
    }

    public void ret(VarInstr var) {
        ret(var.get());
    }

    public void ret() {
        addInstr(new ReturnInstr());
        currentBlock = null;
    }

    public List<RlxBlock> getBlocks() {
        // TODO: read only list
        return blocks;
    }

    public void jump(RlxBlock target) {
        currentBlock.instrs.add(new JumpInstr(target));
        currentBlock = target;
    }

    public void jumpIf(ValueInstr instr, RlxBlock targetTrue, RlxBlock targetFalse) {
        if (instr.valueType().type != PrimitiveType.BOOLEAN)
            throw new RuntimeException("A branch condition must be a boolean.");

        currentBlock.instrs.add(new ConditionalJumpInstr(instr, targetTrue, targetFalse));
        currentBlock = targetFalse;
    }

    public <T, V> MathInstr sum(ValueInstr left, ValueInstr right) {
        ValueInstr lv = left;
        ValueInstr rv = right;

        RlxType coercionType = lv.valueType().coercionType(rv.valueType());
        CastOp op = lv.valueType().valueCastOp(rv.valueType());
        if (lv.valueType() != coercionType) {
            lv = new CastInstr(lv, coercionType, op);
            addInstr(lv);
        }
        op = lv.valueType().valueCastOp(rv.valueType());
        if (rv.valueType() != coercionType) {
            rv = new CastInstr(rv, coercionType, op);
            addInstr(rv);
        }

        MathInstr res;

        addInstr(res = new MathInstr(
                MathOp.SUM, coercionType.mathVariant(),

                lv, rv
        ));
//        if (res.isConst()) {
//            return res.eval();
//        }
        return res;
    }

    public CompareInstr compare(CompareOp op, ValueInstr left, ValueInstr right) {
        ValueInstr lv = left;
        ValueInstr rv = right;

        RlxType coercionType = lv.valueType().coercionType(rv.valueType());
        CastOp cop = lv.valueType().valueCastOp(coercionType);
        if (lv.valueType() != coercionType) {
            lv = new CastInstr(lv, coercionType, cop);
            addInstr(lv);
        }
        cop = rv.valueType().valueCastOp(coercionType);
        if (rv.valueType() != coercionType) {
            rv = new CastInstr(rv, coercionType, cop);
            addInstr(rv);
        }

        CompareInstr res;

        addInstr(res = new CompareInstr(
                op, coercionType.mathVariant(),

                lv, rv
        ));
//        if (res.isConst()) {
//            return res.eval();
//        }
        return res;
    }

    public ValueInstr cast(ValueInstr value, RlxType toType) {
        if (value.valueType().equals(toType)) return value;

        CastInstr instr = new CastInstr(value, toType, true);
        addInstr(instr);
        return instr;
    }

    public void print(ValueInstr integer) {
        DebugPrint print = new DebugPrint(integer);
        addInstr(print);
    }

    public ValueInstr readInt() {
        DebugReadInt ri = new DebugReadInt();
        addInstr(ri);
        return ri;
    }
}
