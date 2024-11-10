package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import tfc.ralux.compiler.backend.Compiler;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;
import tfc.ralux.compiler.backend.llvm.util.helper.target.CPU;
import tfc.ralux.compiler.backend.llvm.util.helper.target.Target;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.Architecture;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.Environment;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.OperatingSystem;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.Vendor;
import tfc.rlxir.RlxBlock;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.RlxModule;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.typing.RlxType;

import java.io.File;
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
        List<RlxBlock> blocks = function.getBlocks();
        new FunctionCompiler(conversions, root, aClass, function, builder, blocks).compile();
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

        String exportName = function.getExportName();
        if (exportName == null) exportName = cls.qualifiedName() + "#" + function.enclosure.name;
        function.setCompilerData(root.function(
                exportName,
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

    @Override
    public void write() {
        root.toTargetMachine(
                new Target(
                        Architecture.X86_64,
                        Vendor.APPLE,
                        OperatingSystem.WINDOWS,
                        Environment.UCLIBC
                ),
                CPU.GENERIC,
                3
        );
        root.validate();
        root.writeToFile(new File(compiling.getName() + ".obj").getAbsolutePath());
        try {
            Process proc = Runtime.getRuntime().exec(
                    "lld-link.exe module.obj -entry:main " +
                            "/libpath:\"C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.37.32822/lib/x64\" msvcrt.lib legacy_stdio_definitions.lib " +
                            "/libpath:\"C:/Program Files (x86)/Windows Kits/10/Lib/10.0.22621.0/ucrt/x64\" ucrt.lib " +
                            "/libpath:\"C:/Program Files/LLVM/lib/clang/8.0.1/lib/windows\" clang_rt.builtins-x86_64.lib " +
                            "/defaultlib:msvcrt /defaultlib:ucrt /subsystem:console /verbose"
//                            "-opt:ref -opt:icf -opt:lbr " +
//                            "/fixed /cetcompat /release /incremental:no /ltcg /debug:none /subsystem:console"
            );
            System.out.println(proc.waitFor());

            System.out.println(new String(proc.getInputStream().readAllBytes()));
            System.err.println(new String(proc.getErrorStream().readAllBytes()));
        } catch (Throwable err) {
            throw new RuntimeException(err);
        }
    }
}
