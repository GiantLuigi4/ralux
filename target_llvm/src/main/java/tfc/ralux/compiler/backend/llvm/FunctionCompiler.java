package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.llvm.LLVM.LLVMValueRef;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.action.ReturnInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.instr.value.MathInstr;
import tfc.rlxir.instr.value.vars.GetInstr;
import tfc.rlxir.instr.value.vars.SetInstr;
import tfc.rlxir.instr.value.vars.VarInstr;

import java.util.List;

public class FunctionCompiler {
    BuilderRoot root;
    RlxCls aClass;
    RlxFunction function;
    FunctionBuilder builder;
    List<RlxInstr> instrs;
    LLVMConversions conversions;

    public FunctionCompiler(
            LLVMConversions conversions,
            BuilderRoot root, RlxCls aClass,
            RlxFunction function, FunctionBuilder builder,
            List<RlxInstr> instrs
    ) {
        this.conversions = conversions;
        this.root = root;
        this.aClass = aClass;
        this.function = function;
        this.builder = builder;
        this.instrs = instrs;
    }

    protected void ensureData(ValueInstr instr) {
        if (instr.getCompilerData() != null) return;

        switch (instr.type()) {
            case CONST -> {
                ConstInstr<?> cst = (ConstInstr<?>) instr;

                cst.setCompilerData(switch (cst.valueType().type) {
                    case BYTE, SHORT, INT -> root.integer((int) cst.data, conversions.typeFor(cst.type));
                    case LONG, WIDE -> root.integer((long) cst.data, conversions.typeFor(cst.type));
                    case HALF, FLOAT -> root.loadFloat((float) cst.data, conversions.typeFor(cst.type));
                    case DOUBLE, QUADRUPLE -> root.loadFloat((double) cst.data, conversions.typeFor(cst.type));
                    default -> throw new RuntimeException("Unsupported constant type: " + cst.valueType().type);
                });
            }
            default -> throw new RuntimeException("Data not able to be ensured for instruction type " + instr.type());
        }
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

    private void compileVarDef(VarInstr instr) {
        // TODO: compiler flag for put var defs in function header
        instr.setCompilerData(root.allocA(conversions.typeFor(instr.type), instr.debugName()));
    }

    private void compileVarSet(SetInstr instr) {
        LLVMValueRef alloc = instr.var.getCompilerData();
        ensureData(instr.value);
        root.setValue(alloc, instr.value.getCompilerData());
    }

    private void compileVarGet(GetInstr instr) {
        instr.setCompilerData(
                root.getValue(
                        instr.var.getCompilerData(),
                        "get_" + instr.var.debugName()
                )
        );
    }

    public void compile() {
        BlockBuilder block = builder.block("entry");
        block.enableBuilding();
        for (RlxInstr instr : instrs) {
            switch (instr.type()) {
                case CONST -> throw new RuntimeException("Consts shouldn't show up in functions");
                case MATH -> compileMath((MathInstr) instr);
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
                default -> throw new RuntimeException("NYI: " + instr.type());
            }
        }
        if (!block.isTerminated()) block.ret();
    }
}
