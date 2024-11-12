package tfc.rlxir;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.util.CompilerDataHolder;

import java.util.ArrayList;
import java.util.List;

public class RlxBlock extends CompilerDataHolder<RlxBlock> {
    public final String name;
    protected boolean isTerminated;

    public RlxBlock(String name) {
        this.name = name;
    }

    List<RlxInstr> instrs = new ArrayList<>();

    public List<RlxInstr> getInstructions() {
        // TODO: read-only list
        return instrs;
    }

    public boolean isTerminated() {
        return isTerminated;
    }
}
