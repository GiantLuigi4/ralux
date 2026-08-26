package ir_to_ir;

import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.RLXToLLVM;
import tfc.ralux.compiler.frontend.Translator;
import tfc.ralux.compiler.frontend.ralux.RaluxToIR;
import tfc.rlxir.RlxModule;
import tfc.rlxir.writer.IRWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
//        module.withDebugUtils();

        try {
            parse(translator, module, "std/tfc/ralux/runtime/Object.rlx");
            parse(translator, module, "std/tfc/ralux/runtime/ArrayObj.rlx");

//            parse(translator, module, "comptest/TestClass.rlx");
//            parse(translator, module, "comptest/TestClass1.rlx");
//            parse(translator, module, "comptest/CallTest.rlx");
//            parse(translator, module, "comptest/AssortedTests.rlx");
//            parse(translator, module, "comptest/BranchTest.rlx");
//            parse(translator, module, "comptest/ABITest.rlx");
//            parse(translator, module, "comptest/IOViaDebug.rlx");
//            parse(translator, module, "comptest/GCTest.rlx");
//            parse(translator, module, "comptest/GCTest1.rlx");
//            parse(translator, module, "comptest/GCTest2.rlx");
//            parse(translator, module, "comptest/Wides.rlx");
//            parse(translator, module, "comptest/Wide.rlx");
//            parse(translator, module, "comptest/Fields.rlx");
            parse(translator, module, "comptest/ArrayField.rlx");
	        
//	        parse(translator, module, "comptest/Snake.rlx");
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
        translator.prepare(module);
//        module.setMain(module.getClass("comptest.IOViaDebug").getFunctions().get(0));
//        module.setMain(module.getClass("comptest.GCTest").getFunctions().get(0));
//        module.setMain(module.getClass("comptest.GCTest1").getFunctions().get(1));
//        module.setMain(module.getClass("comptest.GCTest2").getFunctions().get(2));
//        module.setMain(module.getClass("comptest.Wides").getFunctions().get(0));
//        module.setMain(module.getClass("comptest.Fields").getFunctions().get(0));
        module.setMain(module.getClass("comptest.ArrayField").getFunctions().get(0));

//	    module.setMain(module.getClass("comptest.Snake").getFunctions().get(0));
//	    module.setMain(module.getClass("comptest.Wide").getFunctions().get(0));

        Backend backend = new RLXToLLVM();
        Compiler compiler = backend.compilerFor(module);
        compiler.verbose();
	    compiler.stub();
	    compiler.compile();
//	    compiler.setupDebug();
	    compiler.prepareMachine();
//	    compiler.optimize(3, 5, true);
//        compiler.optimize(0, 0, false);
        compiler.write();
		
		StringBuilder builder = new StringBuilder();
	    IRWriter.writeModule(builder, module);
		try {
			FileOutputStream fos = new FileOutputStream("module.rlir");
			fos.write(builder.toString().getBytes(StandardCharsets.UTF_8));
			fos.flush();
			fos.close();
		} catch (Throwable ignored) {
		}
    }
}
