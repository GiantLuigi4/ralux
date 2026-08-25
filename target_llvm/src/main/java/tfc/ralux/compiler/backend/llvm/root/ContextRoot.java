package tfc.ralux.compiler.backend.llvm.root;

import org.bytedeco.llvm.LLVM.LLVMContextRef;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.global.LLVM;

import java.util.ArrayList;
import java.util.List;

public class ContextRoot {
    protected LLVMContextRef context = LLVM.LLVMContextCreate();
    public final LLVMTypeRef BYTE_TYPE = LLVM.LLVMInt8TypeInContext(context);
    public final LLVMTypeRef CHAR_TYPE = LLVM.LLVMInt16TypeInContext(context);
	public final LLVMTypeRef LONG_TYPE = LLVM.LLVMInt32TypeInContext(context);
	public final LLVMTypeRef VOID_TYPE = LLVM.LLVMVoidTypeInContext(context);
	public final LLVMTypeRef CSTRING_TYPE = LLVM.LLVMPointerType(BYTE_TYPE, 0);
    public final LLVMTypeRef WSTRING_TYPE = LLVM.LLVMPointerType(CHAR_TYPE, 0);
	public final LLVMTypeRef VOID_PTR = LLVM.LLVMPointerType(VOID_TYPE, 0);
	public final LLVMTypeRef VOID_PTR_PTR = LLVM.LLVMPointerType(VOID_PTR, 0);

    List<Object> keepInMem = new ArrayList<>();

    public <T> T track(T obj) {
        keepInMem.add(obj);
        return obj;
    }

    public LLVMContextRef getContext() {
        return context;
    }
}
