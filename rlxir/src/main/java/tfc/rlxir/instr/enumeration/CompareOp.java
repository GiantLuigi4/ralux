package tfc.rlxir.instr.enumeration;

public enum CompareOp {
    LE("<="),
    LT("<"),
    GT(">"),
    GE(">="),
    EQ("=="),
    NE("!="),
	;
	
	final String symbol;
	
	CompareOp(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
