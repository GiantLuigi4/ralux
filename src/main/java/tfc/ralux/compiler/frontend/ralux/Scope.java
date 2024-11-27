package tfc.ralux.compiler.frontend.ralux;

import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxType;

import java.util.HashMap;
import java.util.Map;

public class Scope {
    Map<String, VarInstr> variables = new HashMap<>();
    Map<String, ValueInstr> got = new HashMap<>();

    public VarInstr getVar(String name) {
        return variables.get(name);
    }

    // TODO: validate that this is valid
    public ValueInstr getCached(String name) {
        ValueInstr val = got.get(name);
        if (val == null) {
            val = variables.get(name).get();
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
    }

    public VarInstr makeVar(RlxFunction function, String name, RlxType type) {
        VarInstr instr = function.makeVar(type);
        instr.setDebugName(name);
        variables.put(name, instr);
        return instr;
    }
}
