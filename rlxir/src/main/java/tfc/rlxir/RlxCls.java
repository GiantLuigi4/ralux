package tfc.rlxir;

import tfc.rlxir.util.CompilerDataHolder;

import java.util.ArrayList;
import java.util.List;

public class RlxCls extends CompilerDataHolder<RlxCls> {
    public final String name;
    RlxCls parent;
    List<RlxFunction> functions = new ArrayList<>();

    public void addFunction(RlxFunction function) {
        this.functions.add(function);
    }

    public RlxCls(String name) {
        this.name = name;
    }

    public boolean isFunctionInherited(RlxFunction function) {
        if (parent != null)
            return parent.definesOrInheritsFunction(function);
        return false;
    }

    private boolean definesOrInheritsFunction(RlxFunction function) {
        if (definesFunction(function)) return true;
        if (parent != null)
            return parent.definesOrInheritsFunction(function);
        return false;
    }

    private boolean definesFunction(RlxFunction function) {
        for (RlxFunction rlxFunction : this.functions) {
            if (function.enclosure.equals(rlxFunction.enclosure)) {
                return true;
            }
        }
        return false;
    }

    public String qualifiedName() {
        return name;
    }

    public RlxCls getParent() {
        return parent;
    }

    // TODO: read-only list
    public List<RlxFunction> getFunctions() {
        return functions;
    }
}
