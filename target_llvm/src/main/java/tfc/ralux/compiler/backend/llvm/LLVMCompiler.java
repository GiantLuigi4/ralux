package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.RlxModule;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.typing.RlxType;

import java.util.List;

public class LLVMCompiler extends Compiler {
    RlxModule compiling;
    BuilderRoot root;
    LLVMConversions conversions;

    boolean enableVerbose = false;

    public LLVMCompiler(RlxModule module) {
        this.compiling = module;
        root = new BuilderRoot(module.getName());
        conversions = new LLVMConversions(root);
    }

    private void compileFunction(RlxCls aClass, RlxFunction function) {
        FunctionBuilder builder = function.getCompilerData();
        List<RlxInstr> instrs = function.getInstructions();
        new FunctionCompiler(conversions, root, aClass, function, builder, instrs).compile();
    }

    private void compileClass(RlxCls aClass) {
        for (RlxFunction function : aClass.getFunctions()) {
            compileFunction(aClass, function);
        }
    }

    @Override
    public void compile() {
        for (RlxCls aClass : compiling.getClasses()) {
            compileClass(aClass);
        }

        if (enableVerbose) {
            root.dump();
        }

        root.validate();

        if (enableVerbose) {
            root.dump();
        }
    }

    @Override
    public Compiler verbose() {
        enableVerbose = true;
        return this;
    }

    private void stubFunction(RlxCls cls, RlxFunction function) {
        if (enableVerbose) {
            System.out.println("Stubbing function " + function.enclosure + " for class " + cls.qualifiedName());
        }

        RlxType type = function.enclosure.result;
        LLVMTypeRef typeRef = conversions.typeFor(type);
        FunctionType funcType = new FunctionType(root, typeRef);

        for (RlxType rlxType : function.enclosure.descr) {
            funcType.withArgs(conversions.typeFor(rlxType));
        }

        function.setCompilerData(root.function(
                cls.qualifiedName() + "#" + function.enclosure.name,
                funcType.build()
        ));
    }

    private void stubClass(RlxCls cls) {
        if (enableVerbose) {
            System.out.println("Stubbing class " + cls.qualifiedName());
        }

        // TODO: should stub to a struct
        for (RlxFunction function : cls.getFunctions()) {
            stubFunction(cls, function);
        }
    }

    @Override
    public void stub() {
        for (RlxCls aClass : compiling.getClasses()) {
            stubClass(aClass);
        }
    }
}
