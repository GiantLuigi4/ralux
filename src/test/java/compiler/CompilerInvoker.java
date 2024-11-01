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
import java.io.InputStream;

public class CompilerInvoker {
    private static final Compiler compiler = new Compiler();

    protected static String testRes(String pth) {
        try {
            InputStream is = CompilerInvoker.class.getClassLoader().getResourceAsStream(pth);
            byte[] data = is.readAllBytes();
            try {
                is.close();
            } catch (Throwable ignored) {
            }
            return new String(data);
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
    }

    static void feedFile(String data) {
        CharStream stream;
        stream = CharStreams.fromString(data);
        RaluxLexer lexer = new RaluxLexer(stream);
        RaluxParser parser = new RaluxParser(new CommonTokenStream(lexer));

        RaluxParser.FileContext tree = parser.file();
        if (tree.children == null)
            return;

        compiler.accept(tree);
    }

    public static void main(String[] args) {
        LLVM.LLVMInitializeNativeTarget();
        LLVM.LLVMInitializeNativeAsmPrinter();
        LLVM.LLVMInitializeAllTargets();

        final int optLLVM = 3;
        final int optRlx = 5;

        feedFile(testRes("comptest/TestClass.rlx"));
        feedFile(testRes("comptest/TestClass1.rlx"));
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

            System.out.println(new String(proc.getInputStream().readAllBytes()));
            System.err.println(new String(proc.getErrorStream().readAllBytes()));
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
    }
}
