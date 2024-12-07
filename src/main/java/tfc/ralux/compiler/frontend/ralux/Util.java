package tfc.ralux.compiler.frontend.ralux;

import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import tfc.rlxir.instr.base.ValueInstr;

public class Util {
    public static void setLineColumn(ValueInstr instr, TerminalNodeImpl child, String source) {
        instr.setLine(child.getPayload().getLine());
        instr.setColumn(child.getPayload().getCharPositionInLine());
        instr.setSourceFile(source);
    }
}
