package tfc.ralux.compiler.backend.llvm.root;

import org.bytedeco.llvm.LLVM.LLVMContextRef;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;

import java.util.ArrayList;
import java.util.List;

import static org.bytedeco.llvm.global.LLVM.LLVMContextCreate;

public class ContextRoot {
    protected LLVMContextRef context = LLVMContextCreate();
    public final LLVMTypeRef BYTE_TYPE = LLVM.LLVMInt8TypeInContext(context);
    public final LLVMTypeRef CSTRING_TYPE = LLVM.LLVMPointerType(BYTE_TYPE, 0);

    List<Object> keepInMem = new ArrayList<>();

    public <T> T track(T obj) {
        keepInMem.add(obj);
        return obj;
    }
}
