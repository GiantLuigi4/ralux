package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.root.enums.ECompOp;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
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
import tfc.rlxir.instr.value.vars.GetInstr;
import tfc.rlxir.instr.value.vars.SetInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxType;

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
        lastVar = root.allocA(conversions.typeFor(instr.type), instr.debugName());
        if (instr.paramFrom != -1) {
            root.setValue(
                    lastVar,
                    builder.getArg(
                            instr.paramFrom,
                            conversions.typeFor(instr.type)
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

    private void compileVarSet(SetInstr instr) {
        ensureData(instr.value);
        LLVMValueRef alloc = instr.var.getCompilerData();
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
        if (!toCall.isStatic) {
            ValueInstr valueInstr = instr.params.get(0);
            LLVMValueRef obj = valueInstr.getCompilerData();
            obj  = root.ptrCast(
                    obj, root.pointerType(root.pointerType(root.VOID)), "voidptrptr"
            );
            FunctionBuilder builder1 = toCall.getCompilerData();
            // TODO: super calls
            LLVMValueRef valueRef;
            if (toCall.getExportName().equals("tfc_ralux_runtime_Object_hashCode")) {
                valueRef = root.getElement(obj, root.integer(
                        3,
                        32
                ), "get_function_hc");
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
        type.getByteSize();
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

        LLVMValueRef valueRef = root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                ((FunctionBuilder) compiler.compiling.gc.gcAllocObj.getCompilerData()).getDirect(),
                args, 2,
                "gcAllocObj"
        ));
        instr.setCompilerData(valueRef);
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
                    case CONST_JUMP -> builder.jump(((JumpInstr) instr).target.getCompilerData());
                    case COND_JUMP -> {
                        ensureData(((ConditionalJumpInstr) instr).condition);
                        builder.conditionalJump(
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
                    default -> throw new RuntimeException("NYI: " + instr.type());
                }
            }
            if (!builder.isTerminated()) builder.ret();
        }
    }
}
