package testing.compiler.llvm.compiler.analysis;

import testing.compiler.llvm.compiler.RaluxFunctionConsumer;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import testing.compiler.llvm.root.BuilderRoot;
import testing.compiler.llvm.root.enums.ECompOp;
import testing.compiler.llvm.compiler.cache.ClassFile;
import tfc.ralux.compiler.frontend.ralux.parse.RaluxParser;

import java.util.Objects;

public class Type {
    RaluxParser.Full_typeContext typeContext;
    LLVMTypeRef llvm;
    boolean signed;
    boolean primitive;
    boolean isInt;
    boolean isBool;
    boolean isVoid;
    boolean varrg;
    ClassFile cls;

    public boolean isVarArg() {
        return varrg;
    }

    public boolean isVoid() {
        return isVoid;
    }

    BuilderRoot root;

    public Type(BuilderRoot root, RaluxFunctionConsumer consumer, RaluxParser.Full_typeContext typeContext) {
        this.typeContext = typeContext;

        this.root = root;

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
            String text = impl.symbol.getText();
            if (text.equals("void")) {
                isInt = false;
                isBool = false;
                isVoid = true;
                baseTypeLLVM = root.VOID;
            } else {
                baseTypeLLVM = switch (text) {
                    case "boolean" -> root.getIntType(1);
                    case "byte", "char" -> root.getIntType(8);
                    case "short" -> root.getIntType(16);
                    case "int" -> root.getIntType(32);
                    case "long" -> root.getIntType(64);
                    case "stretch" -> root.getIntType(128);
                    default -> null;
                };
                if (baseTypeLLVM == null) {
                    isInt = false;
                    baseTypeLLVM = switch (text) {
                        case "half" -> root.getFloatType(16);
                        case "float" -> root.getFloatType(32);
                        case "double" -> root.getFloatType(64);
                        case "quadruple" -> root.getFloatType(128);
                        default -> throw new RuntimeException("Unexpected type: " + text);
                    };
                }
            }

            if (text.equals("boolean"))
                isInt = !(isBool = true);

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

    public Type(LLVMTypeRef llvm, boolean isInt, boolean signed, boolean primitive, boolean isBool) {
        this.llvm = llvm;
        this.isInt = isInt;
        this.signed = signed;
        this.primitive = primitive;
        this.isBool = isBool;
    }

    public LLVMTypeRef llvm() {
        return llvm;
    }

    public LLVMValueRef sum(BuilderRoot root, LLVMValueRef lh, LLVMValueRef rh) {
        if (isInt) {
            if (signed) {
                return root.sisum(lh, rh, "compute_sum");
            } else throw new RuntimeException("NYI");
        } else if (isFloat())
            return root.fsum(lh, rh, "compute_sum");
        throw new RuntimeException("NYI");
    }

    public LLVMValueRef diff(BuilderRoot root, LLVMValueRef lh, LLVMValueRef rh) {
        if (isInt) {
            if (signed) {
                return root.sisub(lh, rh, "compute_diff");
            } else throw new RuntimeException("NYI");
        } else if (isFloat())
            return root.fsub(lh, rh, "compute_diff");
        throw new RuntimeException("NYI");
    }

    public LLVMValueRef mul(BuilderRoot root, LLVMValueRef lh, LLVMValueRef rh) {
        if (isInt) {
            if (signed) {
                return root.simul(lh, rh, "compute_prod");
            } else throw new RuntimeException("NYI");
        } else if (isFloat())
            return root.fmul(lh, rh, "compute_prod");
        throw new RuntimeException("NYI");
    }

    public LLVMValueRef div(BuilderRoot root, LLVMValueRef lh, LLVMValueRef rh) {
        if (isInt) {
            if (signed) {
                return root.sidiv(lh, rh, "compute_quotient");
            } else throw new RuntimeException("NYI");
        } else if (isFloat())
            return root.fdiv(lh, rh, "compute_quotient");
        throw new RuntimeException("NYI");
    }

    public LLVMValueRef compare(BuilderRoot root, ECompOp eCompOp, LLVMValueRef lh, LLVMValueRef rh) {
        if (isInt) {
            if (signed) {
                return root.compareInt(eCompOp, lh, rh, "compute_compare");
            } else throw new RuntimeException("NYI");
        } else if (isFloat())
            return root.compareFloat(eCompOp, lh, rh, "compute_compare");
        throw new RuntimeException("NYI");
    }

    public LLVMValueRef negate(BuilderRoot root, LLVMValueRef value) {
        if (isInt) {
            if (signed) {
                return root.negate(value);
            } else throw new RuntimeException("NYI");
        } else if (isFloat())
            return root.negateFloat(value);
        throw new RuntimeException("NYI");
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

    public boolean isFloat() {
        return !isInt && !isBool && primitive;
    }

    public boolean isNumber() {
        return isInt || isFloat();
    }

    public int numberSize(BuilderRoot root) {
        return isInt ? root.getIntSize(llvm) : root.getFloatSize(llvm);
    }

    // val.type -> me
    // (me) val
    public LLVMValueRef cast(BuilderRoot root, Value val) {
        if (intInt(val.type)) {
            if (signed && val.type.signed) {
                int sizeSelf = root.getIntSize(llvm);
                int sizeOther = root.getIntSize(val.type.llvm);

                if (sizeSelf > sizeOther) return root.bitcastOrExtend(llvm, val.llvm, "cast_to" + this);
                else if (sizeSelf == sizeOther) return val.llvm;
                else return root.truncate(llvm, val.llvm, "cast_to" + this);
            } else throw new RuntimeException("NYI");
        } else {
            if (isFloat() && val.type.isInt && val.type.signed)
                return root.castSIToFP(llvm, val.llvm, "cast_to_float");

            if (isInt && signed && val.type.isFloat())
                return root.castFPToSI(llvm, val.llvm, "cast_to_int");

            if (val.type.llvm.equals(llvm)) return val.llvm;
            if (isFloat()) return root.castFP(llvm, val.llvm, "cast_fp_to_fp");

            throw new RuntimeException("NYI");
        }
    }

    public Type coerce(BuilderRoot root, Type type) {
//        if (!this.equals(type)) throw new RuntimeException("NYI");
        if (intInt(type)) {
            if (signed && type.signed) {
                int selfSize = root.getIntSize(llvm);
                int otherSize = root.getIntSize(type.llvm);

                if (selfSize < otherSize) return type;
                return this;
            } else if (!signed && !type.signed) {
//                int selfSize = root.getIntSize(llvm);
//                int otherSize = root.getIntSize(type.llvm);
//
//                if (selfSize < otherSize) return type;
//                return this;
                throw new RuntimeException("NYI");
            } else throw new RuntimeException("NYI");
        } else if (isFloat() || type.isFloat()) {
            int mySize = numberSize(root);
            int otherSize = type.numberSize(root);

            if (mySize == otherSize) return this;

            return new Type(
                    root.getFloatType(Math.max(mySize, otherSize)),
                    false, true, true, false
            );
        } else if (this.isBool && type.isBool) return this;
        throw new RuntimeException("NYI");
    }

    public LLVMValueRef coerce(
            BuilderRoot root, RaluxFunctionConsumer consumer,
            LLVMValueRef llvm, Type type
    ) {
        return coerce(root, type).cast(root, new Value(root, consumer, llvm, type));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return this.isVoid == type.isVoid && signed == type.signed && primitive == type.primitive && isInt == type.isInt && Objects.equals(llvm, type.llvm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(llvm, signed, primitive, isInt);
    }

    @Override
    public String toString() {
        if (isVoid) return "void";
        if (isBool) return "bool";
        if (isInt) return "int" + numberSize(root);
        if (isFloat()) return "fp" + numberSize(root);
        return "unknown_type";
    }

    public boolean canAutoCast(Type type) {
        if (isNumber() && type.isNumber()) {
//            if (numberSize(root) <= type.numberSize(root)) {
//                return true;
//            }
        }

        return this.equals(type);
    }
}
