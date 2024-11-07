package ir_to_ir;

import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.RLXToLLVM;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxEnclosure;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.RlxModule;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.instr.value.MathInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxTypes;

public class Test {
    public static void main(String[] args) {
        Backend backend = new RLXToLLVM();

        RlxModule module = new RlxModule("module");
        RlxCls cls = new RlxCls("TestClass");
        module.addClass(cls);
        RlxFunction function = new RlxFunction(
                3, true, false,
                new RlxEnclosure(RlxTypes.INT, "testFunction", RlxTypes.EMPTY_LIST)
        );
        cls.addFunction(function);

        ConstInstr<Integer> CONST_5 = new ConstInstr<>(5, RlxTypes.INT);
        ConstInstr<Integer> CONST_3 = new ConstInstr<>(3, RlxTypes.INT);
        MathInstr sum = function.sum(CONST_5, CONST_3);

//        VarInstr var = function.makeVar(sum);
//        var.set(function.sum(var.get(), CONST_3));
//        function.ret(var);
        function.ret(sum);

        Compiler compiler = backend.compilerFor(module);
        compiler.verbose();
        compiler.stub();
        compiler.compile();
    }
}
