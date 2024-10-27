package compiler.compiler.analysis;

import compiler.compiler.RaluxFunctionConsumer;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.parse.RaluxParser;

import java.util.Objects;

public class Type {
    RaluxParser.Full_typeContext typeContext;
    LLVMTypeRef llvm;
    boolean signed;
    boolean primitive;
    boolean isInt;

    public Type(BuilderRoot root, RaluxFunctionConsumer consumer, RaluxParser.Full_typeContext typeContext) {
        this.typeContext = typeContext;

        RaluxParser.TypeContext baseType = (RaluxParser.TypeContext) typeContext.getChild(0);
        if (baseType.getChildCount() > 1) {
            primitive = false;
            throw new RuntimeException("idr what would trigger this, I'll get it at some point if anything does trigger it, lol");
        }

        LLVMTypeRef llvm;
        LLVMTypeRef baseTypeLLVM;

        if (baseType.getChild(0) instanceof TerminalNodeImpl impl) {
            isInt = true;
            signed = true;
            baseTypeLLVM = switch (impl.symbol.getText()) {
                case "boolean" -> root.getIntType(1);
                case "byte", "char" -> root.getIntType(8);
                case "short" -> root.getIntType(16);
                case "int" -> root.getIntType(32);
                case "long" -> root.getIntType(64);
                default -> throw new RuntimeException("TODO: fp");
            };
            primitive = true;
        } else {
            primitive = false;
            throw new RuntimeException("TODO: whatever else");
        }

        llvm = baseTypeLLVM;

        if (typeContext.getChildCount() > 1) {
            primitive = false;
            throw new RuntimeException("TODO: generics and arrays");
        }

        this.llvm = llvm;
    }

    public Type(LLVMTypeRef llvm, boolean isInt, boolean signed, boolean primitive) {
        this.llvm = llvm;
        this.isInt = isInt;
        this.signed = signed;
        this.primitive = primitive;
    }

    public LLVMTypeRef llvm() {
        return llvm;
    }

    public LLVMValueRef sum(BuilderRoot root, LLVMValueRef lh, LLVMValueRef rh) {
        if (isInt) {
            if (signed) {
                return root.sisum(lh, rh, "compute_sum");
            } else throw new RuntimeException("NYI");
        } else throw new RuntimeException("NYI");
    }

    public LLVMValueRef diff(BuilderRoot root, LLVMValueRef lh, LLVMValueRef rh) {
        if (isInt) {
            if (signed) {
                return root.sisub(lh, rh, "compute_diff");
            } else throw new RuntimeException("NYI");
        } else throw new RuntimeException("NYI");
    }

    public LLVMValueRef mul(BuilderRoot root, LLVMValueRef lh, LLVMValueRef rh) {
        if (isInt) {
            if (signed) {
                return root.simul(lh, rh, "compute_prod");
            } else throw new RuntimeException("NYI");
        } else throw new RuntimeException("NYI");
    }

    public LLVMValueRef div(BuilderRoot root, LLVMValueRef lh, LLVMValueRef rh) {
        if (isInt) {
            if (signed) {
                return root.sidiv(lh, rh, "compute_quotient");
            } else throw new RuntimeException("NYI");
        } else throw new RuntimeException("NYI");
    }

    public LLVMValueRef eqSum(BuilderRoot root, LLVMValueRef lh, Value rh) {
        return sum(root, lh, cast(root, rh));
    }

    public LLVMValueRef eqDiff(BuilderRoot root, LLVMValueRef lh, Value rh) {
        return diff(root, lh, cast(root, rh));
    }

    public LLVMValueRef eqMul(BuilderRoot root, LLVMValueRef lh, Value rh) {
        return mul(root, lh, cast(root, rh));
    }

    public LLVMValueRef eqDiv(BuilderRoot root, LLVMValueRef lh, Value rh) {
        return div(root, lh, cast(root, rh));
    }

    protected boolean intInt(Type other) {
        if (isInt) {
            if (other.isInt) {
                return true;
            }
        }
        return false;
    }

    public LLVMValueRef cast(BuilderRoot root, Value val) {
        if (intInt(val.type)) {
            if (signed && val.type.signed) {
                int sizeSelf = root.getIntSize(llvm);
                int sizeOther = root.getIntSize(val.type.llvm);

                if (sizeSelf > sizeOther) return root.bitcastOrExtend(llvm, val.llvm, "cast_to" + this);
                else if (sizeSelf == sizeOther) return val.llvm;
                else return root.truncate(llvm, val.llvm, "cast_to" + this);
            } else throw new RuntimeException("NYI");
        } else throw new RuntimeException("NYI");
    }

    public Type coerce(Type type) {
        if (!this.equals(type)) throw new RuntimeException("NYI");
        return this;
    }

    public LLVMValueRef coerce(LLVMValueRef llvm, Type type) {
        // TODO: more proper
        return llvm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return signed == type.signed && primitive == type.primitive && isInt == type.isInt && Objects.equals(llvm, type.llvm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(llvm, signed, primitive, isInt);
    }
}
