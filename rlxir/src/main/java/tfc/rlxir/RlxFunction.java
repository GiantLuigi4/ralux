package tfc.rlxir;

import tfc.rlxir.comphints.FunctionCompilerHint;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.action.ConditionalJumpInstr;
import tfc.rlxir.instr.action.JumpInstr;
import tfc.rlxir.instr.action.ReturnInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.debug.DebugHasInput;
import tfc.rlxir.instr.debug.DebugPrint;
import tfc.rlxir.instr.debug.DebugReadInt;
import tfc.rlxir.instr.debug.TwoValueDebug;
import tfc.rlxir.instr.enumeration.*;
import tfc.rlxir.instr.value.*;
import tfc.rlxir.instr.value.arrays.ArrayGet;
import tfc.rlxir.instr.value.arrays.ArraySet;
import tfc.rlxir.instr.value.arrays.MArrayInstr;
import tfc.rlxir.instr.value.obj.AllocInstr;
import tfc.rlxir.instr.value.obj.CallInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.GenericType;
import tfc.rlxir.typing.PrimitiveType;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;
import tfc.rlxir.util.CompilerDataHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class RlxFunction extends CompilerDataHolder<RlxFunction> {
    public static final int ACC_PRIVATE = 0;
    public static final int ACC_PROTECTED = 1;
    public static final int ACC_PUBLIC = 2;
    public static final int ACC_PKG_PROTECTED = 3;

    // 0: private, 1: protected, 2: public, 3: package protected
    public final int access;
    public final boolean isStatic;
    public final boolean isFinal;
    public final RlxEnclosure enclosure;

    List<RlxBlock> blocks = new ArrayList<>();
    List<FunctionCompilerHint> compilerHints = new ArrayList<>();
    List<FunctionCompilerHint> processedCompilerHints = new ArrayList<>();
    RlxBlock currentBlock;

    public RlxBlock makeBlock(String name) {
        RlxBlock block = new RlxBlock(name);
        blocks.add(block);
        return block;
    }

    public void buildBlock(RlxBlock block) {
        if (block.isTerminated())
            throw new RuntimeException("Block has already been terminated, cannot be continued.");
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

    public VarInstr param(RlxType type, int index) {
        VarInstr instr = new VarInstr(type, index);
        addInstr(instr);
        return instr;
    }

    public VarInstr makeVar(RlxType rlxType) {
        VarInstr instr = new VarInstr(rlxType);
        addInstr(instr);
        return instr;
    }

    public VarInstr makeVar(RlxType rlxType, ValueInstr value) {
        VarInstr instr = makeVar(rlxType);
        instr.set(this, value);
        return instr;
    }

    public VarInstr makeVar(ValueInstr value) {
        VarInstr instr = makeVar(value.valueType());
        instr.set(this, value);
        return instr;
    }

    public ValueInstr autoCast(ValueInstr value, RlxType toType) {
        ValueInstr lv = value;
        CastOp op = lv.valueType().valueCastOp(toType);
        RlxType coercionType;
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
        currentBlock.terminate();
        currentBlock = null;
    }

    public void ret(VarInstr var) {
        ret(var.get(this));
    }

    public void ret() {
        addInstr(new ReturnInstr());
        currentBlock.terminate();
        currentBlock = null;
    }

    public List<RlxBlock> getBlocks() {
        // TODO: read only list
        return blocks;
    }

    public void jump(RlxBlock target) {
        currentBlock.instrs.add(new JumpInstr(target));
        currentBlock.terminate();
        currentBlock = target;
    }

    public void jumpIf(ValueInstr instr, RlxBlock targetTrue, RlxBlock targetFalse) {
        if (instr.valueType().type != PrimitiveType.BOOLEAN)
            throw new RuntimeException("A branch condition must be a boolean.");

        currentBlock.instrs.add(new ConditionalJumpInstr(instr, targetTrue, targetFalse));
        currentBlock.terminate();
        currentBlock = targetFalse;
    }

    public <T, V> ValueInstr sum(ValueInstr left, ValueInstr right) {
        ValueInstr lv = left;
        ValueInstr rv = right;

        RlxType coercionType = lv.valueType().coercionType(rv.valueType());
        CastOp op = lv.valueType().valueCastOp(coercionType);
        if (lv.valueType() != coercionType) {
            lv = new CastInstr(lv, coercionType, op);
            addInstr(lv);
        }
        op = rv.valueType().valueCastOp(coercionType);
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

    public <T, V> ValueInstr sub(ValueInstr left, ValueInstr right) {
        ValueInstr lv = left;
        ValueInstr rv = right;

        RlxType coercionType = lv.valueType().coercionType(rv.valueType());
        CastOp op = lv.valueType().valueCastOp(coercionType);
        if (lv.valueType() != coercionType) {
            lv = new CastInstr(lv, coercionType, op);
            addInstr(lv);
        }
        op = rv.valueType().valueCastOp(coercionType);
        if (rv.valueType() != coercionType) {
            rv = new CastInstr(rv, coercionType, op);
            addInstr(rv);
        }

        MathInstr res;

        addInstr(res = new MathInstr(
                MathOp.DIFF, coercionType.mathVariant(),
                lv, rv
        ));
//        if (res.isConst()) {
//            return res.eval();
//        }
        return res;
    }

    public ValueInstr mul(ValueInstr left, ValueInstr right) {
        ValueInstr lv = left;
        ValueInstr rv = right;

        RlxType coercionType = lv.valueType().coercionType(rv.valueType());
        CastOp op = lv.valueType().valueCastOp(coercionType);
        if (lv.valueType() != coercionType) {
            lv = new CastInstr(lv, coercionType, op);
            addInstr(lv);
        }
        op = rv.valueType().valueCastOp(coercionType);
        if (rv.valueType() != coercionType) {
            rv = new CastInstr(rv, coercionType, op);
            addInstr(rv);
        }

        MathInstr res;

        addInstr(res = new MathInstr(
                MathOp.PRODUCT, coercionType.mathVariant(),
                lv, rv
        ));
//        if (res.isConst()) {
//            return res.eval();
//        }
        return res;
    }

    public ValueInstr div(ValueInstr left, ValueInstr right) {
        ValueInstr lv = left;
        ValueInstr rv = right;

        RlxType coercionType = lv.valueType().coercionType(rv.valueType());
        CastOp op = lv.valueType().valueCastOp(coercionType);
        if (lv.valueType() != coercionType) {
            lv = new CastInstr(lv, coercionType, op);
            addInstr(lv);
        }
        op = rv.valueType().valueCastOp(coercionType);
        if (rv.valueType() != coercionType) {
            rv = new CastInstr(rv, coercionType, op);
            addInstr(rv);
        }

        MathInstr res;

        addInstr(res = new MathInstr(
                MathOp.QUOTIENT, coercionType.mathVariant(),
                lv, rv
        ));
//        if (res.isConst()) {
//            return res.eval();
//        }
        return res;
    }

    public ValueInstr booleanOp(BooleanOp booleanOp, ValueInstr left, ValueInstr right) {
        BoolInstr instr = new BoolInstr(booleanOp, left, right);
        addInstr(instr);
        return instr;
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
        if (instr.mode == CastOp.NONE) return value;
        addInstr(instr);
        return instr;
    }

    public ValueInstr cast(ValueInstr value, RlxType toType, CastOp op) {
        if (value.valueType().equals(toType)) return value;

        CastInstr instr = new CastInstr(value, toType, op);
        addInstr(instr);
        return instr;
    }

    public void print(ValueInstr data) {
        DebugPrint print = new DebugPrint(data);
        addInstr(print);
    }

    public ValueInstr readInt(RlxType type) {
        DebugReadInt ri = new DebugReadInt(type);
        addInstr(ri);
        return ri;
    }

    public ValueInstr readInt() {
        return readInt(RlxTypes.INT);
    }

    public ValueInstr random(ValueInstr min, ValueInstr max) {
        TwoValueDebug ri = new TwoValueDebug(InstrType.DEBUG_RANDOM, min, max);
        addInstr(ri);
        return ri;
    }

    public ValueInstr array(ValueInstr size, RlxType type) {
        MArrayInstr arrayInstr = new MArrayInstr(size, type);
        addInstr(arrayInstr);
        return arrayInstr;
    }

    public ValueInstr arrayGet(ValueInstr arrayData, ValueInstr index) {
        ArrayGet get = new ArrayGet(arrayData, index);
        addInstr(get);
        return get;
    }

    public void fori(
            CompareOp op,
            VarInstr variable,
            ValueInstr end,
            ValueInstr step,
            Consumer<RlxBlock> bodyBuilder
    ) {
        RlxBlock header = makeBlock("header");
        RlxBlock body = makeBlock("body");
        RlxBlock exit = makeBlock("exit");

        jump(header);
        ValueInstr value = variable.get(this);
        ValueInstr cmp = compare(op, value, end);
        jumpIf(cmp, body, exit);

        buildBlock(body);
        bodyBuilder.accept(body);
        value = variable.get(this);
        variable.set(this, sum(
                value, step
        ));
        if (!body.isTerminated())
            jump(header);

        buildBlock(exit);
    }

    public void ifC(ValueInstr condition, Consumer<RlxBlock> bodyBuilder) {
        RlxBlock body = makeBlock("body");
        RlxBlock escape = makeBlock("escape");
        jumpIf(condition, body, escape);
        buildBlock(body);
        bodyBuilder.accept(body);
        if (!body.isTerminated()) jump(escape);
        else buildBlock(escape);
    }

    public ValueInstr arraySet(ValueInstr array, ValueInstr index, ValueInstr data) {
        ArraySet set = new ArraySet(array, index, data);
        addInstr(set);
        return set;
    }

    public ValueInstr negate(ValueInstr instr) {
        NegInstr neg = new NegInstr(instr);
        addInstr(neg);
        return neg;
    }

    public RlxBlock currentBlock() {
        return currentBlock;
    }

    public boolean isBlockActive() {
        if (currentBlock == null) return false;
        if (currentBlock.isTerminated()) return false;
        return true;
    }

    public ValueInstr hasInput() {
        DebugHasInput hasInput = new DebugHasInput();
        addInstr(hasInput);
        return hasInput;
    }

    public RlxBlock firstBlock() {
        return blocks.get(0);
    }

    public void ensureEntry() {
        if (blocks.isEmpty()) {
            buildBlock(makeBlock("entry"));
        }
    }

    public ValueInstr call(
            RlxModule module, RlxCls owner,
            String name, List<ValueInstr> params
    ) {
        RlxFunction candidate = module.findMethod(owner, name, params);
        params = candidate.enclosure.castArgs(this, params);
        CallInstr instr = new CallInstr(module, candidate, owner, name, params);
        addInstr(instr);
        return instr;
    }

    public ValueInstr assignmentCast(ValueInstr instr, RlxType type) {
        if (instr.valueType().equals(type)) return instr;

        // coerce types
        if (type.isAssignableFrom(instr.valueType())) {
            CastOp cast = instr.valueType().valueCastOp(type);
            if (cast != CastOp.NONE) {
                instr = cast(instr, type, cast);
                return instr;
            }
            return instr;
        }
        throw new RuntimeException(instr.valueType() + " cannot be assigned to " + type);
    }

    public void defineGeneric(String generic, GenericType type) {
        throw new RuntimeException("TODO");
    }

    public void addHints(RlxCls owner, List<FunctionCompilerHint> compilerHints) {
        for (FunctionCompilerHint compilerHint : compilerHints) {
            compilerHint.preprocess(owner, this);
            this.compilerHints.add(compilerHint);
        }
    }

    public ValueInstr alloc(RlxType type1) {
        AllocInstr instr = new AllocInstr(type1);
        addInstr(instr);
        return instr;
    }
}
