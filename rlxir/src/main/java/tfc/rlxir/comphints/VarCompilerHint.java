package tfc.rlxir.comphints;

import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.typing.RlxType;

public interface VarCompilerHint {
    RlxType retype(RlxCls clazz, RlxFunction function, RlxType type);

    ValueInstr process(RlxCls clazz, RlxFunction function, ValueInstr instr);
}
