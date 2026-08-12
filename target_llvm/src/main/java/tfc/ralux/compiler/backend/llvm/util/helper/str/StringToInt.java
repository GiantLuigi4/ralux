package tfc.ralux.compiler.backend.llvm.util.helper.str;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.*;
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
//	    // 1. Define the pass pipeline string
//	    // Note: Loop passes must be wrapped in loop(...) or they will be ignored.
//	    String pipeline = "simplifycfg,mem2reg,instcombine,reassociate," +
//			    "loop(loop-rotate),loop(loop-unroll),loop-vectorize,newgvn," +
//			    "instcombine,reassociate,simplifycfg";
//
//	    // 2. Create PassBuilder options (Replaces PassManagerBuilder)
//	    LLVMPassBuilderOptionsRef options = LLVM.LLVMCreatePassBuilderOptions();
//
//	    // 3. Run passes on the specific function
//	    // functionBuilder.getDirect() should return an LLVMValueRef representing the function
//	    LLVMTargetMachineRef tm = null; // Provide your TargetMachine if you need target-specific vectorization
//	    LLVMErrorRef err = LLVM.LLVMRunPassesOnFunction(functionBuilder.getDirect(), pipeline, tm, options);
//
//	    // 4. Handle potential errors (NewPM requires explicit error checking)
//	    if (err != null && !err.isNull()) {
//		    BytePointer msg = LLVM.LLVMGetErrorMessage(err);
//		    System.err.println("LLVM Function Pass Error: " + msg.getString());
//		    LLVM.LLVMDisposeErrorMessage(msg);
//	    }
//
//	    // 5. Cleanup
//	    LLVM.LLVMDisposePassBuilderOptions(options);
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
        root.setValueI8(index, zeroI32);
        root.setValueI8(interm, zero);

        // blocks
        BlockBuilder header = functionBuilder.block("header");
        BlockBuilder body = functionBuilder.block("body");
        BlockBuilder footer = functionBuilder.block("footer");

        {
            entry.jump(header);
            header.enableBuilding();
            LLVMValueRef indx = root.getValue(i32, index, "get_index");
            LLVMValueRef chr = root.getValue(root.BYTE_TYPE, str, indx, "get_char");
//            root.stdLib.print(root.stdLib.intToString(root.getIntType(8), chr));
            LLVMValueRef condition = root.compareInt(ECompOp.NE, chr, zero_byte, "cmp_chr_null");
            header.conditionalJump(condition, body, footer);
        }

        {
            body.enableBuilding();

            LLVMValueRef indx = root.getValue(i32, index, "get_index");
            LLVMValueRef chr = root.getValue(root.BYTE_TYPE, str, indx, "get_char");
            LLVMValueRef dig = root.sisub(chr, fortyEight_byte, "sub_45");
            indx = root.sisum(indx, one, "add_1");
            root.setValueI8(index, indx);
	        
	        LLVMValueRef itemp = root.getValue(typeRef, interm, "get_interm");
	        itemp = root.simul(itemp, ten, "mul_by_10");
	        itemp = root.sisum(itemp, root.bitcastTruncOrExt(typeRef, dig,"cast_to_type"), "add_digit");
            root.setValueI8(interm, itemp);

            body.jump(header);
        }

        {
            footer.enableBuilding();
            footer.ret(root.getValue(typeRef, interm, "get_result"));
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

        LLVMValueRef res = root.track(LLVM.LLVMBuildCall2(
                root.getBuilder(),
		        functionBuilder.getType(),
                functionBuilder.getDirect(),
                args, 1, ""
        ));
        return res;
    }
}
