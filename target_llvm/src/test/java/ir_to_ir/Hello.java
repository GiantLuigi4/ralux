package ir_to_ir;

import tfc.ralux.compiler.backend.Backend;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.RLXToLLVM;
import tfc.rlxir.*;
import tfc.rlxir.instr.base.ValueInstr;
import tfc.rlxir.instr.global.ConstInstr;
import tfc.rlxir.typing.RlxTypes;

public class Hello {
    public static void main(String[] args) {
        Backend backend = new RLXToLLVM();

        RlxModule module = new RlxModule("module");
        RlxCls cls = new RlxCls(null, "TestClass");
        module.addClass(cls);
        RlxFunction function = new RlxFunction(
                2, true, false,
                new RlxEnclosure(RlxTypes.INT, "main", RlxTypes.EMPTY_LIST)
        ).exportName("main");
        cls.addFunction(function);
	    
	    char[] chrs = "Hello\n".toCharArray();
	    
	    // Constants for characters
	    ConstInstr<Integer> CNST_0 = new ConstInstr<>(0, RlxTypes.INT);
	    ConstInstr<Integer> CNST_LEN = new ConstInstr<>(chrs.length + 1, RlxTypes.INT);
	    ValueInstr helloArray = function.array(CNST_LEN, RlxTypes.BYTE);
		
	    for (int i = 0; i < chrs.length; i++) {
		    ConstInstr<Integer> CNST = new ConstInstr<>(i, RlxTypes.INT);
		    ConstInstr<Byte> C_H = new ConstInstr<>((byte) chrs[i], RlxTypes.BYTE);
		    function.arraySet(helloArray, CNST, C_H);
	    }
	    
		int i = chrs.length;
	    ConstInstr<Integer> CNST = new ConstInstr<>(i, RlxTypes.INT);
	    ConstInstr<Byte> C_H = new ConstInstr<>((byte) 0, RlxTypes.BYTE);
	    function.arraySet(helloArray, CNST, C_H);

        // Print the string
        function.print(helloArray);

        // Return 0
        function.ret(CNST_0);

        // Compile and write out
        module.withRuntime();
        System.out.println(module.asText());

        Compiler compiler = backend.compilerFor(module);
        compiler.verbose();
        compiler.stub();
        compiler.compile();
        compiler.optimize(3, 4, true);
        compiler.write();
    }
}