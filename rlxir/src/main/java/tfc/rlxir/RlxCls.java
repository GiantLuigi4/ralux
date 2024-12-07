package tfc.rlxir;

import tfc.rlxir.comphints.ClassCompilerHint;
import tfc.rlxir.comphints.FunctionCompilerHint;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.util.CompilerDataHolder;

import java.util.ArrayList;
import java.util.List;

public class RlxCls extends CompilerDataHolder<RlxCls> {
    public final String name;
    public final String pkg;
    RlxCls parent;
    List<RlxFunction> functions = new ArrayList<>();
    List<String> using = new ArrayList<>();
    List<ClassCompilerHint> compilerHints = new ArrayList<>();

    public void addFunction(RlxFunction function) {
        this.functions.add(function);
    }

    public RlxCls(String pkg, String name) {
        this.pkg = pkg;
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
        if (pkg != null)
            return pkg + "." + name;
        return name;
    }

    public RlxCls getParent() {
        return parent;
    }

    // TODO: read-only list
    public List<RlxFunction> getFunctions() {
        return functions;
    }

    final RlxType type = new RlxType(this);

    public RlxType getType() {
        return type;
    }


    public void addUsings(List<String> using) {
        this.using.addAll(using);
    }

    @Override
    public String toString() {
        return qualifiedName();
    }
}
