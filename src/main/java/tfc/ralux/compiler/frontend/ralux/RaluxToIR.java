package tfc.ralux.compiler.frontend.ralux;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import tfc.ralux.compiler.frontend.Translator;
import tfc.ralux.compiler.frontend.ralux.parse.RaluxLexer;
import tfc.ralux.compiler.frontend.ralux.parse.RaluxParser;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxModule;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;

import java.util.ArrayList;
import java.util.List;

public class RaluxToIR extends Translator {
    private String parsePackage(RaluxParser.HeaderContext context) {
        System.out.println(context);
        return context.getChild(1).getText();
    }

    private static int getNodesOfType(
            List<ParseTree> result, int index,
            ParseTree node, int type
    ) {
        while (true) {
            if (type == RaluxLexer.MODIFIER) {
                if (node.getChild(index) instanceof TerminalNodeImpl terminal) {
                    if (
                            terminal.getSymbol().getType() == type ||
                                    terminal.getSymbol().getType() == RaluxLexer.STATIC // TODO: more
                    ) {
                        result.add(terminal);
                        index++;
                    } else return index;
                } else return index;
            } else if (node.getChild(index) instanceof TerminalNodeImpl terminal) {
                if (terminal.getSymbol().getType() == type) {
                    result.add(terminal);
                    index++;
                } else return index;
            } else return index;
        }
    }

    public static RlxType parseType(ParseTree child) {
        if (child.getChildCount() == 1) {
            ParseTree element = child.getChild(0);
            if (element instanceof RaluxParser.TypeContext typeContext) {
                if (typeContext.getChildCount() == 1) {
                    element = typeContext.getChild(0);
                    if (element instanceof TerminalNodeImpl terminal) {
                        return RlxTypes.typeByName(terminal.getText());
                    }
                    throw new RuntimeException("TODO");
                }
                throw new RuntimeException("TODO");
            }
            throw new RuntimeException("TODO");
        }
        throw new RuntimeException("TODO");
    }

    private Params parseParams(ParseTree child) {
        if (child.getChildCount() != 0) {
            Params res = new Params();
            for (int i = 0; i < child.getChildCount(); i += 3) {
                res.addParam(
                        child.getChild(i),
                        child.getChild(i + 1)
                );
            }
            return res;
        }
        return new Params();
    }

    private void parseClass(RlxCls clazz, RlxModule module, RaluxParser.C_bodyContext tree) {
        for (int i = 1; i < tree.children.size() - 1; i++) {
            ParseTree element = tree.children.get(i);
            if (element instanceof RaluxParser.C_componentContext component) {
                RuleContext context = (RuleContext) component.children.get(0);
                if (context instanceof RaluxParser.MethodContext methodContext) {
                    List<ParseTree> trees = new ArrayList<>();
                    int index = 0;
                    index = getNodesOfType(trees, index, context, RaluxLexer.MODIFIER);
                    RlxType type = parseType(context.getChild(index++));
                    ParseTree name = context.getChild(index++);
                    index++; // (
                    Params params = parseParams(context.getChild(index++));
                    index++; // )
                    new MethodParser(trees, type, name, params).parse(
                            clazz,
                            (RaluxParser.BodyContext) context.getChild(index)
                    );
                }
            } else throw new RuntimeException("huh?");
        }
    }

    private void accept(RlxModule module, RaluxParser.FileContext tree) {
        String pkg = null;
        for (ParseTree child : tree.children) {
            if (child instanceof RaluxParser.HeaderContext context) {
                pkg = parsePackage(context);
            } else if (child instanceof RaluxParser.ClassContext context) {
                List<ParseTree> trees = new ArrayList<>();
                int index = 0;
                index = getNodesOfType(trees, index, context, RaluxLexer.MODIFIER);
                ParseTree type = ((RaluxParser.ClassContext) child).children.get(index++);
                ParseTree name = ((RaluxParser.ClassContext) child).children.get(index++);

                RlxCls cls = new RlxCls(
                        pkg, name.getText()
                );
                // TODO: add in type of class
                // TODO: add in modifiers
                module.addClass(cls);
                parseClass(cls, module, (RaluxParser.C_bodyContext) ((RaluxParser.ClassContext) child).children.get(index));
            } else {
                System.out.println(tree);
                throw new RuntimeException("TODO");
            }
        }
    }

    @Override
    public void parse(RlxModule module, String file) {
        RaluxLexer lexer = new RaluxLexer(CharStreams.fromString(file));
        RaluxParser parser = new RaluxParser(new CommonTokenStream(lexer));

        RaluxParser.FileContext tree = parser.file();
        if (tree.children == null)
            return;

        accept(module, tree);
    }

    public static class Params {
        List<RlxType> types = new ArrayList<>();
        List<String> names = new ArrayList<>();

        public void addParam(ParseTree type, ParseTree name) {
            types.add(parseType(type));
            names.add(name.getText());
        }

        public List<RlxType> toList() {
            return types;
        }
    }
}
