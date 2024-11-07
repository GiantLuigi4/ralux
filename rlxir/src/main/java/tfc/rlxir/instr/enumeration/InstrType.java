package tfc.rlxir.instr.enumeration;

public enum InstrType {
    CONST, CAST,
    MATH, DEFINE_VAR,
    GET_VAR, SET_VAR,
    RETURN_VOID, RETURN_VALUE,
    NOP,
    COMPILER_ERROR
    ;
}
