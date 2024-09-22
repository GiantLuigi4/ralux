package tfc.ralux.compiler.optim;

import org.antlr.v4.runtime.CommonToken;
import tfc.ralux.compiler.parse.RaluxLexer;
import tfc.ralux.compiler.parse.RaluxParser;
import tfc.ralux.compiler.util.TreeNode;

// a quick, context free optimization pass that doesn't risk changing behavior
//
public class QuickPass extends OptimizationStep {
    // TODO
    private TreeNode optimizeExpr(TreeNode expressionRoot) {
        return expressionRoot;
    }

    @Override
    public void optimize(TreeNode node) {
        // TODO: recursive iterator structure
        for (int i = 0; i < node.size(); i++) {
            TreeNode t = node.get(i);

            CommonToken common = t.getPayload(CommonToken.class);
            if (common != null && common.getType() == RaluxLexer.SEMI) {
                node.remove(i);
                i--;
                continue;
            }

            RaluxParser.ExprContext expression = t.getPayload(RaluxParser.ExprContext.class);
            if (expression != null) {
                node.replace(i, optimizeExpr(t));
            }

            optimize(t);
        }
    }
}
