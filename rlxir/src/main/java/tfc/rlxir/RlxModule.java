package tfc.rlxir;

import tfc.rlxir.enumeration.LinkMode;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.instr.value.vars.GetInstr;
import tfc.rlxir.instr.value.vars.SetInstr;
import tfc.rlxir.instr.value.vars.VarInstr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RlxModule {
    public LinkMode preferredLinkMode = LinkMode.PROGRAM;
    final String name;
    List<RlxCls> classes = new ArrayList<>();
    HashMap<String, RlxPackage> packages = new HashMap<>();
    HashMap<String, RlxCls> classesByName = new HashMap<>();

    public RlxModule(String name) {
        this.name = name;
    }

    public RlxModule(String name, LinkMode preferredLinkMode) {
        this.name = name;
        this.preferredLinkMode = preferredLinkMode;
    }

    public RlxCls getClass(String qualifiedName) {
        return classesByName.get(qualifiedName);
    }

    public RlxPackage getPackage(String packageName) {
        return packages.get(packageName);
    }

    public String getName() {
        return name;
    }

    public void addClass(RlxCls cls) {
        this.classes.add(cls);
        this.classesByName.put(cls.qualifiedName(), cls);
        if (cls.pkg != null) {
            RlxPackage pkg = this.packages.get(cls.pkg);
            if (pkg == null) {
                pkg = new RlxPackage();
                this.packages.put(cls.pkg, pkg);
            }
            pkg.classes.put(cls.name, cls);
        }
    }

    public List<RlxCls> getClasses() {
        // TODO: read-only list
        return classes;
    }

    protected String instrStr(RlxInstr instr) {
//        if (instr.type() == InstrType.DEFINE_VAR) {
//            return instr.type().name().toLowerCase() + " # " + ((VarInstr) instr).debugName();
//        } else if (instr.type() == InstrType.SET_VAR) {
//            return instr.type().name().toLowerCase() + " # " + ((SetInstr) instr).var.debugName();
//        } else if (instr.type() == InstrType.GET_VAR) {
//            return instr.type().name().toLowerCase() + " # " + ((GetInstr) instr).var.debugName();
//        }

        return instr.type().name().toLowerCase();
    }

    public String asText() {
        StringBuilder builder = new StringBuilder();
        builder.append("# Module: ").append(name)
                .append("\n# Linkage: ").append(preferredLinkMode)
                .append("\n\n");

        for (RlxCls aClass : classes) {
            builder.append(aClass.qualifiedName()).append(" {\n");
            for (RlxFunction function : aClass.getFunctions()) {
                builder.append("\tfunc ")
                        .append(function.access)
                        .append(function.isStatic ? "s" : "")
                        .append(function.isFinal ? "f" : "")
                        .append(" ")
                        .append(function.enclosure)
                        .append(" {\n");

                for (RlxBlock block : function.blocks) {
                    builder.append("\t")
                            .append(block.name)
                            .append(": # ")
                            .append(block.instrs.size())
                            .append(" instructions")
                            .append("\n");
                    builder.append("\t\t# TODO: list instr args (as indices)\n");

                    for (RlxInstr instruction : block.getInstructions()) {
                        boolean hasDebug = instruction.isLineSet() || instruction.isColumnSet() || instruction.getSourceFile() != null;
                        builder.append("\t\t")
                                .append(instruction.isConst() ? "c" : "")
                                .append(instruction.hasDependencies() ? "d" : "")
                                .append(instruction.isConst() || instruction.hasDependencies() ? " " : "")
                                .append(instruction.providesValue() ? (instruction.valueType().toString() + " ") : "")
                                .append(instrStr(instruction))
                                .append(hasDebug ? " : " : "")
                                .append(instruction.isLineSet() ? ("ln: " + instruction.getLine() + " ") : "")
                                .append(instruction.isColumnSet() ? ("col: " + instruction.getColumn() + " ") : "")
                                .append(instruction.getSourceFile() != null ? ("src: " + instruction.getSourceFile()) : "")
                                .append("\n");
                    }
                }

                builder.append("\t}\n");
            }
            builder.append("}\n");
        }
        return builder.toString();
    }

    public RlxFunction findMethod(RlxCls owner, String name, List<ValueInstr> params) {
        for (RlxFunction function : owner.getFunctions()) {
            if (function.enclosure.name.equals(name)) {
                if (function.enclosure.isApplicable(params)) {
                    return function;
                }
            }
        }
        // TODO: display arg types
        throw new RuntimeException("Could not find method " + name + " on class " + owner);
    }
}
