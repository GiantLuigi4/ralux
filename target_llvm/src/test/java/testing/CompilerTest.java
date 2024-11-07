package testing;

import org.bytedeco.llvm.LLVM.LLVMPassManagerRef;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import testing.compiler.llvm.BlockBuilder;
import testing.compiler.llvm.helper.STDLib;
import testing.compiler.llvm.root.BuilderRoot;
import testing.compiler.llvm.FunctionBuilder;
import testing.compiler.llvm.FunctionType;
import testing.compiler.llvm.target.CPU;
import testing.compiler.llvm.target.Target;
import testing.compiler.llvm.target.part.Architecture;
import testing.compiler.llvm.target.part.Environment;
import testing.compiler.llvm.target.part.OperatingSystem;
import testing.compiler.llvm.target.part.Vendor;

import java.io.File;

import static org.bytedeco.llvm.global.LLVM.*;

public class CompilerTest {
    public static void main(String[] args) {
        LLVMInitializeNativeTarget();
        LLVMInitializeNativeAsmPrinter();
        LLVMInitializeAllTargets();

        BuilderRoot root = new BuilderRoot("module");
        STDLib lib = new STDLib(root);

//        int bitCount = 16;
        int bitCount = 32;

        FunctionType type = new FunctionType(root, root.getIntType(bitCount))
                .build();
        FunctionBuilder functionBuilder = new FunctionBuilder(root, "main", type);
        BlockBuilder block = functionBuilder.block("entry").enableBuilding();

        LLVMTypeRef intType = root.getIntType(bitCount);

        LLVMValueRef valueRef0 = root.integer(-42, bitCount);
        LLVMValueRef valueRef1 = root.integer(-86, bitCount);
        LLVMValueRef valueRef2 = root.sisum(valueRef0, valueRef1, "sum");
        LLVMValueRef intStr = lib.intToString(intType, valueRef2);
        LLVMValueRef gstr = root.gepString(root.globalString("Hello"));
        lib.print(gstr);
        lib.print(intStr);

        block.ret(valueRef2);

        root.dump();

        LLVMPassManagerRef pm = LLVMCreatePassManager();
        root.hyperAggressiveOptimizer(false, pm);
        LLVMRunPassManager(pm, root.getModule());

        root.toTargetMachine(
                new Target(
                        Architecture.X86_64,
                        Vendor.APPLE,
                        OperatingSystem.WINDOWS,
                        Environment.NEWLIB
                ),
                CPU.GENERIC,
                LLVMCodeGenLevelNone
        );
        root.dump();

        root.validate();

        root.writeToFile(new File("module.obj").getAbsolutePath());
        // lld-link module.obj -entry:main
        // lld-link module.obj -entry:main /libpath:"C:/Program Files (x86)/Windows Kits/10/Lib/10.0.22621.0/ucrt/x64" ucrt.lib
    }
}
