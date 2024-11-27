package tfc.rlxir.instr.value;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.instr.enumeration.MathOp;
import tfc.rlxir.instr.enumeration.MathVariant;
import tfc.rlxir.typing.RlxType;

public class MathInstr extends ValueInstr {
    public final MathOp op;
    public final MathVariant variant;
    public final ValueInstr left, right;
    private final boolean isConst;

    protected boolean checkConst() {
        if (isZero()) return true;
        return left.isConst() && (right.isConst());
    }

    public MathInstr(MathOp op, MathVariant variant, ValueInstr left, ValueInstr right) {
        this.op = op;
        this.variant = variant;
        this.left = left;
        this.right = right;
        if (!left.valueType().isOperable(right.valueType()))
            throw new RuntimeException("Cannot operate on values of types " + left.valueType() + " and " + right.valueType() + ". Are you missing a cast?");
        this.isConst = checkConst();
    }

    @Override
    public boolean hasDependencies() {
        return true;
    }

    @Override
    public RlxType valueType() {
        // TODO: unsure if I need any more logic than this
        // I think this is fine though
        return left.valueType();
    }

    @Override
    public InstrType type() {
        return InstrType.MATH;
    }

    @Override
    public boolean isConst() {
        return isConst;
    }

    @Override
    public boolean isZero() {
        if (op == MathOp.PRODUCT) return (left.isZero() || right.isZero());
        if (op == MathOp.DIFF) return left.equals(right);
        return false;
    }

    @Override
    public boolean isOne() {
        // don't really care to inference this
        return false;
    }

    public ValueInstr eval() {
        // TODO:
        return this;
    }

    @Override
    public boolean dependsOn(RlxInstr other) {
        return left == other || right == other || left.dependsOn(other) || right.dependsOn(other);
    }
}
