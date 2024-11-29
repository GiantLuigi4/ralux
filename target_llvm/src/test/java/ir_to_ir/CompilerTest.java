package ir_to_ir;

import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.RLXToLLVM;
import tfc.ralux.compiler.frontend.Translator;
import tfc.ralux.compiler.frontend.ralux.RaluxToIR;
import tfc.rlxir.RlxModule;

public class CompilerTest {
    public static void main(String[] args) {
        Translator translator = new RaluxToIR();

        RlxModule module = new RlxModule("module");
        try {
            translator.parse(module, new String(CompilerTest.class.getClassLoader().getResourceAsStream("comptest/TestClass.rlx").readAllBytes()));
            translator.parse(module, new String(CompilerTest.class.getClassLoader().getResourceAsStream("comptest/TestClass1.rlx").readAllBytes()));
            translator.parse(module, new String(CompilerTest.class.getClassLoader().getResourceAsStream("comptest/CallTest.rlx").readAllBytes()));
            translator.parse(module, new String(CompilerTest.class.getClassLoader().getResourceAsStream("comptest/AssortedTests.rlx").readAllBytes()));
            translator.parse(module, new String(CompilerTest.class.getClassLoader().getResourceAsStream("comptest/BranchTest.rlx").readAllBytes()));
            translator.parse(module, new String(CompilerTest.class.getClassLoader().getResourceAsStream("comptest/ABITest.rlx").readAllBytes()));
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
        translator.prepare();

        Backend backend = new RLXToLLVM();
        Compiler compiler = backend.compilerFor(module);
        compiler.verbose();
        compiler.stub();
        compiler.compile();
        compiler.optimize(3, 4, false);
        compiler.write();
    }
}
