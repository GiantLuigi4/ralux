package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.llvm.LLVM.LLVMBasicBlockRef;
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
import tfc.rlxir.instr.value.BoolInstr;
import tfc.rlxir.instr.value.CastInstr;
import tfc.rlxir.instr.value.CompareInstr;
import tfc.rlxir.instr.value.MathInstr;
import tfc.rlxir.instr.value.arrays.ArrayGet;
import tfc.rlxir.instr.value.arrays.ArraySet;
import tfc.rlxir.instr.value.arrays.MArrayInstr;
import tfc.rlxir.instr.value.vars.GetInstr;
import tfc.rlxir.instr.value.vars.SetInstr;
import tfc.rlxir.instr.value.vars.VarInstr;

import java.util.List;

public class FunctionCompiler {
    BuilderRoot root;
    RlxCls aClass;
    RlxFunction function;
    FunctionBuilder builder;
    List<RlxBlock> blocks;
    LLVMConversions conversions;

    protected boolean flagHeaderVars() {
        return true;
    }

    public FunctionCompiler(
            LLVMConversions conversions,
            BuilderRoot root, RlxCls aClass,
            RlxFunction function, FunctionBuilder builder,
            List<RlxBlock> blocks
    ) {
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
            block.setCompilerData(builder.block(block.name));
            if (header == null) header = block.getCompilerData();
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

    public void compile() {
        stubBlocks();

        for (RlxBlock block : blocks) {
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
                        } else str = root.stdLib.intToString(root.getIntType(32), print.value.getCompilerData());
                        root.stdLib.print(str);
                    }
                    case DEBUG_READ_INT -> {
                        LLVMValueRef value = root.stdLib.readInt();
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
                    default -> throw new RuntimeException("NYI: " + instr.type());
                }
            }
            if (!builder.isTerminated()) builder.ret();
        }
    }
}
