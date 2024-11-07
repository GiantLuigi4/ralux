import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxEnclosure;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.RlxModule;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.instr.value.MathInstr;
import tfc.rlxir.instr.value.vars.GetInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxTypes;

public class RLXIRTest {
    public static void main(String[] args) {
        RlxModule module = new RlxModule("module");
        RlxCls cls = new RlxCls("TestClass");
        module.addClass(cls);
        RlxFunction function = new RlxFunction(
                3, true, false,
                new RlxEnclosure(RlxTypes.INT, "main", RlxTypes.EMPTY_LIST)
        );
        cls.addFunction(function);
        ConstInstr<Integer> CONST_2 = new ConstInstr<>(2, RlxTypes.INT);
        ConstInstr<Integer> CONST_4 = new ConstInstr<>(4, RlxTypes.INT);

        MathInstr sum = function.sum(CONST_2, CONST_4);
        VarInstr var = function.makeVar(sum.valueType(), sum);

        ValueInstr val = var.get();
        MathInstr sum1 = function.sum(val, CONST_4);
        var.set(sum1);

        System.out.println(function);
    }
}
