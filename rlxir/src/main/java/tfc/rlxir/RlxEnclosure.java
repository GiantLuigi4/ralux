package tfc.rlxir;

import tfc.rlxir.typing.RlxType;

import java.util.List;
import java.util.Objects;

public class RlxEnclosure {
    public final RlxType result;
    public final String name;
    public final List<RlxType> descr;

    public RlxEnclosure(RlxType result, String name, List<RlxType> descr) {
        this.result = result;
        this.name = name;
        this.descr = descr;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        RlxEnclosure that = (RlxEnclosure) object;
        return Objects.equals(result, that.result) && Objects.equals(name, that.name) && Objects.equals(descr, that.descr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, name, descr);
    }
}
