package tfc.rlxir.instr.enumeration;

public enum InstrType {
    CONST, CAST,
    COMPARISON, MATH,
    DEFINE_VAR, GET_VAR, SET_VAR,
    RETURN_VOID, RETURN_VALUE,
    NOP,
    COMPILER_ERROR,
    CONST_JUMP, COND_JUMP,
    DEBUG_PRINT, DEBUG_READ_INT, DEBUG_HAS_INPUT,
    MAKE_ARRAY, ARRAY_GET, ARRAY_SET, BOOLEAN_OP, DEBUG_RANDOM, NEGATE, CALL;
}
