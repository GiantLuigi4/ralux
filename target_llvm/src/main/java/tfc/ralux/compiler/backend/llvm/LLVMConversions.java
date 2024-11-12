package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.rlxir.typing.RlxType;

public class LLVMConversions {
    private final BuilderRoot root;
    private final LLVMTypeRef F16;
    private final LLVMTypeRef F32;
    private final LLVMTypeRef F64;
    private final LLVMTypeRef F128;
    private final LLVMTypeRef I1;
    private final LLVMTypeRef I8;
    private final LLVMTypeRef I16;
    private final LLVMTypeRef I32;
    private final LLVMTypeRef I64;
    private final LLVMTypeRef I128;
    private final LLVMTypeRef VOID;
    private final LLVMTypeRef VOID_PTR;

    public LLVMConversions(BuilderRoot root) {
        this.root = root;

        I1 = root.getIntType(1);
        I8 = root.getIntType(8);
        I16 = root.getIntType(16);
        I32 = root.getIntType(32);
        I64 = root.getIntType(64);
        I128 = root.getIntType(128);

        F16 = root.getFloatType(16);
        F32 = root.getFloatType(32);
        F64 = root.getFloatType(64);
        F128 = root.getFloatType(128);

        VOID = root.VOID;
        VOID_PTR = root.pointerType(VOID);
    }

    public LLVMTypeRef typeFor(RlxType type) {
        if (type.isArray())
            return root.pointerType(typeFor(type.debox()));

        return switch (type.type) {
            case BYTE -> I8;
            case SHORT -> I16;
            case INT -> I32;
            case LONG -> I64;
            case WIDE -> I128;

            case HALF -> F16;
            case FLOAT -> F32;
            case DOUBLE -> F64;
            case QUADRUPLE -> F128;

            case CHAR -> I16;
            case VOID -> VOID;

            case BOOLEAN -> I1;
            case PTR -> VOID_PTR;
        };
    }
}
