package tfc.ralux.compiler.backend.llvm.util;

import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;

public class FunctionBuilder {
    BuilderRoot root;
    LLVMValueRef function;
    String name;

    public FunctionBuilder(BuilderRoot root, LLVMValueRef function, String name) {
        root.trackFunction(this);
        this.root = root;
        this.function = function;
        this.name = name;
    }

    public FunctionBuilder(BuilderRoot root, String name, FunctionType type) {
        root.trackFunction(this);
        this.root = root;
        this.function = LLVM.LLVMAddFunction(
                root.getModule(), name, type.getDirect()
        );
        this.name = name;
    }

    public BlockBuilder block(String name) {
        return new BlockBuilder(
                LLVM.LLVMAppendBasicBlock(function, name),
                root
        );
    }

    public LLVMValueRef getDirect() {
        return function;
    }

    public LLVMValueRef getArg(int index, LLVMTypeRef type) {
        return root.track(LLVM.LLVMGetParam(function, index));
    }

    public boolean verifyFunction() {
        if (LLVM.LLVMVerifyFunction(function, LLVM.LLVMPrintMessageAction) != 0) {
            System.err.println("Failed to verify function " + name);
            return false;
        }
        return true;
    }
}
