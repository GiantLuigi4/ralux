package tfc.rlxir;

import tfc.rlxir.instr.value.vars.FieldInstr;
import tfc.rlxir.typing.RlxType;

public class RlxField {
    public final RlxType type;
    public final String name;
    public final FieldInstr instr;

    public RlxField(boolean isStatic, RlxType type, RlxType owner, String name) {
        this.type = type;
        this.name = name;
        instr = new FieldInstr(
                isStatic, owner, type, this
        );
    }
}
