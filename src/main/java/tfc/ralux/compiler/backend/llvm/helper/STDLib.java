package tfc.ralux.compiler.backend.llvm.helper;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.FunctionType;
import tfc.ralux.compiler.backend.llvm.helper.to_str.IntToString;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;

import java.util.HashMap;

public class STDLib {
    BuilderRoot root;

    FunctionType typePuts;
    FunctionBuilder fPutS;
    BytePointer labelPuts;

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

    HashMap<LLVMTypeRef, IntToString> toStringFuncs = new HashMap<>();

    //int snprintf(char *str, size_t size, const char *format, ...);
    public LLVMValueRef intToString(LLVMTypeRef type, LLVMValueRef intVal) {
        IntToString toString = toStringFuncs.get(type);
        if (toString == null) {
            toString = new IntToString(root, type);
            toStringFuncs.put(type, toString);
        }

        LLVMValueRef valueRef = toString.call(intVal);
//        root.setValue(valueRef, root.integer(0, 32), root.integer(48, 8));
//        root.setValue(valueRef, root.integer(1, 32), root.integer(49, 8));
//        root.setValue(valueRef, root.integer(2, 32), root.integer(50, 8));
        return valueRef;
    }
}
