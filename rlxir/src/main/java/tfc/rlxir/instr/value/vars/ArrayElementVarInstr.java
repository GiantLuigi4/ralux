//package tfc.rlxir.instr.value.vars;
//
//import tfc.rlxir.RlxField;
//import tfc.rlxir.RlxFunction;
//import tfc.rlxir.instr.base.ValueInstr;
//import tfc.rlxir.instr.enumeration.InstrType;
//import tfc.rlxir.typing.RlxType;
//
//public class ArrayElementVarInstr extends VarInstr {
//    public final boolean isStatic;
//    public final RlxType owner;
//    public final RlxField field;
//    public final ValueInstr base;
//    public final ValueInstr element;
//
//    public ArrayElementVarInstr(boolean isStatic, RlxType owner, RlxType type, RlxField field, ValueInstr base, ValueInstr element) {
//        super(type);
//        this.isStatic = isStatic;
//        this.owner = owner;
//        this.field = field;
//        this.base = base;
//		this.element = element;
//    }
//
//    @Override
//    public InstrType type() {
//        return InstrType.ARRAY_VAR;
//    }
//
//    @Override
//    public ValueInstr get(RlxFunction function) {
//        FieldGetInstr instr = new FieldGetInstr(this);
//        function.addInstr(instr);
//        return instr;
//    }
//
//    @Override
//    @Deprecated(forRemoval = true)
//    public ValueInstr get() {
//        throw new RuntimeException("Cannot default get field");
//    }
//
//    @Override
//    public void set(RlxFunction function, ValueInstr value) {
//        if (!type.equals(value.valueType())) {
//            throw new RuntimeException(type + " variable cannot be set as a " + value.valueType() + ". Are you missing a cast?");
//        }
//        function.addInstr(new FieldSetInstr(this, value));
//    }
//
//    @Override
//    @Deprecated(forRemoval = true)
//    public void set(ValueInstr value) {
//        throw new RuntimeException("Cannot default set field");
//    }
//
//    public ArrayElementVarInstr from(ValueInstr base) {
//        return new ArrayElementVarInstr(isStatic, owner, type, field, base);
//    }
//}
