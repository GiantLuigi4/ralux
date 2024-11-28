package tfc.ralux.compiler.frontend.ralux;

import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxType;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Scope {
    Map<String, VarInstr> variables = new HashMap<>();
    Stack<Map<String, ValueInstr>> caches = new Stack<>();
    Map<String, ValueInstr> got = new HashMap<>();
    Scope parent;

    public Scope(Scope parent) {
        this.parent = parent;
    }

    public Scope() {
    }

    public void pushCache() {
        caches.push(got);
        got = new HashMap<>();
    }

    public void popCache() {
        got = caches.pop();
    }

    public VarInstr getVar(String name) {
        VarInstr var = variables.get(name);
        if (var == null && parent != null) {
            var = parent.getVar(name);
            variables.put(name, var);
        }
        return var;
    }

    // TODO: validate that this is valid
    public ValueInstr getCached(String name) {
        ValueInstr val = got.get(name);
        if (val == null) {
            val = getVar(name).get();
            got.put(name, val);
        }
        return val;
    }

    public void parameterize(RlxFunction function, RaluxToIR.Params params) {
        for (int i = 0; i < params.types.size(); i++) {
            RlxType type = params.types.get(i);
            String name = params.names.get(i);

            VarInstr instr = function.param(type, i).setDebugName("p_" + name);
            variables.put(name, instr);
        }
    }

    public void dirtyVar(String name) {
        got.remove(name);
        if (parent != null) parent.dirtyVar(name);
    }

    public VarInstr makeVar(RlxFunction function, String name, RlxType type) {
        if (getVar(name) != null) throw new RuntimeException("Variable with name " + name + " already exists");

        VarInstr instr = function.makeVar(type);
        instr.setDebugName(name);
        variables.put(name, instr);
        return instr;
    }
}
