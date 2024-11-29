package tfc.ralux.compiler.backend.llvm.util.helper.str;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMPassManagerRef;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.root.enums.ECompOp;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;

public class StringToInt {
    LLVMTypeRef typeRef;
    LLVMTypeRef i32;
    BuilderRoot root;
    FunctionType funcType;
    FunctionBuilder functionBuilder;
    LLVMValueRef zero;
    LLVMValueRef zeroI32;
    LLVMValueRef zero_byte;
    LLVMValueRef one;
    LLVMValueRef ten;
    LLVMValueRef fortyEight;
    LLVMValueRef fortyEight_byte;
    LLVMValueRef fortyFive;
    int baseStrLen;

    public StringToInt(BuilderRoot root, LLVMTypeRef typeRef) {
        this.typeRef = typeRef;
        this.i32 = root.getIntType(32);
        this.root = root;

        funcType = new FunctionType(
                root, typeRef
        ).withArgs(root.CSTRING_TYPE).build();

        this.functionBuilder = new FunctionBuilder(
                root, "stringToInt", funcType
        );

        zero = root.integer(0, typeRef);
        zeroI32 = root.integer(0, i32);
        zero_byte = root.integer(10, root.getIntType(8)); // new line char
        one = root.integer(1, i32);
        ten = root.integer(10, typeRef);
        fortyEight = root.integer(48, typeRef);
        fortyEight_byte = root.integer(48, root.getIntType(8));
        // TODO: why does -3 get a "-" instead of 45?
        fortyFive = root.integer(-3, root.getIntType(8));

        baseStrLen = (int) Math.floor(root.getIntSize(typeRef) * Math.log10(2)) + 1;

        buildBody();
        optimize();
    }

    private void optimize() {
        LLVMPassManagerRef pass = LLVM.LLVMCreateFunctionPassManagerForModule(root.getModule());

        // TODO: optimize pass set
        LLVM.LLVMAddCFGSimplificationPass(pass);
        LLVM.LLVMAddPromoteMemoryToRegisterPass(pass);
        LLVM.LLVMAddInstructionCombiningPass(pass);
        LLVM.LLVMAddReassociatePass(pass);
        LLVM.LLVMAddLoopRotatePass(pass);
        LLVM.LLVMAddLoopUnrollPass(pass);
        LLVM.LLVMAddLoopVectorizePass(pass);
        LLVM.LLVMAddGVNPass(pass);
        LLVM.LLVMAddInstructionCombiningPass(pass);
        LLVM.LLVMAddReassociatePass(pass);
        LLVM.LLVMAddCFGSimplificationPass(pass);

        LLVM.LLVMRunFunctionPassManager(pass, functionBuilder.getDirect());

        LLVM.LLVMDisposePassManager(pass);
    }

    private void buildBody() {
        BlockBuilder building = root.getBlockBuilding();

        BlockBuilder entry = functionBuilder.block("entry");
        entry.enableBuilding();

        LLVMValueRef str = functionBuilder.getArg(0, root.CSTRING_TYPE);
        // vars
        LLVMValueRef index = root.allocA(i32, "index");
        LLVMValueRef interm = root.allocA(typeRef, "interm");

        // set initials
        root.setValue(index, zeroI32);
        root.setValue(interm, zero);

        // blocks
        BlockBuilder header = functionBuilder.block("header");
        BlockBuilder body = functionBuilder.block("body");
        BlockBuilder footer = functionBuilder.block("footer");

        {
            entry.jump(header);
            header.enableBuilding();
            LLVMValueRef indx = root.getValue(index, "get_index");
            LLVMValueRef chr = root.getValue(str, indx, "get_char");
//            root.stdLib.print(root.stdLib.intToString(root.getIntType(8), chr));
            LLVMValueRef condition = root.compareInt(ECompOp.NE, chr, zero_byte, "cmp_chr_null");
            header.conditionalJump(condition, body, footer);
        }

        {
            body.enableBuilding();

            LLVMValueRef indx = root.getValue(index, "get_index");
            LLVMValueRef chr = root.getValue(str, indx, "get_char");
            LLVMValueRef dig = root.sisub(chr, fortyEight_byte, "sub_45");
            indx = root.sisum(indx, one, "add_1");
            root.setValue(index, indx);

            LLVMValueRef itemp = root.getValue(interm, "get_interm");
            itemp = root.simul(itemp, ten, "mul_by_10");
            itemp = root.sisum(itemp, root.bitcastTruncOrExt(typeRef, dig,"cast_to_type"), "add_digit");
            root.setValue(interm, itemp);

            body.jump(header);
        }

        {
            footer.enableBuilding();
            footer.ret(root.getValue(interm, "get_result"));
        }

        building.enableBuilding();
    }

    public LLVMValueRef call(LLVMValueRef value) {
        // 39 for int128
        // 20 for int64
        // 10 for int32
        // 5 for int16
        // 3 for int8
        // 2 for int4
        // 1 for int2
        // +1 for sign
        PointerPointer args = root.track(new PointerPointer(1));
        args.put(0, value);

        LLVMValueRef res = root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                functionBuilder.getDirect(),
                args, 1, ""
        ));
        return res;
    }
}
