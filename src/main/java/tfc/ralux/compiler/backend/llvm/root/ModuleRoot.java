package tfc.ralux.compiler.backend.llvm.root;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.llvm.LLVM.*;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.helper.Util;
import tfc.ralux.compiler.backend.llvm.target.CPU;
import tfc.ralux.compiler.backend.llvm.target.Target;

import static org.bytedeco.llvm.global.LLVM.*;

public class ModuleRoot extends ContextRoot {
    protected LLVMModuleRef module;

    public ModuleRoot(String moduleName) {
        module = LLVMModuleCreateWithNameInContext(moduleName, context);
    }

    public LLVMModuleRef getModule() {
        return module;
    }

    public void dump() {
        LLVM.LLVMDumpModule(module);
    }

    public BytePointer dumpToMem() {
        return LLVMPrintModuleToString(module);
    }

    public LLVMMemoryBufferRef compileModule() {
        return LLVM.LLVMWriteBitcodeToMemoryBuffer(module);
    }

    public LLVMMemoryBufferRef writeToMemory() {
        // TODO: configurability?
        // TODO: why does this not work?
        LLVMMemoryBufferRef ref = new LLVMMemoryBufferRef();
        if (LLVMTargetMachineEmitToMemoryBuffer(
                targetMachineRef,
                module,
                LLVMObjectFile,
                error, ref
        ) != 0) {
            System.err.println("Failed to write module to memory: " + error.getString());
            LLVMDisposeMessage(error);
            return null;
        }
        return ref;
    }

    private final BytePointer error = new BytePointer();

    LLVMTargetMachineRef targetMachineRef;

    public boolean writeToFile(String absolutePath) {
        if (LLVMTargetMachineEmitToFile(
                targetMachineRef,
                module,
                Util.memUTF(absolutePath),
                LLVMObjectFile,
                error
        ) != 0) {
            System.err.println("Failed to write module to file: " + error.getString());
            LLVMDisposeMessage(error);
            return false;
        }
        return true;
    }

    public void toTargetMachine(
            Target target,
            CPU cpu
    ) {
        BytePointer targetTriple;

        if (target == null)
            targetTriple = track(LLVM.LLVMGetDefaultTargetTriple());
        else
            targetTriple = Util.memUTF(target.toString());
//        BytePointer targetTriple = Util.memUTF("x86_64-pc-windows-gcc");
//        BytePointer targetTriple = Util.memUTF("x86_64-w64-windows-gnu");
        LLVMTargetRef targetRef = track(new LLVMTargetRef());
        if (LLVMGetTargetFromTriple(
                targetTriple, targetRef, error
        ) != 0) {
            System.err.println("Failed to acquire targetTriple: " + error.getString());
            LLVMDisposeMessage(error);
            return;
        }

        System.out.println("Target: " + Util.string(targetTriple));


        BytePointer CPU = track(Util.memUTF(cpu.name()));
        // TODO: config
        BytePointer blank = track(Util.memUTF(""));
        LLVMTargetMachineRef machineRef = track(LLVM.LLVMCreateTargetMachine(
                targetRef, targetTriple,
                CPU, blank,
                LLVMCodeGenLevelDefault,
                LLVMRelocPIC,
                LLVMCodeModelDefault
        ));


        LLVMTargetDataRef targetDataRef = track(LLVM.LLVMCreateTargetDataLayout(machineRef));
        LLVM.LLVMSetDataLayout(
                module,
                track(LLVM.LLVMCopyStringRepOfTargetData(targetDataRef))
        );
        System.out.println(Util.string(LLVM.LLVMCopyStringRepOfTargetData(targetDataRef)));
        LLVM.LLVMSetTarget(module, targetTriple);

        this.targetMachineRef = machineRef;
    }

    protected void validate() {
        if (LLVMVerifyModule(module, LLVMPrintMessageAction, error) != 0) {
            LLVMDisposeMessage(error);
            throw new RuntimeException("Failed to verify module");
        }
    }
}
