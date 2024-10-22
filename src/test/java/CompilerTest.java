import org.bytedeco.llvm.LLVM.LLVMBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMContextRef;
import org.bytedeco.llvm.LLVM.LLVMModuleRef;
import org.bytedeco.llvm.LLVM.LLVMPassManagerRef;

import static org.bytedeco.llvm.global.LLVM.*;

public class CompilerTest {
    public static void main(String[] args) {
        LLVMInitializeNativeTarget();
        LLVMInitializeNativeAsmPrinter();

        LLVMContextRef context = LLVMContextCreate();
        LLVMModuleRef module = LLVMModuleCreateWithNameInContext("factorial", context);
        LLVMBuilderRef builder = LLVMCreateBuilderInContext(context);

        LLVMPassManagerRef pm = LLVMCreatePassManager();
        LLVMRunPassManager(pm, module);
    }
}
