package tfc.rlxir.instr.enumeration;

public enum BooleanOp {
    AND("&&"),
    OR("||"),
    XOR("^"),
    NOR("!|"),
	;
	
	final String symbol;
	
	BooleanOp(String symbol) {
		this.symbol = symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
}
