package tfc.rlxir;

import tfc.rlxir.comphints.ClassCompilerHint;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.util.CompilerDataHolder;
import tfc.rlxir.util.IndexedHashSet;

import java.util.*;

public class RlxCls extends CompilerDataHolder<RlxCls> {
    // rlxrt has 3 builtin fields
    public static final int OBJ_BASE = 3 * 8;

    public final String name;
    public final String pkg;
    RlxCls parent;
    List<RlxFunction> functions = new ArrayList<>();
    List<String> using = new ArrayList<>();
    List<ClassCompilerHint> compilerHints = new ArrayList<>();
    Map<String, RlxField> fields = new HashMap<>();
    IndexedHashSet<RlxField> fieldsSet = new IndexedHashSet<>();

    public void addFunction(RlxFunction function) {
        this.functions.add(function);
    }

    public RlxField addField(boolean isStatic, RlxType type, String name) {
        RlxField field = new RlxField(isStatic, type, this.type, name);
        fields.put(name, field);
        fieldsSet.add(field);
        return field;
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

    public RlxField getField(String text) {
        return fields.get(text);
    }

    public Collection<RlxField> getFields() {
        return fields.values();
    }

    public int getFieldOffset(RlxField field) {
        IndexedHashSet<RlxField>.Index index = fieldsSet.getRoot();

        int offset = 0;
        while (index.getElem() != field) {
            offset += index.getElem().type.getElementByteSize();
            index = index.getNext();
        }
        return offset;
    }
}
