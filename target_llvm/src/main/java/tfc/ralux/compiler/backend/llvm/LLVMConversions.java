package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.rlxir.typing.RlxType;

public class LLVMConversions {
    private final BuilderRoot root;
    public final LLVMTypeRef F16;
    public final LLVMTypeRef F32;
    public final LLVMTypeRef F64;
    public final LLVMTypeRef F128;
    public final LLVMTypeRef I1;
    public final LLVMTypeRef I8;
    public final LLVMTypeRef I16;
    public final LLVMTypeRef I32;
    public final LLVMTypeRef I64;
    public final LLVMTypeRef I128;
    public final LLVMTypeRef VOID;
    public final LLVMTypeRef VOID_PTR;
    public final LLVMTypeRef VOID_PTR_PTR;

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
        VOID_PTR_PTR = root.pointerType(VOID_PTR);
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
            case PTR -> VOID_PTR_PTR;
        };
    }
}
