package tfc.rlxir.writer;

import tfc.rlxir.*;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.action.ConditionalJumpInstr;
import tfc.rlxir.instr.action.JumpInstr;
import tfc.rlxir.instr.action.ReturnInstr;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.debug.*;
import tfc.rlxir.instr.enumeration.BooleanOp;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.instr.value.*;
import tfc.rlxir.instr.value.arrays.ArrayGet;
import tfc.rlxir.instr.value.arrays.ArraySet;
import tfc.rlxir.instr.value.arrays.ArrayVarInstr;
import tfc.rlxir.instr.value.arrays.MArrayInstr;
import tfc.rlxir.instr.value.obj.AllocInstr;
import tfc.rlxir.instr.value.obj.CallInstr;
import tfc.rlxir.instr.value.vars.*;
import tfc.rlxir.typing.RlxType;

import java.util.*;

public class IRWriter {
	public static void writeModule(StringBuilder builder, RlxModule module) {
		for (RlxCls aClass : module.getClasses()) {
			writeClass(builder, aClass);
		}
	}
	
	public static void writeClass(StringBuilder builder, RlxCls aClass) {
		// TODO: access
		builder.append(aClass.qualifiedName()).append(" {\n");
		
		for (RlxField field : aClass.getFields()) {
			writeField(builder, field);
		}
		
		for (RlxFunction function : aClass.getFunctions()) {
			writeFunction(builder, function);
		}
		
		builder.append("}\n");
	}
	
	public static void writeField(StringBuilder builder, RlxField field) {
		// TODO: access
		builder.append("\t");
		builder.append(field.name);
		builder.append(":");
		writeType(builder, field.type);
		builder.append("\n");
	}
	
	public static void writeFunction(StringBuilder builder, RlxFunction function) {
		builder.append("\t");
		if (function.getExportName() != null) {
			builder.append("+[").append(function.getExportName()).append("]\n\t");
		}
		
		writeType(builder, function.enclosure.result);
		builder.append(" ");
		builder.append(function.enclosure.name);
		
		builder.append("(");
		for (RlxType rlxType : function.enclosure.descr) {
			writeType(builder, rlxType);
		}
		builder.append(")");
		builder.append(" {\n");
		
		writeBody(builder, function);
		
		builder.append("\t}\n");
	}
	
	private static void writeBody(StringBuilder builder, RlxFunction function) {
		Map<RlxInstr, String> ids = new HashMap<>();
		Set<String> instrNames = new HashSet<>();
		
		for (RlxBlock block : function.getBlocks()) {
			for (RlxInstr instruction : block.getInstructions()) {
				String name = instruction.instructionLabel();
				if (name != null) {
					name = findFree(instrNames, name);
				}
				
				if (name == null) {
					// we can use localized lowercase
					name = findFree(instrNames, instruction.type().name().toLowerCase());
				}
				
				for (char c : name.toCharArray()) {
					if (Character.isWhitespace(c)) {
						throw new RuntimeException("Cannot have whitespace in an instruction label if writing to IR. " + name);
					}
					switch (c) {
						case '{', '}', '[', ']', '(', ')',
						     ',', '.', ':', ';',
						     '+', '-', '/', '*', '&', '|', '^', '!':
							throw new RuntimeException("Reserved symbol: " + c + " used in instruction label: " + name);
					}
				}
				
				ids.put(instruction, name);
				instrNames.add(name);
			}
		}
		
		for (RlxBlock block : function.getBlocks()) {
			builder.append("\t").append(block.name).append(":\n");
			
			for (RlxInstr instruction : block.getInstructions()) {
				builder.append("\t\t");
				
				builder.append(ids.get(instruction)).append(" ");
				builder.append(instruction.type().name());
				builder.append("\t\t");
				writeArgs(builder, instruction, ids);
				builder.append("\n");
			}
		}
	}
	
	private static String getStr(Map<RlxInstr, String> ids, RlxInstr instr) {
		if (ids.containsKey(instr)) {
			return ids.get(instr);
		}
		
		if (instr instanceof ConstInstr<?> cnst) {
			StringBuilder builder = new StringBuilder();
			writeType(builder, cnst.type);
			return "(" + builder.toString() + ")" + ((ConstInstr<?>) instr).data.toString();
		}
		
		if (instr instanceof FieldInstr finstr) {
			StringBuilder builder = new StringBuilder();
			writeType(builder, finstr.type);
			builder.append(" ");
			builder.append(getStr(ids, finstr.base));
			builder.append(" ");
			builder.append(finstr.isStatic ? "s" : "i");
			builder.append(" ");
			writeType(builder, finstr.owner);
			builder.append(" ");
			builder.append(finstr.field.name);
			return "field{" + builder + "}";
		}
		
		throw new RuntimeException("wat?");
	}
	
	private static void writeArgs(StringBuilder builder, RlxInstr instruction, Map<RlxInstr, String> ids) {
		switch (instruction.type()) {
			case NOP, RETURN_VOID, DEBUG_READ_CHAR -> {
				return;
			}
			case NEGATE -> {
				String id = getStr(ids, ((NegInstr) instruction).source);
				builder.append(id);
			}
			case MATH -> {
				MathInstr mth = (MathInstr) instruction;
				builder
						.append(mth.variant.name())
						.append(" ")
						.append(getStr(ids, mth.left))
						.append(mth.op.getSymbol())
						.append(getStr(ids, mth.right))
				;
			}
			case CONST -> {
				builder.append(getStr(ids, instruction));
			}
			case CAST -> {
				CastInstr cast = (CastInstr) instruction;
				builder.append(cast.mode).append(" ");
				writeType(builder, cast.fromType());
				builder.append(" -> ");
				writeType(builder, cast.valueType());
				builder.append(" ");
				builder.append(getStr(ids, ((CastInstr) instruction).value));
			}
			case CALL -> {
				CallInstr call = (CallInstr) instruction;
				builder.append(call.owner.qualifiedName()).append(" ");
				builder.append(call.name).append(" ");
				for (ValueInstr param : call.params) {
					builder.append(getStr(ids, param));
					builder.append(" ");
				}
			}
			case RETURN_VALUE -> {
				ReturnInstr ret = (ReturnInstr) instruction;
				builder.append(getStr(ids, ret));
			}
			case CONST_JUMP -> {
				JumpInstr instr = (JumpInstr) instruction;
				builder.append(instr.target.name);
			}
			case COND_JUMP -> {
				ConditionalJumpInstr instr = (ConditionalJumpInstr) instruction;
				builder.append(getStr(ids, instr.condition));
				builder.append(" ");
				builder.append(instr.targetTrue.name);
				builder.append(" ");
				builder.append(instr.targetFalse.name);
			}
			case DEFINE_VAR -> {
				VarInstr instr = (VarInstr) instruction;
				writeType(builder, instr.type);
				if (instr.paramFrom != -1) {
					builder.append(" ");
					builder.append(instr.paramFrom);
				}
			}
			case FIELD_VAR -> {
				FieldInstr instr = (FieldInstr) instruction;
				writeType(builder, instr.type);
				builder.append(" ");
				builder.append(getStr(ids, instr.base));
				builder.append(" ");
				builder.append(instr.isStatic ? "s" : "i");
				builder.append(" ");
				writeType(builder, instr.owner);
				builder.append(" ");
				builder.append(instr.field.name);
			}
			case GET_VAR -> {
				GetInstr instr = (GetInstr) instruction;
				builder.append(getStr(ids, instr));
			}
			case SET_VAR -> {
				SetInstr instr = (SetInstr) instruction;
				builder.append(getStr(ids, instr.var));
				builder.append(" = ");
				builder.append(getStr(ids, instr.value));
			}
			case ARRAY_GET -> {
				ArrayGet instr = (ArrayGet) instruction;
				builder.append(getStr(ids, instr.array)).append("[");
				builder.append(getStr(ids, instr.index)).append("]");
			}
			case ARRAY_SET -> {
				ArraySet instr = (ArraySet) instruction;
				builder.append(getStr(ids, instr.array)).append("[");
				builder.append(getStr(ids, instr.index)).append("]");
				builder.append("=").append(getStr(ids, instr.value));
			}
			case ARRAY_VAR -> {
				ArrayVarInstr instr = (ArrayVarInstr) instruction;
				builder.append(getStr(ids, instr.wrapped)).append("[");
				builder.append(getStr(ids, instr.index)).append("]");
			}
			case DEBUG_PRINT -> {
				DebugPrint instr = (DebugPrint) instruction;
				builder.append(getStr(ids, instr.value));
			}
			case DEBUG_WRITE -> {
				DebugWriteString instr = (DebugWriteString) instruction;
				builder.append(getStr(ids, instr.value));
			}
			case DEBUG_RANDOM -> {
				TwoValueDebug instr = (TwoValueDebug) instruction;
				builder.append(getStr(ids, instr.left)).append(" ");
				builder.append(getStr(ids, instr.right));
			}
			case DEBUG_READ_INT -> {
				DebugReadInt instr = (DebugReadInt) instruction;
				writeType(builder, instr.type);
			}
			case ALLOC -> {
				AllocInstr instr = (AllocInstr) instruction;
				writeType(builder, instr.type);
			}
			case MAKE_ARRAY -> {
				MArrayInstr mArrayInstr = (MArrayInstr) instruction;
				writeType(builder, mArrayInstr.baseType);
				builder.append(" ");
				builder.append(getStr(ids, mArrayInstr.size));
			}
			case COMPARISON -> {
				CompareInstr instr = (CompareInstr) instruction;
				builder.append(instr.variant.name()).append(" ");
				builder.append(getStr(ids, instr.left));
				builder.append(" ").append(instr.op.getSymbol()).append(" ");
				builder.append(getStr(ids, instr.right));
			}
			case BOOLEAN_OP -> {
				BoolInstr instr = (BoolInstr) instruction;
				builder.append(getStr(ids, instr.left));
				builder.append(" ").append(instr.op.getSymbol()).append(" ");
				builder.append(getStr(ids, instr.right));
			}
			case GET_FIELD -> {
				FieldGetInstr instr = (FieldGetInstr) instruction;
				builder.append(getStr(ids, instr.var));
			}
			case SET_FIELD -> {
				FieldSetInstr instr = (FieldSetInstr) instruction;
				builder.append(getStr(ids, instr.var));
				builder.append(" = ");
				builder.append(getStr(ids, instr.value));
			}
			default -> {
				throw new RuntimeException("NYI: " + instruction.type());
			}
		}
	}
	
	private static String findFree(Set<String> instrNames, String name) {
		if (!instrNames.contains(name)) {
			return name;
		}
		
		int sep = 0;
		while (true) {
			String testName = name + sep;
			if (!instrNames.contains(testName)) {
				return testName;
			}
			sep++;
		}
	}
	
	public static void writeType(StringBuilder builder, RlxType type) {
		if (type.isArray()) {
			builder.append("[");
			writeType(builder, type.arrayOf);
			builder.append("]");
		} else if (type.isPtr()) {
			builder.append("T");
			builder.append(type.clazz.qualifiedName());
			builder.append(";");
		} else {
			builder.append("P");
			builder.append(type);
			builder.append(";");
		}
	}
}
