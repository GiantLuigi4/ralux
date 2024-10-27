package compiler;

import compiler.compiler.Compiler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import tfc.ralux.compiler.parse.RaluxLexer;
import tfc.ralux.compiler.parse.RaluxParser;

public class CompilerInvoker {
    private static final Compiler compiler = new Compiler();

    public static void main(String[] args) {
        CharStream stream;
        stream = CharStreams.fromString("""
                pkg tfc.test;
                
                public class TestClass {
                    public static int main() {
                        int i = 15;
                        i -= 5 / (i + 3) + i * i * i + (5 + 8);
                        
                        int 3a = 3 * i;
                        i += 3a;
                        
                        return i;
                    }
                }
                """);
        RaluxLexer lexer = new RaluxLexer(stream);
        RaluxParser parser = new RaluxParser(new CommonTokenStream(lexer));

        RaluxParser.FileContext tree = parser.file();
        if (tree.children == null)
            return;

        compiler.accept(tree);

        compiler.dump();
        compiler.optimize(3, 4);
        compiler.dump();
    }
}
