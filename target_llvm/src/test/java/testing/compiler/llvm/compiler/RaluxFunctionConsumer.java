package testing.compiler.llvm.compiler;

import testing.compiler.llvm.compiler.analysis.Type;
import testing.compiler.llvm.compiler.analysis.Value;
import testing.compiler.llvm.compiler.analysis.Scope;
import testing.compiler.llvm.compiler.analysis.Variable;
import org.antlr.v4.runtime.RuleContext;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import testing.compiler.llvm.BlockBuilder;
import testing.compiler.llvm.FunctionBuilder;
import testing.compiler.llvm.root.BuilderRoot;
import tfc.ralux.compiler.frontend.ralux.parse.RaluxParser;

import java.util.Stack;

public class RaluxFunctionConsumer {
    FunctionBuilder direct;
    BuilderRoot root;
    Compiler compiler;

    Stack<Scope> scopes = new Stack<>();
    Scope currentScope;
    Type type;
    BlockBuilder rootBuilder;
    private Stack<BlockBuilder> continueTo = new Stack<>();
    private Stack<BlockBuilder> breakTo = new Stack<>();

    LLVMValueRef dirtRef = null;

    public RaluxFunctionConsumer(BuilderRoot root, FunctionBuilder direct, Compiler compiler, Type type) {
        this.root = root;
        this.direct = direct;
        this.compiler = compiler;
        currentScope = new Scope(root, direct, null);
        scopes.push(currentScope);
        (rootBuilder = direct.block("entry")).enableBuilding();
        this.type = type;
    }

    public LLVMValueRef getDirtRef() {
        if (dirtRef != null)
            return dirtRef;
        BlockBuilder current = root.getBlockBuilding();
        LLVM.LLVMPositionBuilderBefore(root.getBuilder(), LLVM.LLVMGetFirstInstruction(rootBuilder.getDirect()));
        dirtRef = root.allocA(root.getIntType(1), "dirt");
        current.enableBuilding();
        return dirtRef;
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
        if (node.getChildCount() == 3) {
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
        } else if (node.getChildCount() == 2) {
            RaluxParser.DOperandContext operand = (RaluxParser.DOperandContext) node.getChild(1);
            Variable var = currentScope.getVariable(varName);
            Value val = new Value(
                    root, this,
                    root.integer(1, var.getType().numberSize(root)), var.getType()
            );
            switch (operand.getText()) {
                case "++" -> {
                    val = new Value(
                            root, this,
                            var.getType().eqSum(root, var.getValue().llvm, val),
                            var.getType()
                    );
                }
                case "--" -> {
                    val = new Value(
                            root, this,
                            var.getType().eqDiff(root, var.getValue().llvm, val),
                            var.getType()
                    );
                }
                default -> throw new RuntimeException("Unsupported operand: " + operand.getText());
            }
            var.setValue(currentScope, val);
        } else {
            throw new RuntimeException("what.");
        }
    }

    private void acceptSpecialFlow(RaluxParser.SpecialContext node) {
        System.out.println(node);
        if (node.getChildCount() != 2) throw new RuntimeException("NYI");

        switch (node.getChild(0).getText()) {
            case "break" -> root.getBlockBuilding().jump(breakTo.peek());
            case "continue" -> root.getBlockBuilding().jump(continueTo.peek());
            default -> throw new RuntimeException("what.");
        }
    }

    protected void acceptStatement(RuleContext node) {
        switch (node.getRuleIndex()) {
            case RaluxParser.RULE_semi_truck -> {
                return;
            }
            case RaluxParser.RULE_statement, RaluxParser.RULE_flow -> node = (RuleContext) node.getChild(0);
            default -> throw new RuntimeException("Unexpected rule: " + node);
        }

        switch (node.getRuleIndex()) {
            case RaluxParser.RULE_definition -> acceptDefine((RaluxParser.DefinitionContext) node);
            case RaluxParser.RULE_assignment -> acceptAssign((RaluxParser.AssignmentContext) node);
            case RaluxParser.RULE_ret -> acceptReturn((RaluxParser.RetContext) node);
            case RaluxParser.RULE_call ->
                    CallCompiler.compileCall(root, this, currentScope, (RaluxParser.CallContext) node);
            case RaluxParser.RULE_if -> acceptIf((RaluxParser.IfContext) node);
            case RaluxParser.RULE_loop -> acceptLoop((RaluxParser.LoopContext) node);
            case RaluxParser.RULE_special -> acceptSpecialFlow((RaluxParser.SpecialContext) node);
            default -> throw new RuntimeException("Unexpected rule: " + node);
        }
    }

    private void acceptFor(RaluxParser.ForContext child) {
        if (child.getChildCount() > 5) {
            if (!(child.getChild(6) instanceof RaluxParser.Semi_truckContext))
                throw new RuntimeException("NYI");
        }

        RaluxParser.Loop_standardContext statements = (RaluxParser.Loop_standardContext) child.getChild(2);

//        Value cond = new Value(root, this, currentScope, condition);
        pushScope();
        acceptRule((RuleContext) statements.getChild(0));

        BlockBuilder building = root.getBlockBuilding();
        BlockBuilder head = direct.block("head");
        BlockBuilder bodyBlock = direct.block("body");
        BlockBuilder tail = direct.block("tail");
        BlockBuilder conclusion = direct.block("conclusion");
        building.jump(head);

        continueTo.push(tail);
        breakTo.push(conclusion);
        tail.enableBuilding();
        acceptRule((RuleContext) statements.getChild(4));
        autoJump(head);

        head.enableBuilding();
        RaluxParser.ExprContext condition = (RaluxParser.ExprContext) statements.getChild(2);
        Value condVal = new Value(root, this, currentScope, condition);
        head.conditionalJump(condVal.llvm, bodyBlock, conclusion);

        bodyBlock.enableBuilding();
        acceptBlock((RaluxParser.BodyContext) child.getChild(4));
        popScope();
        autoJump(tail);

        breakTo.pop();
        continueTo.pop();

        conclusion.enableBuilding();
    }

    private void autoJump(BlockBuilder head) {
        BlockBuilder cBuilding = root.getBlockBuilding();
        if (!cBuilding.isTerminated())
            cBuilding.jump(head);
    }

    private void acceptLoop(RaluxParser.LoopContext node) {
        if (node.getChildCount() == 1) {
            RuleContext child = ((RuleContext) node.getChild(0));
            switch (child.getRuleIndex()) {
                case RaluxParser.RULE_for -> acceptFor((RaluxParser.ForContext) child);
                default -> throw new RuntimeException("NYI");
            }
            return;
        }
        throw new RuntimeException("NYI");
    }

    public void acceptBlock(RaluxParser.BodyContext body) {
        RaluxParser.Statement_listContext list = (RaluxParser.Statement_listContext) body.getChild(1);
        for (int i = 0; i < list.getChildCount(); i++) {
            acceptStatement((RuleContext) list.getChild(i));
        }
    }

    private void acceptIf(RaluxParser.IfContext child) {
        BlockBuilder block = direct.block("tree_exit");
        acceptIf(child, block);
        block.enableBuilding();
    }

    private void acceptIf(RaluxParser.IfContext child, BlockBuilder exit) {
        RaluxParser.ExprContext condition = (RaluxParser.ExprContext) child.getChild(2);
        RuleContext body = (RuleContext) child.getChild(4);

        Value value = new Value(root, this, currentScope, condition);

        BlockBuilder cond_false = direct.block("condition_false");
        BlockBuilder cond_true = direct.block("condition_true");

        root.getBlockBuilding().conditionalJump(value.llvm, cond_true, cond_false);
        cond_true.enableBuilding();
        pushScope();
        acceptRule(body);
        popScope();
        autoJump(exit);

        cond_false.enableBuilding();
        // TODO: else handling
        if (child.getChildCount() > 5) {
            if (child.getChild(5) instanceof RuleContext ctx) {
                switch (ctx.getRuleIndex()) {
                    case RaluxParser.RULE_semi_truck -> {
                        if (child.getChildCount() > 6)
                            throw new RuntimeException("NYI");
                    }
                    default -> throw new RuntimeException("NYI");
                }
            } else throw new RuntimeException("NYI");
        }
        cond_false.jump(exit);
    }

    private void acceptRule(RuleContext body) {
        switch (body.getRuleIndex()) {
            case RaluxParser.RULE_flow, RaluxParser.RULE_statement -> acceptStatement(body);
            case RaluxParser.RULE_body -> acceptBlock((RaluxParser.BodyContext) body);
            default -> throw new RuntimeException("Unexpected rule: " + body);
        }
    }

    private void pushScope() {
        currentScope = new Scope(
                root, direct,
                currentScope
        );
        scopes.push(currentScope);
    }

    private void popScope() {
        scopes.pop();
        currentScope = scopes.peek();
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

//        if (!val.type.canAutoCast(type)) { // TODO: need to get this method working at some point
        if (type.isVoid()) {
            throw new RuntimeException("Cannot auto cast from " + val.type + " to " + type + " for return.");
        }
        LLVMValueRef casted = type.cast(root, val);

        root.stdLib.print(
                root.stdLib.intToString(type.llvm(), casted)
        );
        root.getBlockBuilding().ret(casted);
    }

    int pCount = 0;

    public void addParam(String varName, Type type, String name) {
        Variable variable = currentScope.defineVariable(varName, type);
        LLVMValueRef lowLevelVirtualMachineParameterValueReferenceWrappedUsingAJavaObjectWhichHoldsALongWhichRepresentsTheMemoryAddressOfTheObject;
        variable.setValue(currentScope, new Value(
                root, this,
                root.track(lowLevelVirtualMachineParameterValueReferenceWrappedUsingAJavaObjectWhichHoldsALongWhichRepresentsTheMemoryAddressOfTheObject = LLVM.LLVMGetParam(
                        direct.getDirect(), pCount++
                )), type
        ));
        LLVM.LLVMSetValueName(lowLevelVirtualMachineParameterValueReferenceWrappedUsingAJavaObjectWhichHoldsALongWhichRepresentsTheMemoryAddressOfTheObject, name);
    }

    public FunctionBuilder getDirect() {
        return direct;
    }
}
