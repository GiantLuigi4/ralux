package tfc.ralux.compiler.frontend.ralux;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import tfc.ralux.compiler.frontend.Translator;
import tfc.ralux.compiler.frontend.ralux.parse.RaluxLexer;
import tfc.ralux.compiler.frontend.ralux.parse.RaluxParser;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxModule;
import tfc.rlxir.comphints.FunctionCompilerHint;
import tfc.rlxir.instr.value.vars.VarInstr;
import tfc.rlxir.typing.PrimitiveType;
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;

import java.util.ArrayList;
import java.util.List;

public class RaluxToIR extends Translator {
    boolean debugMode = false;

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
                                    terminal.getSymbol().getType() == RaluxLexer.STATIC
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
        RlxType type;
        ParseTree element = child.getChild(0);
        if (element instanceof RaluxParser.TypeContext typeContext) {
            if (typeContext.getChildCount() == 1) {
                element = typeContext.getChild(0);
                if (element instanceof TerminalNodeImpl terminal) {
                    type = RlxTypes.typeByName(terminal.getText());
                } else {
                    throw new RuntimeException("TODO");
                }
            } else throw new RuntimeException("TODO");
        } else {
            throw new RuntimeException("TODO");
        }

        if (child.getChildCount() == 2) {
            element = child.getChild(1);
            if (element instanceof RaluxParser.ArrayContext) {
                type = RlxType.array(type);
            } else throw new RuntimeException("TODO");
        }

        return type;
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

    List<Runnable> delayedParse = new ArrayList<>();

    private <T> void parseAnnotation(
            RaluxParser.AnnotationContext annotationContext,
            List<T> compHints,
            List<Object> annotations
    ) {
        String asText = annotationContext.getText();
        if (asText.startsWith("[+") && asText.endsWith("+]")) {
            Token from = annotationContext.start;
            Token to = annotationContext.stop;

            asText = from.getInputStream().getText(new Interval(
                    from.getStartIndex(), to.getStopIndex()
            ));
            asText = asText.substring(2, asText.length() - 2).trim();

            CompilerHints.parseCompHint(compHints, asText);
        } else {
            asText = asText.substring(1, asText.length() - 1).trim();
            throw new RuntimeException("TODO");
        }
    }

    private void parseClass(RlxCls clazz, RlxModule module, RaluxParser.C_bodyContext tree) {
        for (int i = 1; i < tree.children.size() - 1; i++) {
            ParseTree element = tree.children.get(i);
            if (element instanceof RaluxParser.C_componentContext component) {
                RuleContext context = (RuleContext) component.children.get(0);
                if (context instanceof RaluxParser.MethodContext methodContext) {
                    List<ParseTree> trees = new ArrayList<>();
                    int index = 0;

                    List<FunctionCompilerHint> compilerHints = new ArrayList<>();
                    List<Object> annotations = new ArrayList<>();
                    while (context.getChild(index) instanceof RaluxParser.AnnotationContext annotationContext) {
                        parseAnnotation(annotationContext, compilerHints, annotations);
                        index++;
                    }

                    index = getNodesOfType(trees, index, context, RaluxLexer.MODIFIER);
                    RlxType type = parseType(context.getChild(index++));
                    ParseTree name = context.getChild(index++);
                    index++; // (
                    Params params = parseParams(context.getChild(index++));
                    index++; // )

                    boolean isStub = false;
                    boolean isAbi = false;
                    for (ParseTree parseTree : trees) {
                        if (
                                parseTree.getText().equals("stub")
                        ) {
                            isStub = true;
                            break;
                        } else if (
                                parseTree.getText().equals("abi")
                        ) {
                            isAbi = true;
                            break;
                        }
                    }

                    MethodParser parser = new MethodParser(
                            module, clazz, trees,
                            type, name,
                            params, this,
                            isStub, isAbi
                    );
                    if (!annotations.isEmpty()) throw new RuntimeException("NYI: annotations");
                    parser.function.addHints(clazz, compilerHints);

                    final boolean finalIsStub = isStub;
                    final boolean finalIsAbi = isAbi;
                    final int finalIndex = index;
                    delayedParse.add(() -> {
                        if (!finalIsStub && !finalIsAbi) {
                            parser.parseBody(
                                    (RaluxParser.BodyContext) context.getChild(finalIndex)
                            );
                        } else if (finalIsAbi) {
                            parser.makeAbi();
                        } else {
                            // though this should be a field
                            parser.makeStub();
                        }
                    });
                    clazz.addFunction(parser.function);
                }
            } else throw new RuntimeException("huh?");
        }
    }

    private String parseUse(RaluxParser.HeaderContext context) {
        if (context.getChildCount() > 3) throw new RuntimeException("TODO");
        // TODO: more specific stuff?
        return context.getChild(1).getText();
    }

    private void accept(RlxModule module, RaluxParser.FileContext tree) {
        String pkg = null;
        List<String> using = new ArrayList<>();
        for (ParseTree child : tree.children) {
            if (child instanceof RaluxParser.HeaderContext context) {
                if (context.getChild(0).getText().equals("pkg")) {
                    pkg = parsePackage(context);
                } else {
                    using.add(parseUse(context));
                }
            } else if (child instanceof RaluxParser.ClassContext context) {
                List<ParseTree> trees = new ArrayList<>();
                int index = 0;
                index = getNodesOfType(trees, index, context, RaluxLexer.MODIFIER);
                ParseTree type = ((RaluxParser.ClassContext) child).children.get(index++);
                ParseTree name = ((RaluxParser.ClassContext) child).children.get(index++);

                RlxCls cls = new RlxCls(
                        pkg, name.getText()
                );
                cls.addUsings(using);
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

        public void makeInstance(RlxCls cls) {
            types.add(0, cls.getType());
            names.add(0, "this");
        }

        public List<RlxType> toList() {
            return types;
        }
    }

    @Override
    public void prepare() {
        for (Runnable runnable : delayedParse) {
            runnable.run();
        }
    }

    public RlxType resolveClass(RlxModule module, RlxCls owner, ParseTree child, Scope scope) {
        String pkg = owner.pkg;
        String text = child.getText().toString();
        if (text.contains(".")) {
            // TODO: what about var access chains?
            RlxCls clz = module.getClass(text);
            if (clz != null) return clz.getType();
        } else {
            VarInstr instr = scope.getVar(text);
            if (instr != null) {
                RlxType type = instr.valueType();
                return type;
            }

            RlxCls clz;

            clz = module.resolveImport(owner, text);
            if (clz != null) return clz.getType();

            clz = module.getClass(pkg + "." + text);
            if (clz != null) return clz.getType();

            // TODO: resolve from wildcard imports

            clz = module.getClass(text);
            if (clz != null) return clz.getType();
        }
        throw new RuntimeException("TODO");
    }
}
