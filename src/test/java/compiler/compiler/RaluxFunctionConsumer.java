package compiler.compiler;

import compiler.compiler.analysis.Scope;
import compiler.compiler.analysis.Type;
import compiler.compiler.analysis.Value;
import compiler.compiler.analysis.Variable;
import org.antlr.v4.runtime.RuleContext;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.helper.STDLib;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.parse.RaluxParser;

import java.util.Stack;

public class RaluxFunctionConsumer {
    FunctionBuilder direct;
    BuilderRoot root;
    Compiler compiler;

    Stack<Scope> scopes = new Stack<>();
    Scope currentScope;
    Type type;
    BlockBuilder rootBuilder;

    public RaluxFunctionConsumer(BuilderRoot root, FunctionBuilder direct, Compiler compiler, Type type) {
        this.root = root;
        this.direct = direct;
        this.compiler = compiler;
        currentScope = new Scope(root, direct, null);
        scopes.push(currentScope);
        (rootBuilder = direct.block("entry")).enableBuilding();
        this.type = type;
    }

    public void buildRoot() {
        rootBuilder.enableBuilding();
    }

    private void acceptDefine(RaluxParser.DefinitionContext node) {
        RaluxParser.Full_typeContext type = (RaluxParser.Full_typeContext) node.getChild(0);
        String name = node.getChild(1).getText();
        Variable var = currentScope.defineVariable(name, new Type(root, this, type));
        if (node.getChildCount() > 2) {
            String op = node.getChild(2).getText();
            if (!op.equals("=")) throw new RuntimeException("Variables can only be declared with an = assignment.");
            RaluxParser.ExprContext expr = (RaluxParser.ExprContext) node.getChild(3);
            Value value = new Value(root, this, currentScope, expr);
            var.setValue(currentScope, value);
        }
    }

    private void acceptAssign(RaluxParser.AssignmentContext node) {
        System.out.println(node);
        String varName = node.getChild(0).getText();
        if (node.getChildCount() > 1) {
            RaluxParser.OperandContext operand = (RaluxParser.OperandContext) node.getChild(1);
            RaluxParser.ExprContext value = (RaluxParser.ExprContext) node.getChild(2);
            Value val = new Value(root, this, currentScope, value);
            Variable var = currentScope.getVariable(varName);
            switch (operand.getText()) {
                case "=" -> {/* no-op */}
                case "+=" -> val = new Value(
                        root, this,
                        var.getType().eqSum(root, var.getValue().llvm, val),
                        var.getType()
                );
                case "-=" -> val = new Value(
                        root, this,
                        var.getType().eqDiff(root, var.getValue().llvm, val),
                        var.getType()
                );
                case "*=" -> val = new Value(
                        root, this,
                        var.getType().eqMul(root, var.getValue().llvm, val),
                        var.getType()
                );
                case "/=" -> val = new Value(
                        root, this,
                        var.getType().eqDiv(root, var.getValue().llvm, val),
                        var.getType()
                );
                default -> throw new RuntimeException("Unsupported operand: " + operand.getText());
            }
            var.setValue(currentScope, val);
        } else {
            throw new RuntimeException("what.");
        }
    }

    public void acceptBlock(RaluxParser.BodyContext body) {
        RaluxParser.Statement_listContext list = (RaluxParser.Statement_listContext) body.getChild(1);
        for (int i = 0; i < list.getChildCount(); i++) {
            RuleContext node = (RuleContext) list.getChild(i);
            switch (node.getRuleIndex()) {
                case RaluxParser.RULE_semi_truck -> {
                    continue;
                }
                case RaluxParser.RULE_statement -> node = (RuleContext) node.getChild(0);
                default -> throw new RuntimeException("Unexpected rule: " + node);
            }

            switch (node.getRuleIndex()) {
                case RaluxParser.RULE_definition -> acceptDefine((RaluxParser.DefinitionContext) node);
                case RaluxParser.RULE_assignment -> acceptAssign((RaluxParser.AssignmentContext) node);
                case RaluxParser.RULE_ret -> acceptReturn((RaluxParser.RetContext) node);
                default -> throw new RuntimeException("Unexpected rule: " + node);
            }
        }
    }

    private void acceptReturn(RaluxParser.RetContext node) {
        if (node.getChildCount() == 1) {
            // void return
            root.getBlockBuilding().ret();
        }

        RaluxParser.ExprContext expr = (RaluxParser.ExprContext) node.getChild(1);
        Value val = new Value(
                root, this,
                currentScope, expr
        );

        LLVMValueRef casted = type.cast(root, val);

        // TODO: auto cast to function return type
        root.stdLib.print(
                root.stdLib.intToString(type.llvm(), casted)
        );
        root.getBlockBuilding().ret(casted);
    }

    int pCount = 0;

    public void addParam(String varName, Type type) {
        Variable variable = currentScope.defineVariable(varName, type);
        variable.setValue(currentScope, new Value(
                root, this,
                root.track(LLVM.LLVMGetParam(
                        direct.getDirect(), pCount++
                )), type
        ));
    }
}
