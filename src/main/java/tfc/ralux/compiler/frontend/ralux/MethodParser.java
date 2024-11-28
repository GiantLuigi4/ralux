package tfc.ralux.compiler.frontend.ralux;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import tfc.ralux.compiler.frontend.ralux.parse.RaluxParser;
import tfc.rlxir.RlxBlock;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxEnclosure;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;

import java.util.List;
import java.util.function.Supplier;

public class MethodParser {
    RlxType type;
    String name;
    RaluxToIR.Params params;
    RlxFunction function;
    Scope currentScope = new Scope();
    RaluxToIR raluxToRlx;

    public MethodParser(
            List<ParseTree> modifiers,
            RlxType type,
            ParseTree name,
            RaluxToIR.Params params,
            RaluxToIR raluxToRlx
    ) {
        // TODO: deal with modifiers
        this.type = type;
        this.name = name.getText();
        this.params = params;
        function = new RlxFunction(
                0, true, false,
                new RlxEnclosure(type, this.name, params.toList())
        );
        currentScope.parameterize(this.function, params);
        this.raluxToRlx = raluxToRlx;
    }

    public ValueInstr parseAssign(RaluxParser.AssignmentContext statement, boolean forExpr) {
        if (statement.getChildCount() == 2) {
            ValueInstr value = null;

            RaluxParser.DOperandContext dop;
            String name;
            VarInstr var;
            if (statement.getChild(1) instanceof RaluxParser.DOperandContext d) {
                dop = d;
                name = statement.getChild(0).getText();
                var = currentScope.getVar(name);
                value = currentScope.getCached(name);
            } else {
                dop = (RaluxParser.DOperandContext) statement.getChild(0);
                name = statement.getChild(1).getText();
                var = currentScope.getVar(name);
            }

            switch (dop.getText()) {
                case "++" -> {
                    var.set(function.sum(value, new ConstInstr<>(1, var.type)));
                    currentScope.dirtyVar(name);
                }
                case "--" -> {
                    var.set(function.sub(value, new ConstInstr<>(1, var.type)));
                    currentScope.dirtyVar(name);
                }
                default -> throw new RuntimeException("Unsupported double operand " + dop.getText());
            }

            if (raluxToRlx.debugMode) function.print(currentScope.getCached(name));
            return value == null ? currentScope.getCached(name) : value;
        }

        String name = statement.getChild(0).getText();
        VarInstr var = currentScope.getVar(name);
        ValueInstr val = currentScope.getCached(name);
        String op = statement.getChild(1).getText();
        ValueInstr instr = ExpressionParser.parseValue(this, statement.getChild(2));
        var.set(switch (op) {
            case "=" -> instr;
            case "+=" -> function.sum(val, instr);
            case "-=" -> function.sub(val, instr);
            case "*=" -> function.mul(val, instr);
            case "/=" -> function.div(val, instr);
            default -> throw new RuntimeException("Unsupported assignment operation " + op);
        });
        currentScope.dirtyVar(name);
        if (raluxToRlx.debugMode) function.print(currentScope.getCached(name));
        return forExpr ? currentScope.getCached(name) : null;
    }

    private void parseStatement(
            RlxCls clazz,
            RuleContext statement
    ) {
        switch (statement.getRuleIndex()) {
            case RaluxParser.RULE_ret -> {
                if (statement.getChild(1).getChildCount() == 0) {
                    function.ret();
                } else {
                    ValueInstr instr = ExpressionParser.parseValue(this, statement.getChild(1));
                    function.ret(instr);
                }
            }
            case RaluxParser.RULE_definition -> {
                RlxType type = RaluxToIR.parseType(statement.getChild(0));
                String name = statement.getChild(1).getText();
                VarInstr var = currentScope.makeVar(function, name, type);
                if (statement.getChildCount() > 2) {
                    String op = statement.getChild(2).getText();
                    if (!op.equals("=")) throw new RuntimeException("Variable must be using =.");
                    ValueInstr instr = ExpressionParser.parseValue(this, statement.getChild(3));
                    var.set(instr);
                }
            }
            case RaluxParser.RULE_assignment -> {
                parseAssign((RaluxParser.AssignmentContext) statement, false);
            }
            default -> {
                throw new RuntimeException("TODO");
            }
        }
    }

    private void parseIf(RlxCls clazz, RaluxParser.IfContext ifCtx, RlxBlock termin) {
        ParseTree tree = ifCtx.getChild(2);
        ValueInstr instr = ExpressionParser.parseValue(this, tree);
        ParseTree bdy = ifCtx.getChild(4);
        int threshold = 5;
        if (bdy instanceof RaluxParser.StatementContext) threshold += 1;

        RlxBlock bodyB = function.makeBlock("if_body");
        RlxBlock elseB = ifCtx.getChildCount() > threshold ? function.makeBlock("if_else") : null;
        RlxBlock conclusion = function.makeBlock("conclusion");
        if (elseB == null) elseB = conclusion;

        function.jumpIf(instr, bodyB, elseB);
        function.buildBlock(bodyB);

        if (bdy instanceof RaluxParser.BodyContext body) {
            Scope par = currentScope;
            currentScope = new Scope(currentScope);
            parseBody(clazz, body);
            currentScope = par;

            if (!function.currentBlock().isTerminated())
                function.jump(conclusion);
        } else if (bdy instanceof RaluxParser.StatementContext statementContext) {
            Scope par = currentScope;
            currentScope = new Scope(currentScope);
            parseStatement(clazz, (RuleContext) statementContext.getChild(0));
            currentScope = par;

            if (!function.currentBlock().isTerminated())
                function.jump(conclusion);
        } else throw new RuntimeException("What.");

        function.buildBlock(elseB);
        if (ifCtx.getChildCount() > threshold) {
            ParseTree elseData = ifCtx.getChild(threshold + 1);
            if (elseData instanceof RaluxParser.BodyContext body) {
                Scope par = currentScope;
                currentScope = new Scope(currentScope);
                parseBody(clazz, body);
                currentScope = par;

                if (!function.currentBlock().isTerminated())
                    function.jump(conclusion);
            } else if (elseData instanceof RaluxParser.StatementContext statementContext) {
                Scope par = currentScope;
                currentScope = new Scope(currentScope);
                parseStatement(clazz, (RuleContext) statementContext.getChild(0));
                currentScope = par;

                if (!function.currentBlock().isTerminated())
                    function.jump(conclusion);
            } else if (elseData instanceof RaluxParser.IfContext childIf) {
                parseIf(clazz, childIf, conclusion);

                if (!function.currentBlock().isTerminated())
                    function.jump(conclusion);
            } else throw new RuntimeException("What.");
        }

        function.buildBlock(conclusion);
    }

    private void parseWhile(RlxCls clazz, RaluxParser.WhileContext ctx) {
        RaluxParser.While_headerContext header = (RaluxParser.While_headerContext) ctx.getChild(0);
        RuleContext bdy = (RuleContext) ctx.getChild(1);
        ParseTree tree = header.getChild(2);

        RlxBlock headerB = function.makeBlock("while_header");
        RlxBlock bodyB = function.makeBlock("while_body");
        RlxBlock exitB = function.makeBlock("while_exit");

        function.jump(headerB);
        currentScope.pushCache();
        ValueInstr condition = ExpressionParser.parseValue(this, tree);
        currentScope.popCache();
        function.jumpIf(condition, bodyB, exitB);

        function.buildBlock(bodyB);
        if (bdy instanceof RaluxParser.BodyContext body) {
            Scope par = currentScope;
            currentScope = new Scope(currentScope);
            parseBody(clazz, body);
            currentScope = par;

            if (!function.currentBlock().isTerminated())
                function.jump(headerB);
        } else if (bdy instanceof RaluxParser.StatementContext statement) {
            Scope par = currentScope;
            currentScope = new Scope(currentScope);
            parseStatement(clazz, (RuleContext) statement.getChild(0));
            currentScope = par;

            if (!function.currentBlock().isTerminated())
                function.jump(headerB);
        } else throw new RuntimeException("What.");

        function.buildBlock(exitB);
    }

    private void parseFor(RlxCls clazz, RaluxParser.ForContext ctx) {
        ParseTree configuration = ctx.getChild(2);
        ParseTree bdy = ctx.getChild(4);

        RlxBlock header = function.makeBlock("for_header");
        RlxBlock exit = function.makeBlock("for_exit");
        RlxBlock bodyB = function.makeBlock("for_body");

        Supplier<ValueInstr> createCondition;
        Runnable createLoopRep;
        if (configuration instanceof RaluxParser.Loop_standardContext) {
            parseStatement(clazz, (RuleContext) configuration.getChild(0).getChild(0));

            createCondition = () -> ExpressionParser.parseValue(this, configuration.getChild(2));
            createLoopRep = () -> {
                parseStatement(clazz, (RuleContext) configuration.getChild(4).getChild(0));
            };
        } else throw new RuntimeException("TODO");

        function.jump(header);
        { // build header
            ValueInstr instr = createCondition.get();
            function.jumpIf(instr, bodyB, exit);
        }

        function.buildBlock(bodyB);
        if (bdy instanceof RaluxParser.BodyContext body) {
            Scope par = currentScope;
            currentScope = new Scope(currentScope);
            parseBody(clazz, body);
            createLoopRep.run();
            currentScope = par;

            if (!function.currentBlock().isTerminated())
                function.jump(header);
        } else if (bdy instanceof RaluxParser.StatementContext statement) {
            Scope par = currentScope;
            currentScope = new Scope(currentScope);
            parseStatement(clazz, (RuleContext) statement.getChild(0));
            createLoopRep.run();
            currentScope = par;

            if (!function.currentBlock().isTerminated())
                function.jump(header);
        } else throw new RuntimeException("What.");

        function.buildBlock(exit);
    }

    private void parseFlow(RlxCls clazz, RaluxParser.FlowContext list) {
        ParseTree chld = list.getChild(0);
        if (chld instanceof RaluxParser.IfContext) {
            parseIf(clazz, (RaluxParser.IfContext) chld, null);
            return;
        }
        if (chld instanceof RaluxParser.LoopContext) {
            ParseTree tree = chld.getChild(0);
            if (tree instanceof RaluxParser.WhileContext) {
                parseWhile(clazz, (RaluxParser.WhileContext) tree);
                return;
            }
            if (tree instanceof RaluxParser.ForContext) {
                parseFor(clazz, (RaluxParser.ForContext) tree);
                return;
            }
            throw new RuntimeException("TODO");
        }
        throw new RuntimeException("TODO");
    }

    public void parseBody(
            RlxCls clazz,
            RaluxParser.BodyContext body
    ) {
        function.ensureEntry();
        for (int i = 1; i < body.getChildCount() - 1; i++) {
            ParseTree chld = body.getChild(i);
            if (chld instanceof RaluxParser.Statement_listContext) {
                for (int i1 = 0; i1 < chld.getChildCount(); i1++) {
                    ParseTree list = chld.getChild(i1);
                    if (list instanceof RaluxParser.StatementContext) {
                        if (list.getChildCount() == 1) {
                            parseStatement(clazz, (RuleContext) list.getChild(0));
                        } else throw new RuntimeException("what?");
                    } else if (list instanceof RaluxParser.FlowContext) {
                        parseFlow(clazz, (RaluxParser.FlowContext) list);
                    } else if (!(list instanceof RaluxParser.Semi_truckContext)) {
                        throw new RuntimeException("TODO");
                    }
                }
            } else throw new RuntimeException("TODO");
        }
    }

    VarInstr dirt;

    public VarInstr getDirt() {
        if (dirt != null) return dirt;

        RlxBlock block = function.firstBlock();
        dirt = new VarInstr(RlxTypes.BOOLEAN).setDebugName("dirty_short_circuit_hack");
        block.insertInstruction(0, dirt);
        dirt.setFunction(function);
        return dirt;
    }
}
