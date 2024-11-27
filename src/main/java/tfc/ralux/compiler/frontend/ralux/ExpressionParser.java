package tfc.ralux.compiler.frontend.ralux;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import tfc.ralux.compiler.frontend.ralux.parse.RaluxParser;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.enumeration.CompareOp;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;

public class ExpressionParser {
    private static ValueInstr parseNumber(ParseTree node) {
        String text = node.getText();
        char chr = text.charAt(text.length() - 1);
        if (Character.isLetter(chr)) {
            text = text.substring(0, text.length() - 1);
            return switch (chr) {
                case 'b' -> new ConstInstr<>(Byte.parseByte(text), RlxTypes.BYTE);
                case 's' -> new ConstInstr<>(Short.parseShort(text), RlxTypes.SHORT);
                case 'i' -> new ConstInstr<>(Integer.parseInt(text), RlxTypes.INT);
                case 'l' -> new ConstInstr<>(Long.parseLong(text), RlxTypes.LONG);
                case 'w' -> throw new RuntimeException("TODO");
                case 'h' -> throw new RuntimeException("TODO");
                case 'f' -> new ConstInstr<>(Float.parseFloat(text), RlxTypes.FLOAT);
                case 'd' -> new ConstInstr<>(Double.parseDouble(text), RlxTypes.DOUBLE);
                case 'q' -> throw new RuntimeException("TODO");
                default -> throw new RuntimeException("How exactly did this get flagged as a number?");
            };
        }
        if (text.contains(".")) {
            // TODO: auto float type?
            return new ConstInstr<>(Float.parseFloat(text), RlxTypes.FLOAT);
        }

        try {
            return new ConstInstr<>(Integer.parseInt(text), RlxTypes.INT);
        } catch (Throwable ignored) {
            return new ConstInstr<>(Long.parseLong(text), RlxTypes.LONG);
        }
    }

    private static ValueInstr makeOperator(RlxFunction function, String operand, ValueInstr leftV, ValueInstr rightV) {
        switch (operand) {
            case "+" -> {
                return function.sum(leftV, rightV);
            }
            case "-" -> {
                return function.sub(leftV, rightV);
            }
            case "*" -> {
                return function.mul(leftV, rightV);
            }
            case "/" -> {
                return function.div(leftV, rightV);
            }
            case "<" -> {
                return function.compare(CompareOp.LT, leftV, rightV);
            }
            case ">" -> {
                return function.compare(CompareOp.GT, leftV, rightV);
            }
        }
        throw new RuntimeException("TODO");
    }

    public static ValueInstr parseValue(MethodParser parser, ParseTree exprNode) {
        RuleContext ctx = (RuleContext) exprNode;
        if (((RuleContext) exprNode).getRuleIndex() == RaluxParser.RULE_expr) {
            if (exprNode.getChildCount() == 1) {
                exprNode = exprNode.getChild(0);
                if (((RuleContext) exprNode).getRuleIndex() == RaluxParser.RULE_fb_expr) {
                    ctx = (RuleContext) exprNode;
                } else throw new RuntimeException("wat");
            } else if (exprNode.getChildCount() == 3) {
                if (((RuleContext) exprNode).getRuleIndex() == RaluxParser.RULE_expr) {
                    if (exprNode.getChild(0) instanceof RaluxParser.ExprContext) {
                        ParseTree left = exprNode.getChild(0);
                        ParseTree right = exprNode.getChild(2);
                        ParseTree operator = exprNode.getChild(1);

                        ValueInstr leftV = parseValue(parser, left);
                        ValueInstr rightV = parseValue(parser, right);
                        String operand;
                        if (operator instanceof TerminalNodeImpl) {
                            operand = operator.getText();
                        } else throw new RuntimeException("wat");

                        return makeOperator(parser.function, operand, leftV, rightV);
                    } else {
                        return parseValue(parser, exprNode.getChild(1));
                    }
                }
                throw new RuntimeException("TODO");
            } else if (exprNode.getChildCount() == 4) {
                if (((RuleContext) exprNode).getRuleIndex() == RaluxParser.RULE_expr) {
                    RlxType target = RaluxToIR.parseType(exprNode.getChild(1));
                    ValueInstr instr = parseValue(parser, exprNode.getChild(3));
                    return parser.function.cast(instr, target);
                }
                throw new RuntimeException("TODO");
            } else {
                throw new RuntimeException("TODO");
            }
        }

        if (ctx.getRuleIndex() == RaluxParser.RULE_fb_expr) {
            if (ctx.getChildCount() == 1) {
                ParseTree node = ctx.getChild(0);
                if (node instanceof TerminalNodeImpl terminal) {
                    if (terminal.getSymbol().getType() == RaluxParser.NUMBER) {
                        return parseNumber(node);
                    } else if (terminal.getSymbol().getType() == RaluxParser.WORD) {
                        return parser.currentScope.getCached(terminal.getText());
                    } else if (terminal.getSymbol().getType() == RaluxParser.CONSTANT) {
                        return switch (terminal.getText()) {
                            case "true" -> new ConstInstr<>(1, RlxTypes.BOOLEAN);
                            case "false" -> new ConstInstr<>(0, RlxTypes.BOOLEAN);
                            case "null" -> new ConstInstr<>(0, RlxTypes.VOID_PTR);
                            default -> throw new RuntimeException("Unknown constant: " + terminal.getText());
                        };
                    } else throw new RuntimeException("TODO");
                } else if (node instanceof RaluxParser.AssignmentContext) {
                    return parser.parseAssign((RaluxParser.AssignmentContext) node, true);
                } else throw new RuntimeException("TODO");
            } else throw new RuntimeException("TODO");
        }

        throw new RuntimeException();
    }
}
