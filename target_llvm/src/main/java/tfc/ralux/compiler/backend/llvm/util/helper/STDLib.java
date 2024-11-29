package tfc.ralux.compiler.backend.llvm.util.helper;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;
import tfc.ralux.compiler.backend.llvm.util.helper.str.IntToString;
import tfc.ralux.compiler.backend.llvm.util.helper.str.StringToInt;

import java.util.HashMap;

public class STDLib {
    BuilderRoot root;

    FunctionType typePuts;

    FunctionBuilder fPutS;
    BytePointer labelPuts;

    FunctionType typeGets;
    FunctionBuilder fFGetS;
    FunctionType typeSeriouslyMicrosoft;
    FunctionBuilder seriouslyMicrosoft;

    FunctionType typei32Ret;
    FunctionType typeFeof;
    FunctionBuilder feof;
    FunctionBuilder _kbhit;

    FunctionBuilder fRandom;

    public STDLib(BuilderRoot root) {
        this.root = root;
    }

    //int puts(const char *str);
    public LLVMValueRef print(LLVMValueRef text) {
        if (typePuts == null) {
            typePuts = new FunctionType(
                    root,
                    root.getIntType(32)
            ).withArgs(root.CSTRING_TYPE).build();

            fPutS = root.function("puts", typePuts);

            labelPuts = root.track(Util.memUTF("callPuts"));
        }

        return root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                fPutS.getDirect(),
                text, 1, labelPuts
        ));
    }

    protected LLVMValueRef seriouslyMicrosoft() {
        if (typeSeriouslyMicrosoft == null) {
            LLVMTypeRef filePtr = root.pointerType(root.getIntType(8));
            typeSeriouslyMicrosoft = new FunctionType(
                    root,
                    filePtr
            ).withArgs(root.getIntType(32)).build();

            seriouslyMicrosoft = root.function(
                    "__acrt_iob_func",
                    typeSeriouslyMicrosoft
            );
        }

        PointerPointer<LLVMValueRef> args0 = root.track(new PointerPointer<>(3));
        args0.put(0, root.integer(0, 32));
        return root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                seriouslyMicrosoft.getDirect(),
                args0, 1, "seriouslyMicrosoft"
        ));
    }

    //int fgets(const char *str, int length, );
    public LLVMValueRef readTo(LLVMValueRef text, LLVMValueRef length) {
        if (typeGets == null) {
            LLVMTypeRef filePtr = root.pointerType(root.getIntType(8));
            typeGets = new FunctionType(
                    root,
                    root.getIntType(32)
            ).withArgs(
                    root.CSTRING_TYPE,
                    root.getIntType(32),
                    filePtr
            ).build();

            fFGetS = root.function("fgets", typeGets);
        }

        PointerPointer<LLVMValueRef> args = root.track(new PointerPointer<>(3));
        args.put(0, text);
        args.put(1, length);
        args.put(2, seriouslyMicrosoft());
        root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                fFGetS.getDirect(),
                args, 3, "callFGetS"
        ));
        return text;
    }

    HashMap<LLVMTypeRef, IntToString> toStringFuncs = new HashMap<>();

    //int snprintf(char *str, size_t size, const char *format, ...);
    public LLVMValueRef intToString(LLVMTypeRef type, LLVMValueRef intVal) {
        IntToString toString = toStringFuncs.get(type);
        if (toString == null) {
            toString = new IntToString(root, type);
            toStringFuncs.put(type, toString);
        }

        LLVMValueRef valueRef = toString.call(intVal);
        return valueRef;
    }

    HashMap<LLVMTypeRef, StringToInt> fromStringFuncs = new HashMap<>();

    public LLVMValueRef stringToInt(LLVMTypeRef type, LLVMValueRef intVal) {
        StringToInt fromString = fromStringFuncs.get(type);
        if (fromString == null) {
            fromString = new StringToInt(root, type);
            fromStringFuncs.put(type, fromString);
        }

        LLVMValueRef valueRef = fromString.call(intVal);
        return valueRef;
    }

    public LLVMValueRef readInt() {
        return readInt(32);
    }

    public LLVMValueRef readInt(int bits) {
        int baseStrLen = (int) Math.floor(bits * Math.log10(2)) + 1;

        // technically 11 chars is enough to store the string, but I'm allocating 11 to ensure space for the new line character
        LLVMValueRef str = root.allocA(root.BYTE_TYPE, baseStrLen, "str_buf");
        root.memSet(str, root.integer(0, 8), root.integer(baseStrLen, 32), 8);
        LLVMValueRef length = root.integer(baseStrLen, 32);
        readTo(str, length);
        return stringToInt(root.getIntType(bits), str);
    }

    // TODO:
    public LLVMValueRef hasInput(FunctionBuilder functionBuilder) {
        if (typeFeof == null) {
            LLVMTypeRef filePtr = root.pointerType(root.getIntType(8));
            typeFeof = new FunctionType(
                    root, root.getIntType(32)
            ).withArgs(filePtr).build();
            feof = root.function(
                    "feof",
                    typeFeof
            );
        }
        if (_kbhit == null) {
            if (typei32Ret == null) {
                typei32Ret = new FunctionType(
                        root, root.getIntType(32)
                ).build();
            }
            _kbhit = root.function(
                    "_kbhit",
                    typei32Ret
            );
        }

//        BlockBuilder builder = root.getBlockBuilding();
//        BlockBuilder shortTo = functionBuilder.block("shortTo");
//        BlockBuilder dst = functionBuilder.block("dst");
//
//        LLVMValueRef valueRef = root.allocA(root.getIntType(1), "has_input");
//
//        // get i32 feof
//        PointerPointer<LLVMValueRef> args = root.track(new PointerPointer<>(1));
//        args.put(0, seriouslyMicrosoft());
//        LLVMValueRef feofV = root.track(
//                LLVM.LLVMBuildCall(
//                        root.getBuilder(), feof.getDirect(),
//                        args, 1, "call_feof"
//                )
//        );
//        BlockBuilder falseA = functionBuilder.block("falseA");
//        builder.conditionalJump(feofV, falseA, shortTo);
//        falseA.enableBuilding();
//        args = root.track(new PointerPointer<>(0));
//        LLVMValueRef kbhitV = root.track(
//                LLVM.LLVMBuildCall(
//                        root.getBuilder(), _kbhit.getDirect(),
//                        args, 0, "call_kbhit"
//                )
//        );
//        // get i32 _kbhit
//        falseA.conditionalJump(kbhitV, shortTo, dst);
//
//        shortTo.enableBuilding();
//        root.setValue(valueRef, root.integer(1, 1));
//        shortTo.jump(dst);
//        dst.enableBuilding();
//
//        return root.getValue(valueRef, "get_has_input");
        return root.integer(1, 1);
    }

    public LLVMValueRef random(LLVMValueRef min, LLVMValueRef max) {
        if (fRandom == null) {
            if (typei32Ret == null) {
                typei32Ret = new FunctionType(
                        root, root.getIntType(32)
                ).build();
            }

            fRandom = root.function("rand", typei32Ret);
        }

        PointerPointer<LLVMValueRef> noArg = root.track(new PointerPointer<>());
        LLVMValueRef rand = root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                fRandom.getDirect(),
                noArg, 0,
                "rand"
        ));
        LLVMValueRef range = root.sisub(max, min, "calc_range");
        LLVMValueRef randVal = root.simod(rand, range, "calc_val");
        LLVMValueRef calcOut = root.sisum(randVal, min, "calc_out");
        return calcOut;
    }
}
