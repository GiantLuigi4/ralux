package tfc.rlxir.instr.enumeration;

public enum InstrType {
    // consts&casts
    CONST, CAST,
    // math instrs
    COMPARISON, MATH, BOOLEAN_OP, NEGATE,
    // var instrs
    DEFINE_VAR, GET_VAR, SET_VAR, FIELD_VAR,
    // return instrs
    RETURN_VOID, RETURN_VALUE,
    // compiler internals
    NOP, COMPILER_ERROR,
    // jump instrs
    CONST_JUMP, COND_JUMP,
    // debug instrs
    DEBUG_PRINT, DEBUG_READ_INT, DEBUG_HAS_INPUT, DEBUG_RANDOM,
    // array instrs
    MAKE_ARRAY, ARRAY_GET, ARRAY_SET,
    // obj instrs
    ALLOC, CALL, GET_FIELD, SET_FIELD,
}
