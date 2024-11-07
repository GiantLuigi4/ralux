package tfc.ralux.compiler.backend.llvm.util;

import org.bytedeco.llvm.LLVM.LLVMBasicBlockRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;

public class BlockBuilder {
    boolean terminated = false;
    LLVMBasicBlockRef blockRef;
    BuilderRoot root;

    public BlockBuilder(LLVMBasicBlockRef blockRef, BuilderRoot root) {
        this.blockRef = blockRef;
        this.root = root;
        root.track(this);
    }

    public BlockBuilder enableBuilding() {
        root.buildBlock(this);
        return this;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void unreachable() {
        if (terminated) throw new RuntimeException("Already terminated");
        root.track(LLVM.LLVMBuildUnreachable(root.getBuilder()));
        terminated = true;
    }

    public void ret(LLVMValueRef valueRef) {
        if (terminated) throw new RuntimeException("Already terminated");
        root.track(LLVM.LLVMBuildRet(root.getBuilder(), valueRef));
        terminated = true;
    }

    public void ret() {
        if (terminated) throw new RuntimeException("Already terminated");
        root.track(LLVM.LLVMBuildRetVoid(root.getBuilder()));
        terminated = true;
    }

    public LLVMBasicBlockRef getDirect() {
        return blockRef;
    }

    public void jump(BlockBuilder block) {
        if (terminated) throw new RuntimeException("Already terminated");
        root.track(LLVM.LLVMBuildBr(root.getBuilder(), block.blockRef));
        terminated = true;
    }

    public void conditionalJump(LLVMValueRef condition, BlockBuilder trueBranch, BlockBuilder falseBranch) {
        if (terminated) throw new RuntimeException("Already terminated");
        root.track(LLVM.LLVMBuildCondBr(root.getBuilder(), condition, trueBranch.blockRef, falseBranch.blockRef));
        terminated = true;
    }
}
