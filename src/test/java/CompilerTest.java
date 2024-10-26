import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMMemoryBufferRef;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import tfc.ralux.compiler.backend.llvm.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.helper.STDLib;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.FunctionType;
import tfc.ralux.compiler.backend.llvm.target.CPU;
import tfc.ralux.compiler.backend.llvm.target.Target;
import tfc.ralux.compiler.backend.llvm.target.part.Architecture;
import tfc.ralux.compiler.backend.llvm.target.part.Environment;
import tfc.ralux.compiler.backend.llvm.target.part.OperatingSystem;
import tfc.ralux.compiler.backend.llvm.target.part.Vendor;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

import static org.bytedeco.llvm.global.LLVM.*;

public class CompilerTest {
    public static void main(String[] args) {
        LLVMInitializeNativeTarget();
        LLVMInitializeNativeAsmPrinter();
        LLVMInitializeAllTargets();

        BuilderRoot root = new BuilderRoot("module");
        STDLib lib = new STDLib(root);

        int bitCount = 32;
//        int bitCount = 32;

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

//        LLVMPassManagerRef pm = LLVMCreatePassManager();
//        LLVMRunPassManager(pm, module);

        root.toTargetMachine(
                new Target(
                        Architecture.X86_64,
                        Vendor.APPLE,
                        OperatingSystem.WINDOWS,
                        Environment.NEWLIB
                ),
                CPU.GENERIC
        );
        root.dump();

        root.validate();

        root.writeToFile(new File("module.obj").getAbsolutePath());
        // lld-link module.obj -entry:main
        // lld-link module.obj -entry:main /libpath:"C:/Program Files (x86)/Windows Kits/10/Lib/10.0.22621.0/ucrt/x64" ucrt.lib
    }
}
