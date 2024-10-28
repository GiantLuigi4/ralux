package compiler.compiler.analysis;

import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;

import java.util.HashMap;
import java.util.Map;

public class Scope {
    Map<String, Variable> variables = new HashMap<>();
    Scope parentScope;
    BuilderRoot root;
    FunctionBuilder builder;

    public Scope(BuilderRoot root, FunctionBuilder builder, Scope parentScope) {
        this.root = root;
        this.builder = builder;
        this.parentScope = parentScope;
    }

    public Variable defineVariable(String name, Type type) {
        Variable var = getVariable(name);
        if (var != null) throw new RuntimeException("Variable " + name + " already defined.");

        variables.put(name, var = new Variable(root, type));
        var.llvm = root.allocA(type.llvm(), name);
        return var;
    }

    public Variable getVariable(String name) {
        Variable var = variables.get(name);
        if (var == null) {
            if (parentScope != null) {
                return parentScope.getVariable(name);
            }
        }
        return var;
    }
}
