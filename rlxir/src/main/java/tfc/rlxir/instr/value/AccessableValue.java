package tfc.rlxir.instr.value;

import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.typing.RlxType;

public interface AccessableValue {
	void set(RlxFunction function, ValueInstr value);
	void set(ValueInstr value);
	ValueInstr get(RlxFunction function);
	ValueInstr get();
	RlxType valueType();
}
