package tfc.rlxir.instr.value.arrays;

import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.base.BaseInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.InstrType;
import tfc.rlxir.instr.value.AccessableValue;
import tfc.rlxir.instr.value.vars.GetInstr;
import tfc.rlxir.instr.value.vars.SetInstr;
import tfc.rlxir.typing.RlxType;

public class ArrayVarInstr extends BaseInstr implements AccessableValue {
	ValueInstr wrapped;
	ValueInstr index;
	
	public ArrayVarInstr(
			ValueInstr wrapped,
			ValueInstr index
	) {
		this.wrapped = wrapped;
		this.index = index;
	}
	
	@Override
	public void set(RlxFunction function, ValueInstr value) {
		set(value);
	}
	
	@Override
	public void set(ValueInstr value) {
		if (!wrapped.valueType().arrayOf.equals(value.valueType())) {
			throw new RuntimeException(wrapped.valueType().arrayOf + " variable cannot be set as a " + value.valueType() + ". Are you missing a cast?");
		}
		function.addInstr(new ArraySet(wrapped, index, value));
	}
	
	@Override
	public ValueInstr get(RlxFunction function) {
		if (function != this.function) throw new RuntimeException("Cannot get var from another function");
		return get();
	}
	
	@Override
	public ValueInstr get() {
		ArrayGet instr = new ArrayGet(wrapped, index);
		function.addInstr(instr);
		return instr;
	}
	
	@Override
	public boolean hasDependencies() {
		return true;
	}
	
	@Override
	public InstrType type() {
		return InstrType.ARRAY_VAR;
	}
	
	@Override
	public boolean isConst() {
		return false;
	}
	
	@Override
	public boolean dependsOn(RlxInstr other) {
		return wrapped == other || wrapped.dependsOn(other);
	}
	
	@Override
	public boolean canBeOrganized() {
		return false;
	}
	
	@Override
	public RlxType valueType() {
		return wrapped.valueType().debox();
	}
}
