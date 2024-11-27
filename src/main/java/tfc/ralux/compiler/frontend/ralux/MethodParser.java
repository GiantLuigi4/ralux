package tfc.ralux.compiler.frontend.ralux;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import tfc.ralux.compiler.frontend.ralux.parse.RaluxParser;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxEnclosure;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.RlxType;

import java.util.List;

public class MethodParser {
    RlxType type;
    String name;
    RaluxToIR.Params params;
    RlxFunction function;
    Scope currentScope = new Scope();

    public MethodParser(
            List<ParseTree> modifiers,
            RlxType type,
            ParseTree name,
            RaluxToIR.Params params
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
        return forExpr ? currentScope.getCached(name) : null;
    }

    private void parseStatement(
            RlxCls clazz,
            RaluxParser.BodyContext body,
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
            default -> throw new RuntimeException("TODO");
        }
    }

    public void parse(
            RlxCls clazz,
            RaluxParser.BodyContext body
    ) {
        for (int i = 1; i < body.getChildCount() - 1; i++) {
            ParseTree chld = body.getChild(i);
            if (chld instanceof RaluxParser.Statement_listContext) {
                for (int i1 = 0; i1 < chld.getChildCount(); i1++) {
                    ParseTree list = chld.getChild(i1);
                    if (list instanceof RaluxParser.StatementContext) {
                        if (list.getChildCount() == 1) {
                            parseStatement(clazz, body, (RuleContext) list.getChild(0));
                        } else throw new RuntimeException("what?");
                    }
                }
            } else throw new RuntimeException("TODO");
        }
        clazz.addFunction(this.function);
    }
}
