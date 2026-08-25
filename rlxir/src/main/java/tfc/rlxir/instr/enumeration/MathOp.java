package tfc.rlxir.instr.enumeration;

public enum MathOp {
    SUM('+'), DIFF('-'), PRODUCT('*'), QUOTIENT('/'), REMAINDER('%');
	
	private final char symbol;
	
	MathOp(char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
