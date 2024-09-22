package tfc.ralux.compiler.optim;

import tfc.ralux.compiler.util.TreeNode;

public abstract class OptimizationStep {
    public abstract void optimize(TreeNode node);
}
