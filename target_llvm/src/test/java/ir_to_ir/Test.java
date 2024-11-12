package ir_to_ir;

import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.RLXToLLVM;
import tfc.ralux.compiler.util.Pair;
import tfc.rlxir.*;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.CompareOp;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.instr.value.CompareInstr;
import tfc.rlxir.instr.value.MathInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxTypes;

public class Test {
    protected static Pair<ValueInstr, ValueInstr> getDir(RlxFunction function, ValueInstr instr) {
        ConstInstr<Integer> CONST_1N = new ConstInstr<>(-1, RlxTypes.INT);
        ConstInstr<Integer> CONST_0 = new ConstInstr<>(0, RlxTypes.INT);
        ConstInstr<Integer> CONST_1 = new ConstInstr<>(1, RlxTypes.INT);
        ConstInstr<Integer> CONST_2 = new ConstInstr<>(2, RlxTypes.INT);

        VarInstr varX = function.makeVar(RlxTypes.INT);
        VarInstr varY = function.makeVar(RlxTypes.INT);
        varX.set(CONST_0);
        varY.set(CONST_0);

        RlxBlock block0 = function.makeBlock("block_0");
        RlxBlock block1 = function.makeBlock("block_1");
        RlxBlock block2 = function.makeBlock("block_2");
        RlxBlock block3 = function.makeBlock("block_3");

        RlxBlock cond1 = function.makeBlock("condition_1");
        ValueInstr COMP_0 = function.compare(CompareOp.EQ, instr, CONST_0);
        function.jumpIf(COMP_0, block0, cond1);
        RlxBlock cond2 = function.makeBlock("condition_1");
        ValueInstr COMP_1 = function.compare(CompareOp.EQ, instr, CONST_1);
        function.jumpIf(COMP_1, block1, cond2);
        ValueInstr COMP_2 = function.compare(CompareOp.EQ, instr, CONST_2);
        function.jumpIf(COMP_2, block2, block3);

        RlxBlock res = function.makeBlock("dir_out");

        function.buildBlock(block0);
        varX.set(CONST_1);
        function.jump(res);

        function.buildBlock(block1);
        varY.set(CONST_1);
        function.jump(res);

        function.buildBlock(block2);
        varX.set(CONST_1N);
        function.jump(res);

        function.buildBlock(block3);
        varY.set(CONST_1N);
        function.jump(res);

        return Pair.of(varX.get(), varY.get());
    }

    public static void main(String[] args) {
        Backend backend = new RLXToLLVM();

        RlxModule module = new RlxModule("module");
        RlxCls cls = new RlxCls(null, "TestClass");
        module.addClass(cls);
        RlxFunction function = new RlxFunction(
                2, true, false,
                new RlxEnclosure(RlxTypes.INT, "main", RlxTypes.EMPTY_LIST)
        ).exportName("main");
        cls.addFunction(function);

        ConstInstr<Byte> CONST_0B = new ConstInstr<>((byte) 0, RlxTypes.BYTE);
        ConstInstr<Integer> CONST_0 = new ConstInstr<>(0, RlxTypes.INT);
        ConstInstr<Integer> CONST_1 = new ConstInstr<>(1, RlxTypes.INT);
        ConstInstr<Integer> CONST_2 = new ConstInstr<>(2, RlxTypes.INT);
        ConstInstr<Integer> CONST_5 = new ConstInstr<>(5, RlxTypes.INT);

        ConstInstr<Byte> CONST_SPACE = new ConstInstr<>((byte) ' ', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_0_ = new ConstInstr<>((byte) '0', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_o_ = new ConstInstr<>((byte) 'o', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_CR = new ConstInstr<>((byte) '\n', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_LF = new ConstInstr<>((byte) '\r', RlxTypes.BYTE);

        ValueInstr size = function.readInt();
        ValueInstr size2 = function.mul(size, CONST_2);
        ValueInstr square = function.mul(size, size);

        ValueInstr arrayDisplay = function.array(function.sum(square, size2), RlxTypes.BYTE);
        ValueInstr arrayData = function.array(square, RlxTypes.BYTE);

        VarInstr index = function.makeVar(CONST_0);
        function.fori(
                CompareOp.LT,
                index,
                function.sum(square, size2),
                CONST_1,
                (body) -> function.arraySet(arrayDisplay, index.get(), CONST_SPACE)
        );
        function.fori(
                CompareOp.LT,
                index,
                size,
                CONST_1,
                (body) -> {
                    function.arraySet(
                            arrayDisplay,
                            function.sum(
                                    function.mul(index.get(), size),
                                    size
                            ),
                            CONST_CR
                    );
                    function.arraySet(
                            arrayDisplay,
                            function.sum(
                                    function.mul(index.get(), size),
                                    function.sum(size, CONST_1)
                            ),
                            CONST_CR
                    );
                }
        );

        VarInstr lastInput = function.makeVar(CONST_0);

        VarInstr appleX = function.makeVar(CONST_0);
        VarInstr appleY = function.makeVar(CONST_0);

        VarInstr tailX = function.makeVar(CONST_0);
        VarInstr tailY = function.makeVar(CONST_0);
        VarInstr headX = function.makeVar(CONST_0);
        VarInstr headY = function.makeVar(CONST_0);

        RlxBlock exit = function.makeBlock("exit");
        RlxBlock head = function.makeBlock("head");
        function.jump(head);
        {
//            function.ifC(
//                    function.hasInput(),
//                    (body1) -> {
            lastInput.set(
                    function.readInt()
            );
//            });

            ValueInstr posTail = tailY.get();
            posTail = function.mul(posTail, function.sum(size2, CONST_1));
            posTail = function.sum(posTail, tailX.get());

            ValueInstr posHead = headY.get();
            posHead = function.mul(posHead, function.sum(size2, CONST_1));
            posHead = function.sum(posHead, headX.get());

            function.print(posHead);

//            function.arraySet(arrayDisplay, posHead, function.cast(
//                    CONST_o_,
//                    RlxTypes.BYTE
//            ));

            function.print(CONST_0);
            function.print(headX.get());
            function.print(CONST_1);
            function.print(headY.get());

            ValueInstr headDir = lastInput.get();
            ValueInstr tailDir = function.arrayGet(arrayData, posTail);

            Pair<ValueInstr, ValueInstr> vector = getDir(function, headDir);

            function.arraySet(arrayData, posTail, CONST_0B);
            ValueInstr xMot = vector.getFirst();
            ValueInstr yMot = vector.getSecond();
            headX.set(function.sum(headX.get(), xMot));
            headY.set(function.sum(headY.get(), yMot));

            ValueInstr input = lastInput.get();
            function.arraySet(arrayData, posHead, function.cast(
                    input,
                    RlxTypes.BYTE
            ));
            function.arraySet(arrayDisplay, posHead, function.cast(
                    CONST_0_,
                    RlxTypes.BYTE
            ));

            function.print(arrayDisplay);

            ValueInstr is5 = function.compare(CompareOp.EQ, input, CONST_5);
            function.jumpIf(
                    is5, exit, head
            );
        }

        function.buildBlock(exit);
        function.ret(CONST_0);

        System.out.println(module.asText());

        Compiler compiler = backend.compilerFor(module);
        compiler.verbose();
        compiler.stub();
        compiler.compile();
        compiler.optimize(0, 0, true);
        compiler.write();
    }
}
