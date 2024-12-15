package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.root.enums.ECompOp;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;
import tfc.ralux.compiler.frontend.ralux.RlxClassData;
import tfc.rlxir.RlxBlock;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.action.ConditionalJumpInstr;
import tfc.rlxir.instr.action.JumpInstr;
import tfc.rlxir.instr.action.ReturnInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.debug.DebugPrint;
import tfc.rlxir.instr.debug.DebugReadInt;
import tfc.rlxir.instr.debug.TwoValueDebug;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.instr.value.*;
import tfc.rlxir.instr.value.arrays.ArrayGet;
import tfc.rlxir.instr.value.arrays.ArraySet;
import tfc.rlxir.instr.value.arrays.MArrayInstr;
import tfc.rlxir.instr.value.obj.AllocInstr;
import tfc.rlxir.instr.value.obj.CallInstr;
import tfc.rlxir.instr.value.vars.*;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;

import java.util.List;

public class FunctionCompiler {
    BuilderRoot root;
    RlxCls aClass;
    RlxFunction function;
    FunctionBuilder builder;
    List<RlxBlock> blocks;
    LLVMCompiler compiler;
    LLVMConversions conversions;

    protected boolean flagHeaderVars() {
        return true;
    }

    public FunctionCompiler(
            LLVMCompiler compiler,
            LLVMConversions conversions,
            BuilderRoot root, RlxCls aClass,
            RlxFunction function, FunctionBuilder builder,
            List<RlxBlock> blocks
    ) {
        this.compiler = compiler;
        this.conversions = conversions;
        this.root = root;
        this.aClass = aClass;
        this.function = function;
        this.builder = builder;
        this.blocks = blocks;
    }

    private LLVMValueRef valConstPtr(ConstInstr<?> cst) {
        if (((Number) cst.data).longValue() == 0) {
            LLVMValueRef valueRef = root.integer(((Number) cst.data).longValue(), root.getIntType(64));
            valueRef = root.ptrCast(valueRef, conversions.VOID_PTR_PTR, "to_voidptrptr");
            return valueRef;
        }
        throw new RuntimeException("Const ptr must be 0 (null)");
    }

    protected void ensureData(ValueInstr instr) {
        if (instr.getCompilerData() != null) return;

        switch (instr.type()) {
            case CONST -> {
                ConstInstr<?> cst = (ConstInstr<?>) instr;

                cst.setCompilerData(switch (cst.valueType().type) {
                    case BYTE, SHORT, INT ->
                            root.integer(((Number) cst.data).intValue(), conversions.typeFor(cst.type));
                    case LONG, WIDE -> root.integer(((Number) cst.data).longValue(), conversions.typeFor(cst.type));
                    case HALF, FLOAT -> root.loadFloat(((Number) cst.data).floatValue(), conversions.typeFor(cst.type));
                    case DOUBLE, QUADRUPLE ->
                            root.loadFloat(((Number) cst.data).doubleValue(), conversions.typeFor(cst.type));
                    case BOOLEAN -> root.integer(((Number) cst.data).byteValue(), 1);
                    case PTR -> valConstPtr(cst);
                    default -> throw new RuntimeException("Unsupported constant type: " + cst.valueType().type);
                });
            }
            default -> throw new RuntimeException("Data not able to be ensured for instruction type " + instr.type());
        }
    }

    private void compileComp(CompareInstr instr) {
        ensureData(instr.left);
        ensureData(instr.right);

        ECompOp ecomp = ECompOp.values()[instr.op.ordinal()];
        instr.setCompilerData(
                switch (instr.variant) {
                    case SINT ->
                            root.compareInt(ecomp, instr.left.getCompilerData(), instr.right.getCompilerData(), "si_cmp");
                    case UINT ->
                            root.compareInt(ecomp, instr.left.getCompilerData(), instr.right.getCompilerData(), "ui_cmp");
                    case FLOAT ->
                            root.compareFloat(ecomp, instr.left.getCompilerData(), instr.right.getCompilerData(), "fp_cmp");
                }
        );
    }

    private void compileMath(MathInstr instr) {
        ensureData(instr.left);
        ensureData(instr.right);

        instr.setCompilerData(switch (instr.op) {
            case SUM -> switch (instr.variant) {
                case SINT -> root.sisum(instr.left.getCompilerData(), instr.right.getCompilerData(), "si_sum");
                case FLOAT -> root.fsum(instr.left.getCompilerData(), instr.right.getCompilerData(), "fp_sum");
                default -> throw new RuntimeException("NYI");
            };
            case DIFF -> switch (instr.variant) {
                case SINT -> root.sisub(instr.left.getCompilerData(), instr.right.getCompilerData(), "si_diff");
                case FLOAT -> root.fsub(instr.left.getCompilerData(), instr.right.getCompilerData(), "fp_diff");
                default -> throw new RuntimeException("NYI");
            };
            case PRODUCT -> switch (instr.variant) {
                case SINT -> root.simul(instr.left.getCompilerData(), instr.right.getCompilerData(), "si_product");
                case FLOAT -> root.fmul(instr.left.getCompilerData(), instr.right.getCompilerData(), "fp_product");
                default -> throw new RuntimeException("NYI");
            };
            case QUOTIENT -> switch (instr.variant) {
                case SINT -> root.sidiv(instr.left.getCompilerData(), instr.right.getCompilerData(), "si_quotient");
                case FLOAT -> root.fdiv(instr.left.getCompilerData(), instr.right.getCompilerData(), "fp_quotient");
                default -> throw new RuntimeException("NYI");
            };
            default -> throw new RuntimeException("NYI");
        });

        LLVMValueRef ref = instr.getCompilerData();
        root.setDebug(ref, instr);
    }

    private void compileBoolOp(BoolInstr instr) {
        ensureData(instr.left);
        ensureData(instr.right);
        instr.setCompilerData(switch (instr.op) {
            case AND -> root.and(instr.left.getCompilerData(), instr.right.getCompilerData(), "cmp_and");
            case OR -> root.or(instr.left.getCompilerData(), instr.right.getCompilerData(), "cmp_or");
            default -> throw new RuntimeException("TODO: " + instr.op);
        });
    }

    private void compileCast(CastInstr instr) {
        ensureData(instr.value);
        instr.setCompilerData(switch (instr.mode) {
            case BIT ->
                    root.bitcast(conversions.typeFor(instr.toType), instr.value.getCompilerData(), "bitcast_" + instr.value.valueType() + "_to_" + instr.toType);
            case INT_FLOAT ->
                    root.castSIToFP(conversions.typeFor(instr.toType), instr.value.getCompilerData(), "cast_si_fp_" + instr.value.valueType() + "_to_" + instr.toType);
            case FLOAT_INT ->
                    root.castFPToSI(conversions.typeFor(instr.toType), instr.value.getCompilerData(), "cast_fp_si_" + instr.value.valueType() + "_to_" + instr.toType);
            case TRUNCATE ->
                    root.truncate(conversions.typeFor(instr.toType), instr.value.getCompilerData(), "trunc_" + instr.value.valueType() + "_to_" + instr.toType);
            case EXTEND ->
                    root.extend(conversions.typeFor(instr.toType), instr.value.getCompilerData(), "zext_" + instr.value.valueType() + "_to_" + instr.toType);
            case FLOAT_FLOAT ->
                    root.castFP(conversions.typeFor(instr.toType), instr.value.getCompilerData(), "cast_fp_fp_" + instr.value.valueType() + "_to_" + instr.toType);
            case NONE -> (LLVMValueRef) instr.value.getCompilerData();
            case RLX -> (LLVMValueRef) instr.value.getCompilerData(); // TODO: maybe something
            default -> throw new RuntimeException("NYI cast mode: " + instr.mode);
        });
    }

    LLVMValueRef lastVar = null;

    private void compileVarDef(VarInstr instr) {
        boolean headerVars = flagHeaderVars() || instr.paramFrom != -1;

        BlockBuilder curr = root.getBlockBuilding();
        if (headerVars) {
            if (lastVar == null) {
                LLVMValueRef valueRef = LLVM.LLVMGetFirstInstruction(header.getDirect());
                if (valueRef != null)
                    LLVM.LLVMPositionBuilderBefore(
                            root.getBuilder(),
                            LLVM.LLVMGetFirstInstruction(header.getDirect())
                    );
                else header.enableBuilding();
            } else {
                LLVM.LLVMPositionBuilder(
                        root.getBuilder(),
                        header.getDirect(),
                        LLVM.LLVMGetNextInstruction(lastVar)
                );
            }
        }
        LLVMTypeRef ty = conversions.typeFor(instr.type);
        lastVar = root.allocA(ty, instr.debugName());
        if (instr.paramFrom != -1) {
            root.setValue(
                    lastVar,
                    builder.getArg(
                            instr.paramFrom,
                            ty
                    )
            );
        } else if (instr.type.isPtr()) {
            root.setValue(
                    lastVar,
                    root.ptrCast(
                            root.integer(0, 64),
                            ty, "to_ptr"
                    )
            );
        }
        instr.setCompilerData(lastVar);
        if (headerVars) {
            curr.enableBuilding();
        }
    }

    private void compileArrayDef(MArrayInstr instr) {
        ensureData(instr.size);
        lastVar = root.allocA(conversions.typeFor(instr.baseType), instr.size.getCompilerData(), "array_of_" + instr.baseType);
        instr.setCompilerData(lastVar);
    }

    private void deref(LLVMValueRef obj) {
        BlockBuilder nn = builder.block("non_null");
        BlockBuilder re = builder.block("resume");
        root.getBlockBuilding().conditionalJump(
                root.compareInt(
                        ECompOp.EQ,
                        root.ptrCast(obj, conversions.I64, "cast_to_int"),
                        root.integer(0, 64),
                        "non_null"
                ),
                re, nn
        );

        nn.enableBuilding();
        {
            // TODO: I wish this wasn't an rlxrt call
            FunctionBuilder builder1 = compiler.compiling.rt.rtDeref.getCompilerData();
            PointerPointer<LLVMValueRef> args = root.track(new PointerPointer<>(1));
            args.put(0, obj);
            root.track(LLVM.LLVMBuildCall(
                    root.getBuilder(),
                    builder1.getDirect(),
                    args, 1,
                    ""
            ));
        }
        nn.jump(re);

        re.enableBuilding();
    }

    private void ref(LLVMValueRef obj) {
        BlockBuilder nn = builder.block("non_null");
        BlockBuilder re = builder.block("resume");
        root.getBlockBuilding().conditionalJump(
                root.compareInt(
                        ECompOp.EQ,
                        root.ptrCast(obj, conversions.I64, "cast_to_int"),
                        root.integer(0, 64),
                        "non_null"
                ),
                re, nn
        );

        nn.enableBuilding();
        {
            FunctionBuilder builder1 = compiler.compiling.rt.rtRef.getCompilerData();
            PointerPointer<LLVMValueRef> args = root.track(new PointerPointer<>(1));
            args.put(0, obj);
            root.track(LLVM.LLVMBuildCall(
                    root.getBuilder(),
                    builder1.getDirect(),
                    args, 1,
                    ""
            ));
        }
        nn.jump(re);

        re.enableBuilding();
    }

    private void compileVarSet(SetInstr instr) {
        ensureData(instr.value);
        LLVMValueRef alloc = instr.var.getCompilerData();
        if (instr.value.valueType().isPtr()) {
            ref(instr.value.getCompilerData());
        }
        if (instr.var.type.isPtr()) {
            LLVMValueRef oldRef = root.getValue(alloc, "get_old_var");
            deref(oldRef);
        }
        root.setValue(alloc, instr.value.getCompilerData());
    }

    private void compileVarGet(GetInstr instr) {
        if (instr.var == null)
            throw new RuntimeException(instr.var.debugName() + "'s  variable has not been defined yet. Wrong block order?");

        instr.setCompilerData(
                root.getValue(
                        instr.var.getCompilerData(),
                        "get_" + instr.var.debugName()
                )
        );
    }

    BlockBuilder header;

    protected void stubBlocks() {
        for (RlxBlock block : blocks) {
            if (block.getCompilerData() != null)
                continue;

            RlxBlock target = block.getRedir();
            if (target.getCompilerData() != null) {
                block.setCompilerData(target.getCompilerData());
            } else {
                block.setCompilerData(builder.block(target.name));
                target.setCompilerData(block.getCompilerData());
                if (header == null) header = block.getCompilerData();
            }
        }
    }

    private void compileArrayGet(ArrayGet instr) {
        ensureData(instr.array);
        ensureData(instr.index);

        LLVMValueRef array = instr.array.getCompilerData();
        LLVMValueRef index = instr.index.getCompilerData();
        instr.setCompilerData(root.getValue(array, index, "get_value"));
    }

    private void compileArraySet(ArraySet instr) {
        ensureData(instr.array);
        ensureData(instr.index);
        ensureData(instr.value);

        LLVMValueRef array = instr.array.getCompilerData();
        LLVMValueRef index = instr.index.getCompilerData();
        LLVMValueRef value = instr.value.getCompilerData();
        root.setValue(array, index, value);
        instr.setCompilerData(value);
    }

    private void compileNegation(NegInstr instr) {
        ensureData(instr.source);
        LLVMValueRef valueRef = instr.source.getCompilerData();
        if (instr.valueType().type.isFloat()) {
            instr.setCompilerData(LLVM.LLVMBuildFNeg(
                    root.getBuilder(),
                    valueRef,
                    "negate_float"
            ));
        } else {
            instr.setCompilerData(LLVM.LLVMBuildNeg(
                    root.getBuilder(),
                    valueRef,
                    "negate_int"
            ));
        }
    }

    private LLVMValueRef extractFunctionPtr(CallInstr instr, RlxFunction toCall) {
        if (!toCall.isStatic && !instr.overrideStatic) {
            ValueInstr valueInstr = instr.params.get(0);
            LLVMValueRef obj = valueInstr.getCompilerData();
            FunctionBuilder builder1 = toCall.getCompilerData();
            LLVMTypeRef tr = root.pointerType(root.pointerType(root.BYTE_TYPE));
            obj = root.ptrCast(obj, tr, "yipee");
            // TODO: super calls
            LLVMValueRef valueRef;
            if (toCall.getExportName().equals("tfc_ralux_runtime_Object_hashCode")) {
                valueRef = obj;
                PointerPointer args = new PointerPointer(1);
                args.put(0, root.integer(2, 64));
                valueRef = root.track(LLVM.LLVMBuildGEP(
                        root.getBuilder(),
                        valueRef,
                        args, 1,
                        "then_gep"
                ));
            } else {
                throw new RuntimeException("TODO");
            }
            valueRef = root.ptrCast(valueRef, root.pointerType(root.pointerType(builder1.getType())), "ptr_to_func");
            return root.getValue(valueRef, "get_function");
        }
        FunctionBuilder builder1 = instr.toCall.getCompilerData();
        return builder1.getDirect();
    }

    private void compileCall(CallInstr instr) {
        LLVMValueRef valueRef = extractFunctionPtr(instr, instr.toCall);

        String callName = "";
        if (!instr.toCall.enclosure.isVoid())
            callName = "call_" + compiler.exportNameFor(instr.owner, instr.toCall);

        int argC = instr.params.size();
        PointerPointer<LLVMValueRef> args = root.track(new PointerPointer<>(argC));
        for (int i = 0; i < argC; i++) {
            ValueInstr param = instr.params.get(i);
            ensureData(param);
            args.put(i, param.getCompilerData());
        }
        LLVMValueRef callVal = root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                valueRef,
                args, argC,
                callName
        ));

        instr.setCompilerData(callVal);
    }

    private void compileAlloc(AllocInstr instr) {
        RlxType type = instr.type;
        PointerPointer<LLVMValueRef> noArg = new PointerPointer<>(0);
        PointerPointer<LLVMValueRef> args = new PointerPointer<>(2);
        root.track(args);
        root.track(noArg);

        LLVMValueRef gc = root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                ((FunctionBuilder) compiler.compiling.rt.rtGlobalGC.getCompilerData()).getDirect(),
                noArg, 0,
                "getGC"
        ));
        args.put(0, gc);
        args.put(1, root.integer(type.getByteSizeObj(), 32));
        args.put(2, root.track(
                LLVM.LLVMBuildCall(
                        root.getBuilder(),
                        ((FunctionBuilder)((RlxClassData)instr.type.clazz.getCompilerData()).loadFunc).getDirect(),
                        noArg, 0,
                        ""
                )
        ));

        LLVMValueRef valueRef = root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                ((FunctionBuilder) compiler.compiling.gc.gcAllocObj.getCompilerData()).getDirect(),
                args, 3,
                "gcAllocObj"
        ));
        instr.setCompilerData(valueRef);
    }

    protected LLVMValueRef extractField(LLVMValueRef obj, LLVMTypeRef type, int offset) {
        LLVMTypeRef tr = root.pointerType(type);
        // TODO: super calls
        LLVMValueRef valueRef = obj;
        // TODO: GEP?
        valueRef = root.ptrCast(valueRef, root.getIntType(64), "cast_to_long");
        valueRef = root.sisum(valueRef, root.integer(offset + RlxCls.OBJ_BASE, 64), "offset_ptr");
        valueRef = root.toPtr(valueRef, tr, "ensure_ptr");
        return valueRef;
    }

    private void compileFieldGet(FieldGetInstr instr) {
        FieldInstr instr1 = instr.var;
        int offset = instr1.owner.clazz.getFieldOffset(instr1.field);

        ValueInstr dataBase = instr1.base;
        if (dataBase != null) {
            LLVMValueRef base = dataBase.getCompilerData();
            LLVMValueRef value = extractField(base, conversions.typeFor(instr1.type), offset);
            instr.setCompilerData(root.getValue(value, "get_field_data"));
        } else throw new RuntimeException("Static field NYI");
    }

    private void compileFieldSet(FieldSetInstr instr) {
        ensureData(instr.value);

        FieldInstr instr1 = instr.var;
        int offset = instr1.owner.clazz.getFieldOffset(instr1.field);

        ValueInstr dataBase = instr1.base;
        if (dataBase != null) {
            LLVMValueRef base = dataBase.getCompilerData();
            LLVMValueRef value = extractField(base, conversions.typeFor(instr1.type), offset);
            root.setValue(value, instr.value.getCompilerData());
        } else throw new RuntimeException("Static field NYI");
    }

    public void compile() {
        stubBlocks();

        for (RlxBlock block : blocks) {
            if (compiler.enableVerbose)
                System.out.println("- " + block.name);

            // block has no purpose
            if (block.getRedir() != block)
                continue;

            BlockBuilder builder = block.getCompilerData();
            builder.enableBuilding();
            for (RlxInstr instr : block.getInstructions()) {
                switch (instr.type()) {
                    case CONST -> throw new RuntimeException("Consts shouldn't show up in functions");
                    case MATH -> compileMath((MathInstr) instr);
                    case COMPARISON -> compileComp((CompareInstr) instr);
                    case CAST -> compileCast((CastInstr) instr);
                    case RETURN_VOID -> root.getBlockBuilding().ret();
                    case RETURN_VALUE -> {
                        ReturnInstr ret = (ReturnInstr) instr;
                        ensureData(ret.valueInstr);
                        root.getBlockBuilding().ret(ret.valueInstr.getCompilerData());
                    }
                    case NOP -> {/* nothing to do */}
                    case DEFINE_VAR -> compileVarDef((VarInstr) instr);
                    case SET_VAR -> compileVarSet((SetInstr) instr);
                    case GET_VAR -> compileVarGet((GetInstr) instr);
                    case CONST_JUMP -> root.getBlockBuilding().jump(((JumpInstr) instr).target.getCompilerData());
                    case COND_JUMP -> {
                        ensureData(((ConditionalJumpInstr) instr).condition);
                        root.getBlockBuilding().conditionalJump(
                                ((ConditionalJumpInstr) instr).condition.getCompilerData(),
                                ((ConditionalJumpInstr) instr).targetTrue.getCompilerData(),
                                ((ConditionalJumpInstr) instr).targetFalse.getCompilerData()
                        );
                    }
                    case DEBUG_PRINT -> {
                        DebugPrint print = (DebugPrint) instr;
                        ensureData(print.value);
                        LLVMValueRef str;
                        if (print.value.valueType().isArray()) {
                            str = print.value.getCompilerData();
                        } else
                            str = root.stdLib.intToString(root.getIntType(print.printType().type.bits), print.value.getCompilerData());
                        root.stdLib.print(str);
                    }
                    case DEBUG_READ_INT -> {
                        LLVMValueRef value = root.stdLib.readInt(((DebugReadInt) instr).type.type.bits);
                        instr.setCompilerData(value);
                    }
                    case DEBUG_HAS_INPUT -> {
                        instr.setCompilerData(root.stdLib.hasInput(
                                this.builder
                        ));
                    }
                    case DEBUG_RANDOM -> {
                        ensureData(((TwoValueDebug) instr).left);
                        ensureData(((TwoValueDebug) instr).right);
                        instr.setCompilerData(root.stdLib.random(
                                ((TwoValueDebug) instr).left.getCompilerData(),
                                ((TwoValueDebug) instr).right.getCompilerData()
                        ));
                    }
                    case MAKE_ARRAY -> compileArrayDef((MArrayInstr) instr);
                    case ARRAY_GET -> compileArrayGet((ArrayGet) instr);
                    case ARRAY_SET -> compileArraySet((ArraySet) instr);
                    case BOOLEAN_OP -> compileBoolOp((BoolInstr) instr);
                    case NEGATE -> compileNegation((NegInstr) instr);
                    case CALL -> compileCall((CallInstr) instr);
                    case ALLOC -> compileAlloc((AllocInstr) instr);

                    case GET_FIELD -> compileFieldGet((FieldGetInstr) instr);
                    case SET_FIELD -> compileFieldSet((FieldSetInstr) instr);
                    default -> throw new RuntimeException("NYI: " + instr.type());
                }
            }
            if (!root.getBlockBuilding().isTerminated()) root.getBlockBuilding().ret();
        }
    }
}
