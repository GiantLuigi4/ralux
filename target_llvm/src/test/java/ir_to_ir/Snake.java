package ir_to_ir;

import org.bytedeco.llvm.LLVM.LLVMValueRef;
import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.RLXToLLVM;
import tfc.ralux.compiler.util.Pair;
import tfc.rlxir.*;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.BooleanOp;
import tfc.rlxir.instr.enumeration.CompareOp;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxTypes;

public class Snake {
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

    protected static ValueInstr distance(
            RlxFunction function,
            ValueInstr left,
            ValueInstr right
    ) {
        VarInstr i0 = function.makeVar(RlxTypes.INT);
        ValueInstr CONST_0 = new ConstInstr<>(0, RlxTypes.INT);
        ValueInstr diff = function.sub(right, left);
        RlxBlock blockL = function.makeBlock("block_l");
        RlxBlock blockR = function.makeBlock("block_r");
        RlxBlock blockD = function.makeBlock("block_d");
        ValueInstr cmp = function.compare(CompareOp.GE, diff, CONST_0);
        function.jumpIf(cmp, blockL, blockR);
        i0.set(function.sub(CONST_0, diff));
        function.jump(blockD);
        function.buildBlock(blockL);
        i0.set(diff);
        function.jump(blockD);
        return i0.get();
    }

    protected static ValueInstr index(
            RlxFunction function,
            VarInstr posX, VarInstr posY,
            ValueInstr size, ValueInstr stride
    ) {
        ValueInstr posHead = posY.get();
        posHead = function.mul(posHead, function.sum(size, stride));
        posHead = function.sum(posHead, posX.get());
        return posHead;
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

        ConstInstr<Byte> CONST_NEG1B = new ConstInstr<>((byte) -1, RlxTypes.BYTE);
        ConstInstr<Byte> CONST_0B = new ConstInstr<>((byte) 0, RlxTypes.BYTE);
        ConstInstr<Integer> CONST_0 = new ConstInstr<>(0, RlxTypes.INT);
        ConstInstr<Integer> CONST_1 = new ConstInstr<>(1, RlxTypes.INT);
        ConstInstr<Integer> CONST_2 = new ConstInstr<>(2, RlxTypes.INT);
        ConstInstr<Integer> CONST_4 = new ConstInstr<>(4, RlxTypes.INT);
        ConstInstr<Integer> CONST_5 = new ConstInstr<>(5, RlxTypes.INT);

//        ConstInstr<Byte> CONST_SPACE = new ConstInstr<>((byte) ' ', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_SPACE = new ConstInstr<>((byte) '_', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_0_ = new ConstInstr<>((byte) '0', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_X_ = new ConstInstr<>((byte) 'X', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_o_ = new ConstInstr<>((byte) 'o', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_O_ = new ConstInstr<>((byte) 'O', RlxTypes.BYTE);
        ConstInstr<Byte> CONST_CR = new ConstInstr<>((byte) 10, RlxTypes.BYTE);
        ConstInstr<Byte> CONST_LF = new ConstInstr<>((byte) 13, RlxTypes.BYTE);

        ConstInstr<Byte> CONST_FALSE = new ConstInstr<>((byte) 0, RlxTypes.BOOLEAN);
        ConstInstr<Byte> CONST_TRUE = new ConstInstr<>((byte) 1, RlxTypes.BOOLEAN);

        ValueInstr size = function.readInt();
        ValueInstr size2 = function.mul(size, CONST_2);
        ValueInstr square = function.mul(size, size);

        ValueInstr aSize = function.sum(square, size2);
        ValueInstr arrayDisplay = function.array(function.sum(aSize, CONST_1), RlxTypes.BYTE);
        ValueInstr arrayData = function.array(square, RlxTypes.BYTE);

        VarInstr index = function.makeVar(CONST_0);
        function.fori(
                CompareOp.LT,
                index,
                aSize,
                CONST_1,
                (body) -> function.arraySet(arrayDisplay, index.get(), CONST_SPACE)
        );
        function.arraySet(arrayDisplay, index.get(), CONST_0B);
        index.set(CONST_0);
        function.fori(
                CompareOp.LT,
                index,
                square,
                CONST_1,
                (body) -> function.arraySet(arrayData, index.get(), CONST_NEG1B)
        );
        index.set(CONST_0);
        function.fori(
                CompareOp.LT,
                index,
                size,
                CONST_1,
                (body) -> {
                    function.arraySet(
                            arrayDisplay,
                            function.sum(
                                    function.mul(index.get(), function.sum(size, CONST_2)),
                                    size
                            ),
                            CONST_CR
                    );
                    function.arraySet(
                            arrayDisplay,
                            function.sum(
                                    function.mul(index.get(), function.sum(size, CONST_2)),
                                    function.sum(size, CONST_1)
                            ),
                            CONST_LF
                    );
                }
        );

        function.arraySet(arrayData, CONST_0, CONST_0B);

        VarInstr lastInput = function.makeVar(CONST_0);
        VarInstr growSnek = function.makeVar(CONST_FALSE);

        VarInstr fTurn = function.makeVar(RlxTypes.BOOLEAN);
        fTurn.set(CONST_FALSE);

        VarInstr appleX = function.makeVar(CONST_0);
        VarInstr appleY = function.makeVar(CONST_0);

        appleX.set(function.random(CONST_0, size));
        appleY.set(function.random(CONST_0, size));

        function.print(appleX.get());
        function.print(appleY.get());

        dispApple(
                function,
                appleX, appleY,
                size, CONST_2, arrayDisplay,
                CONST_O_
        );

        VarInstr tailX = function.makeVar(CONST_0);
        VarInstr tailY = function.makeVar(CONST_0);
        VarInstr headX = function.makeVar(CONST_1);
        VarInstr headY = function.makeVar(CONST_0);

        RlxBlock exit = function.makeBlock("exit");
        RlxBlock head = function.makeBlock("head");
        function.jump(head);
        {
            ValueInstr headDir = lastInput.get();

            RlxBlock blockUpdateTail = function.makeBlock("update_tail");
            RlxBlock blockContinue = function.makeBlock("continue");

            ValueInstr growCondition = growSnek.get();

            function.jumpIf(growCondition, blockContinue, blockUpdateTail);
            {
                ValueInstr tailPos = index(function, tailX, tailY, size, CONST_2);
                // clear tail graphics
                function.arraySet(arrayDisplay, tailPos, function.cast(
                        CONST_SPACE,
                        RlxTypes.BYTE
                ));

                tailPos = index(function, tailX, tailY, size, CONST_0);
                ValueInstr tailDir = function.arrayGet(arrayData, tailPos);
                Pair<ValueInstr, ValueInstr> vector = getDir(function, tailDir);
                // update tail pos
                ValueInstr xMot = vector.getFirst();
                ValueInstr yMot = vector.getSecond();
                tailX.set(function.sum(tailX.get(), xMot));
                tailY.set(function.sum(tailY.get(), yMot));
                // clear tail flag
                function.arraySet(arrayData, tailPos, function.cast(
                        CONST_NEG1B,
                        RlxTypes.BYTE
                ));
                function.jump(blockContinue);
            }

            ValueInstr headPos = index(function, headX, headY, size, CONST_2);
            growSnek.set(CONST_FALSE);
            function.arraySet(arrayDisplay, headPos, function.cast(
                    CONST_o_,
                    RlxTypes.BYTE
            ));
            dispApple(
                    function,
                    appleX, appleY,
                    size, CONST_2, arrayDisplay,
                    CONST_O_
            );

            ValueInstr input = lastInput.get();
            headPos = index(function, headX, headY, size, CONST_0);
            function.arraySet(arrayData, headPos, function.cast(
                    input,
                    RlxTypes.BYTE
            ));

            Pair<ValueInstr, ValueInstr> vector = getDir(function, headDir);
            // update head pos
            ValueInstr xMot = vector.getFirst();
            ValueInstr yMot = vector.getSecond();
            headX.set(function.sum(headX.get(), xMot));
            headY.set(function.sum(headY.get(), yMot));

            headPos = index(function, headX, headY, size, CONST_0);
            ValueInstr headTailStatus = function.arrayGet(arrayData, headPos);

            RlxBlock conditionGrow = function.makeBlock("grow");
            RlxBlock conditionStag = function.makeBlock("stag");

            function.jumpIf(function.compare(CompareOp.EQ, index(
                    function, appleX, appleY, size, CONST_0
            ), index(
                    function, headX, headY, size, CONST_0
            )), conditionGrow, conditionStag);

            {
                function.buildBlock(conditionGrow);
                growSnek.set(CONST_TRUE);
                appleX.set(function.random(CONST_0, size));
                appleY.set(function.random(CONST_0, size));
                function.jump(conditionStag);
            }

            function.buildBlock(conditionStag);

            RlxBlock loss = function.makeBlock("loss");
            RlxBlock notLoss = function.makeBlock("not_loss");
            RlxBlock inputLoop = function.makeBlock("input_loop");

            ValueInstr isLoss = function.compare(CompareOp.NE, headTailStatus, CONST_NEG1B);
            isLoss = function.booleanOp(BooleanOp.AND, isLoss, fTurn.get());
            fTurn.set(CONST_TRUE);
            function.jumpIf(
                    isLoss, loss, notLoss
            );
            {
                headPos = index(function, headX, headY, size, CONST_2);
                function.arraySet(arrayDisplay, headPos, function.cast(
                        CONST_0_,
                        RlxTypes.BYTE
                ));
                function.print(arrayDisplay);
                function.jump(inputLoop);
            }

            function.buildBlock(loss);
            {
                headPos = index(function, headX, headY, size, CONST_2);
                function.arraySet(arrayDisplay, headPos, function.cast(
                        CONST_X_,
                        RlxTypes.BYTE
                ));
                function.print(arrayDisplay);
                function.jump(exit);
            }

            function.buildBlock(inputLoop);

            RlxBlock inputBreak = function.makeBlock("input_break");

            ValueInstr istr0 = function.readInt();
            ValueInstr dist = distance(function, istr0, lastInput.get());
//            function.ifC(
//                    function.hasInput(),
//                    (body1) -> {
//            });

            ValueInstr c0 = function.compare(CompareOp.EQ, dist, CONST_2);
            ValueInstr c1 = function.compare(CompareOp.LE, istr0, CONST_5);
            ValueInstr c2 = function.compare(CompareOp.GE, istr0, CONST_0);
            function.print(function.cast(c0, RlxTypes.INT));
            function.print(function.cast(c1, RlxTypes.INT));
            function.print(function.cast(c2, RlxTypes.INT));
            ValueInstr c3 = function.booleanOp(BooleanOp.AND, c1, c2);
            function.print(function.cast(c3, RlxTypes.INT));

            function.jumpIf(function.booleanOp(BooleanOp.OR, c0, function.sub(CONST_TRUE, c3)), inputLoop, inputBreak);

            lastInput.set(istr0);

            ValueInstr is4 = function.compare(CompareOp.EQ, input, CONST_4);
            function.jumpIf(
                    is4, exit, head
            );
        }

        function.buildBlock(exit);
        function.ret(CONST_0);

        System.out.println(module.asText());

        Compiler compiler = backend.compilerFor(module);
        compiler.verbose();
        compiler.stub();
        compiler.compile();
        compiler.optimize(0, 4, true);
        compiler.write();
    }

    private static void dispApple(
            RlxFunction function,
            VarInstr appleX, VarInstr appleY,
            ValueInstr size, ValueInstr CONST_2,
            ValueInstr arrayDisplay, ValueInstr CONST_O_
    ) {
        ValueInstr indexApple = index(
                function, appleX, appleY,
                size, CONST_2
        );
        function.arraySet(arrayDisplay, indexApple, function.cast(
                CONST_O_,
                RlxTypes.BYTE
        ));
    }
}
