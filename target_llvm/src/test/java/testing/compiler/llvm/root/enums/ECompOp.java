package testing.compiler.llvm.root.enums;

import org.bytedeco.llvm.global.LLVM;

public enum ECompOp {
    LE(LLVM.LLVMIntSLE, LLVM.LLVMIntULE, LLVM.LLVMRealOLE),
    LT(LLVM.LLVMIntSLT, LLVM.LLVMIntULT, LLVM.LLVMRealOLT),
    GT(LLVM.LLVMIntSGT, LLVM.LLVMIntUGT, LLVM.LLVMRealOGT),
    GE(LLVM.LLVMIntSGE, LLVM.LLVMIntUGE, LLVM.LLVMRealOGE),
    EQ(LLVM.LLVMIntEQ, LLVM.LLVMIntEQ, LLVM.LLVMRealOEQ),
    NE(LLVM.LLVMIntNE, LLVM.LLVMIntNE, LLVM.LLVMRealONE),
    ;

    public final int opSInt;
    public final int opUInt;
    public final int opFP;

    ECompOp(int opSInt, int opUInt, int opFP) {
        this.opSInt = opSInt;
        this.opUInt = opUInt;
        this.opFP = opFP;
    }
}
