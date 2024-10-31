package compiler;

import tfc.ralux.compiler.compiler.Compiler;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.bytedeco.llvm.global.LLVM;
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

public class CompilerInvoker {
    private static final Compiler compiler = new Compiler();

    public static void main(String[] args) {
        LLVM.LLVMInitializeNativeTarget();
        LLVM.LLVMInitializeNativeAsmPrinter();
        LLVM.LLVMInitializeAllTargets();

        final int optLLVM = 1;
        final int optRlx = 0;

        CharStream stream;
        stream = CharStreams.fromString("""
                pkg tfc.test;
                                
                public class TestClass {
                    public static int main() {
                        stretch fv = 2;
                        fv += 2;
                        half i = fv * 10;
                        fv /= 2;
                        fv /= 4;
                        fv *= 100;
                        i += fv;
                        
                        i += test(5, 4);
                        
                        if (i > 90) {
                            i = 0;
                        }
                        
                        if (i > 50 && fv > 5) {
                            print(i);
                        }
                        
                        return i;
                    }
                    
                    public static int print(byte value) {return value;}
                    public static int print(short value) {return value;}
                    public static int print(int value) {return value;}
                    public static int print(long value) {return value;}
                    public static int print(stretch value) {return value;}
                    public static int print(half value) {return value;}
                    public static int print(float value) {return value;}
                    public static int print(double value) {return value;}
                    public static int print(quadruple value) {return value;}
                    
                    public static int recursive(int value) {
                        if (value > 200) return value;
                        return recursive(value + 1) - 1;
                    }
                    
                    public static int test(int lh, int rh) {
                        return lh + rh;
                    }
                }
                """);
        RaluxLexer lexer = new RaluxLexer(stream);
        RaluxParser parser = new RaluxParser(new CommonTokenStream(lexer));

        RaluxParser.FileContext tree = parser.file();
        if (tree.children == null)
            return;

        compiler.accept(tree);
        compiler.buildModule();

        ModuleRoot moduleRoot = compiler.getModule();
        compiler.dump();
        ((BuilderRoot) moduleRoot).validate();
        compiler.optimize(optLLVM, optRlx, true);
        compiler.dump();

        moduleRoot.toTargetMachine(new Target(
                Architecture.X86_64,
                Vendor.APPLE,
                OperatingSystem.WINDOWS,
                Environment.UCLIBC
        ), CPU.GENERIC, optLLVM);
        moduleRoot.writeToFile(new File("module.obj").getAbsolutePath());

        try {
            Process proc = Runtime.getRuntime().exec(
//                    "lld-link module.obj -entry:main /libpath:\"C:/Program Files (x86)/Windows Kits/10/Lib/10.0.22621.0/ucrt/x64\" ucrt.lib /libpath:\"C:\\Program Files\\LLVM\\lib\\clang\\8.0.1\\lib\\windows\" clang_rt.builtins-x86_64.lib -opt:ref -opt:icf -opt:lbr"
                    "lld-link.exe module.obj -entry:main /libpath:\"C:/Program Files (x86)/Windows Kits/10/Lib/10.0.22621.0/ucrt/x64\" ucrt.lib /libpath:\"C:/Program Files/LLVM/lib/clang/8.0.1/lib/windows\" clang_rt.builtins-x86_64.lib -opt:ref -opt:icf -opt:lbr /fixed /cetcompat /release /incremental:no /ltcg /debug:none /subsystem:console"
//                    "lld-link module.obj -entry:main /libpath:\"C:/Program Files (x86)/Windows Kits/10/Lib/10.0.22621.0/ucrt/x64\" ucrt.lib /libpath:\"C:\\Program Files\\LLVM\\lib\\clang\\8.0.1\\lib\\windows\" clang_rt.builtins-x86_64.lib"
            );
            System.out.println(proc.waitFor());
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
    }
}
