package tfc.ralux.compiler.backend.llvm.util;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionType {
    LLVMTypeRef ret;
    List<LLVMTypeRef> params = new ArrayList<>();
    PointerPointer<LLVMTypeRef> paramsPtr;
    LLVMTypeRef direct;
    BuilderRoot root;

    public FunctionType(BuilderRoot root, LLVMTypeRef ret) {
        this.ret = ret;
        root.track(this);
    }

    public FunctionType withArgs(LLVMTypeRef... type) {
        if (direct != null) throw new RuntimeException("Already built");

        Collections.addAll(params, type);
        return this;
    }

    public FunctionType build() {
        if (direct != null) throw new RuntimeException("Already built");

        paramsPtr = new PointerPointer<>(params.size());
        for (int i = 0; i < params.size(); i++)
            paramsPtr.put(i, params.get(i));
        direct = LLVM.LLVMFunctionType(
                ret,
                paramsPtr,
                params.size(),
                0
        );
        return this;
    }

    public FunctionType buildVarArg() {
        if (direct != null) throw new RuntimeException("Already built");

        paramsPtr = new PointerPointer<>(params.size());
        for (int i = 0; i < params.size(); i++)
            paramsPtr.put(i, params.get(i));
        direct = LLVM.LLVMFunctionType(
                ret,
                paramsPtr,
                params.size(),
                1
        );
        return this;
    }

    public LLVMTypeRef getDirect() {
        return direct;
    }
}
