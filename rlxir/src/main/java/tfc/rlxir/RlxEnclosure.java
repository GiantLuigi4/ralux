package tfc.rlxir;

import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.typing.PrimitiveType;
import tfc.rlxir.typing.RlxType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RlxEnclosure {
    public final boolean isStub;
    public final RlxType result;
    public final String name;
    public final List<RlxType> descr;

    public RlxEnclosure(RlxType result, String name, List<RlxType> descr) {
        this(false, result, name, descr);
    }

    public RlxEnclosure(boolean isStub, RlxType result, String name, List<RlxType> descr) {
        this.isStub = isStub;
        this.result = result;
        this.name = name;
        this.descr = descr;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RlxEnclosure that = (RlxEnclosure) object;
        return isStub == that.isStub && Objects.equals(result, that.result) && Objects.equals(name, that.name) && Objects.equals(descr, that.descr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isStub, result, name, descr);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (isStub) builder.append("stub ");
        builder.append(result + " " + name + "(");
        for (RlxType type : descr) {
            builder.append(type).append(",");
        }
        builder.append(")");
        return builder.toString();
    }

    public boolean isApplicable(List<ValueInstr> params) {
        if (params.size() != descr.size()) return false;

        // TODO: check vargs
        for (int i = 0; i < params.size(); i++) {
            RlxType type = descr.get(i);
            if (!type.isAssignableFrom(params.get(i).valueType())) {
                return false;
            }
        }
        return true;
    }

    public boolean isVoid() {
        return result.type == PrimitiveType.VOID;
    }

    public List<ValueInstr> castArgs(RlxFunction function, List<ValueInstr> params) {
        List<ValueInstr> res = new ArrayList<>();

        // TODO: deal with vargs
        for (int i = 0; i < params.size(); i++) {
            ValueInstr instr = params.get(i);
            instr = function.assignmentCast(instr, descr.get(i));
            res.add(instr);
        }

        return res;
    }
}
