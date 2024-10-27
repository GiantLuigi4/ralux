package compiler;

import compiler.compiler.Compiler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.root.ModuleRoot;
import tfc.ralux.compiler.backend.llvm.target.CPU;
import tfc.ralux.compiler.backend.llvm.target.Target;
import tfc.ralux.compiler.backend.llvm.target.part.Architecture;
import tfc.ralux.compiler.backend.llvm.target.part.Environment;
import tfc.ralux.compiler.backend.llvm.target.part.OperatingSystem;
import tfc.ralux.compiler.backend.llvm.target.part.Vendor;
import tfc.ralux.compiler.parse.RaluxLexer;
import tfc.ralux.compiler.parse.RaluxParser;

import java.io.File;

import static org.bytedeco.llvm.global.LLVM.*;

public class CompilerInvoker {
    private static final Compiler compiler = new Compiler();

    public static void main(String[] args) {
        LLVMInitializeNativeTarget();
        LLVMInitializeNativeAsmPrinter();
        LLVMInitializeAllTargets();

        CharStream stream;
        stream = CharStreams.fromString("""
                pkg tfc.test;
                
                public class TestClass {
                    public static int main() {
                        quadruple fv = 2;
                        fv += 2;
                        half i = fv * 10;
                        fv /= 2;
                        fv /= 4;
                        fv *= 100;
                        i += fv;
                        
                        int asInt = i;
                        return asInt;
                    }
                }
                """);
        RaluxLexer lexer = new RaluxLexer(stream);
        RaluxParser parser = new RaluxParser(new CommonTokenStream(lexer));

        RaluxParser.FileContext tree = parser.file();
        if (tree.children == null)
            return;

        compiler.accept(tree);

        ModuleRoot moduleRoot = compiler.getModule();
        compiler.dump();
        ((BuilderRoot) moduleRoot).validate();
        compiler.optimize(3, 4);
        compiler.dump();

        moduleRoot.toTargetMachine(new Target(
                Architecture.X86_64,
                Vendor.APPLE,
                OperatingSystem.WINDOWS,
                Environment.NEWLIB
        ), CPU.GENERIC);
        moduleRoot.writeToFile(new File("module.obj").getAbsolutePath());
    }
}
