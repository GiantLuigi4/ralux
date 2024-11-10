package tfc.rlxir.instr.enumeration;

public enum InstrType {
    CONST, CAST,
    MATH, DEFINE_VAR,
    GET_VAR, SET_VAR,
    RETURN_VOID, RETURN_VALUE,
    NOP,
    COMPILER_ERROR,
    CONST_JUMP, COND_JUMP, COMPARISON, DEBUG_PRINT, DEBUG_READ_INT;
}
