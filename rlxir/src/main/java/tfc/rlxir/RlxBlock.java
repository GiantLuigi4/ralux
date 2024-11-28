package tfc.rlxir;

import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.action.JumpInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.util.CompilerDataHolder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RlxBlock extends CompilerDataHolder<RlxBlock> {
    public final String name;
    private boolean isTerminated;
    StackTraceElement[] whenTerminated;

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

    public RlxBlock getRedir(Set<RlxBlock> redirSteps) {
        // infinite loop
        if (!redirSteps.add(this))
            return this;

        if (instrs.isEmpty()) return this; // empty block
        RlxInstr instr0 = instrs.get(0);

        // if the only thing the block does is jump to another block, then there's no point in having the block, so just redirect directly to the other block
        if (instr0 instanceof JumpInstr)
            return ((JumpInstr) instr0).target.getRedir();

        return this;
    }

    public RlxBlock getRedir() {
        return getRedir(new HashSet<>());
    }

    public void insertInstruction(int index, VarInstr instr) {
        instrs.add(index, instr);
    }

    public void terminate() {
        isTerminated = true;
        whenTerminated = Thread.currentThread().getStackTrace();
    }
}
