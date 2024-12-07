package ir_to_ir;

import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.RLXToLLVM;
import tfc.ralux.compiler.frontend.Translator;
import tfc.ralux.compiler.frontend.ralux.RaluxToIR;
import tfc.rlxir.RlxModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompilerTest {
    static void parse(Translator translator, RlxModule module, String dir) throws IOException {
        try {
            translator.parse(module, new String(new FileInputStream(dir).readAllBytes()), dir);
        } catch (Throwable err) {
            translator.parse(module, new String(CompilerTest.class.getClassLoader().getResourceAsStream(dir).readAllBytes()), dir);
        }
    }

    public static void main(String[] args) {
        Translator translator = new RaluxToIR();

        RlxModule module = new RlxModule("module");
        module.withDebugUtils().withRuntime();

        try {
            parse(translator, module, "std/tfc/ralux/runtime/Object.rlx");

//            parse(translator, module, "comptest/TestClass.rlx");
//            parse(translator, module, "comptest/TestClass1.rlx");
//            parse(translator, module, "comptest/CallTest.rlx");
//            parse(translator, module, "comptest/AssortedTests.rlx");
//            parse(translator, module, "comptest/BranchTest.rlx");
//            parse(translator, module, "comptest/ABITest.rlx");
//            parse(translator, module, "comptest/IOViaDebug.rlx");
            parse(translator, module, "comptest/ObjectOrientation.rlx");
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
        translator.prepare(module);
//        module.setMain(module.getClass("comptest.IOViaDebug").getFunctions().get(0));
        module.setMain(module.getClass("comptest.ObjectOrientation").getFunctions().get(0));

        Backend backend = new RLXToLLVM();
        Compiler compiler = backend.compilerFor(module);
        compiler.verbose();
        compiler.stub();
        compiler.compile();
        compiler.optimize(3, 5, true);
//        compiler.optimize(0, 0, false);
        compiler.write();
    }
}
