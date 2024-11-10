package tfc.ralux.compiler.backend.llvm.util.helper;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
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

    LLVMValueRef stdin;

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

        PointerPointer<LLVMValueRef> args = root.track(new PointerPointer<>(3));
        args.put(0, text);
        args.put(1, length);
        args.put(2, root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                seriouslyMicrosoft.getDirect(),
                args0, 1, "seriouslyMicrosoft"
        )));
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
        // technically 11 chars is enough to store the string, but I'm allocating 11 to ensure space for the new line character
        LLVMValueRef str = root.allocA(root.BYTE_TYPE, 12, "str_buf");
        root.memSet(str, root.integer(0, 8), root.integer(12, 32), 8);
        LLVMValueRef length = root.integer(12, 32);
        readTo(str, length);
        return stringToInt(root.getIntType(32), str);
    }
}
