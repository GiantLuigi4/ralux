package tfc.ralux.compiler.compiler.analysis;

import tfc.ralux.compiler.backend.llvm.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.compiler.CallCompiler;
import tfc.ralux.compiler.compiler.RaluxFunctionConsumer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.root.enums.ECompOp;
import tfc.ralux.compiler.parse.RaluxParser;

public class Value {
    public final LLVMValueRef llvm;
    RaluxParser.ExprContext expr;

    BuilderRoot root;
    RaluxFunctionConsumer consumer;
    public final Type type;
    Scope currentScope;

    public Value(
            BuilderRoot root, RaluxFunctionConsumer consumer,
            Scope currentScope, RaluxParser.ExprContext expr
    ) {
        this.expr = expr;
        this.root = root;
        this.consumer = consumer;
        this.currentScope = currentScope;

        Value val = compileExpr(expr);
        llvm = val.llvm;
        type = val.type;
    }

    public Value(
            BuilderRoot root, RaluxFunctionConsumer consumer,
            LLVMValueRef valueRef, Type type
    ) {
        this.root = root;
        this.consumer = consumer;
        this.llvm = valueRef;
        this.type = type;
    }

    protected Value compileExpr(RaluxParser.ExprContext context) {
        if (context.getChildCount() != 1) {
            if (context.getChildCount() == 3) {
                return compileOperation(context);
            } else if (context.getChildCount() == 4) {
                RaluxParser.Full_typeContext type = (RaluxParser.Full_typeContext) context.getChild(1);
                RaluxParser.ExprContext expr = (RaluxParser.ExprContext) context.getChild(3);
                Value val = compileExpr(expr);
                Type aType = new Type(root, consumer, type);
                return new Value(
                        root, consumer,
                        aType.cast(root, val), aType
                );
            } else if (context.getChildCount() == 2) {
                if (context.getChild(0).getText().equals("-")) {
                    if (context.getChild(1) instanceof RaluxParser.ExprContext expr) {
                        Value nonNegated = compileExpr(expr);
                        return new Value(
                                root, consumer,
                                nonNegated.type.negate(root, nonNegated.llvm),
                                nonNegated.type
                        );
                    }
                }
                throw new RuntimeException("TODO");
            }
        }
        RuleContext ctx = (RuleContext) context.getChild(0);
        return switch (ctx.getRuleIndex()) {
            case RaluxParser.RULE_fb_expr -> compileFbExpr((RaluxParser.Fb_exprContext) ctx);
            default -> throw new RuntimeException("TODO: " + ctx);
        };
    }

    private Value compileOperation(RaluxParser.ExprContext context) {
        ParseTree operand = context.getChild(1);
        if (operand instanceof RaluxParser.ExprContext expr) {
            return compileExpr(expr);
        }
        Value left = compileExpr((RaluxParser.ExprContext) context.getChild(0));
        Value right = compileExpr((RaluxParser.ExprContext) context.getChild(2));
        Type coercion = left.type.coerce(root, right.type);

        LLVMValueRef val = switch (operand.getText()) {
            case "+" -> coercion.sum(
                    root,
                    coercion.cast(root, left),
                    coercion.cast(root, right)
            );
            case "-" -> coercion.diff(
                    root,
                    coercion.cast(root, left),
                    coercion.cast(root, right)
            );
            case "*" -> coercion.mul(
                    root,
                    coercion.cast(root, left),
                    coercion.cast(root, right)
            );
            case "/" -> coercion.div(
                    root,
                    coercion.cast(root, left),
                    coercion.cast(root, right)
            );
            default -> null;
        };

        if (val == null) {
            switch (operand.getText()) {
                case "<" -> val = coercion.compare(
                        root, ECompOp.LT,
                        coercion.cast(root, left),
                        coercion.cast(root, right)
                );
                case ">" -> val = coercion.compare(
                        root, ECompOp.GT,
                        coercion.cast(root, left),
                        coercion.cast(root, right)
                );
                case "<=" -> val = coercion.compare(
                        root, ECompOp.LE,
                        coercion.cast(root, left),
                        coercion.cast(root, right)
                );
                case ">=" -> val = coercion.compare(
                        root, ECompOp.GE,
                        coercion.cast(root, left),
                        coercion.cast(root, right)
                );
                case "==" -> val = coercion.compare(
                        root, ECompOp.EQ,
                        coercion.cast(root, left),
                        coercion.cast(root, right)
                );
                case "!=" -> val = coercion.compare(
                        root, ECompOp.NE,
                        coercion.cast(root, left),
                        coercion.cast(root, right)
                );

                // TODO: short circuit eval
                // don't eval right if left is wrong
                // this should be done with just a simple branch
                case "&&" -> val = root.and(left.llvm, right.llvm, "and");
                case "||" -> val = root.or(left.llvm, right.llvm, "or");

                default -> throw new RuntimeException("NYI");
            }
            coercion = new Type(
                    root.getIntType(1),
                    false, true, true, true
            );
        }

        return new Value(
                root, consumer,
                val, coercion
        );
    }

    protected Value compileFbExpr(RaluxParser.Fb_exprContext context) {
        if (context.getChildCount() != 1) throw new RuntimeException("TODO");

        ParseTree elem = context.getChild(0);
        if (elem instanceof TerminalNodeImpl terminal) return compileConstant(terminal);
        else {
            return switch (((RuleContext) elem).getRuleIndex()) {
                case RaluxParser.RULE_call ->
                        CallCompiler.compileCall(root, consumer, currentScope, (RaluxParser.CallContext) elem);
                default -> throw new RuntimeException("TODO");
            };
        }
    }

    protected Value compileConstant(TerminalNodeImpl terminal) {
        switch (terminal.symbol.getType()) {
            case RaluxParser.NUMBER -> {
                // TODO: analyze probable type or whatever

                LLVMValueRef llvm = root.integer(
                        Integer.parseInt(terminal.getText()),
                        32
                );
                return new Value(
                        root, consumer,
                        llvm, new Type(root.getIntType(32), true, true, true, false)
                );
            }
            case RaluxParser.WORD -> {
                Variable var = currentScope.getVariable(terminal.getText());
                if (var != null)
                    return var.getValue();
                throw new RuntimeException("TODO");
            }
            case RaluxParser.CONSTANT -> {
                return switch (terminal.getText()) {
                    case "true" -> new Value(
                            root, consumer,
                            root.integer(1, 1), new Type(root.getIntType(1), false, true, true, true)
                    );
                    case "false" -> new Value(
                            root, consumer,
                            root.integer(0, 1), new Type(root.getIntType(1), false, true, true, true)
                    );
                    default -> throw new RuntimeException("TODO");
                };
            }
            default -> throw new RuntimeException("TODO");
        }
    }
}
