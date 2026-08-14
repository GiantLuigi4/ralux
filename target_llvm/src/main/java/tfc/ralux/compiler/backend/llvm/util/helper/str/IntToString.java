package tfc.ralux.compiler.backend.llvm.util.helper.str;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.*;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.root.enums.ECompOp;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;

public class IntToString {
    LLVMTypeRef typeRef;
    BuilderRoot root;
    FunctionType funcType;
    FunctionBuilder functionBuilder;
    LLVMValueRef zero;
    LLVMValueRef one;
    LLVMValueRef ten;
    LLVMValueRef fortyEight;
    LLVMValueRef fortyFive;
    int baseStrLen;

    public IntToString(BuilderRoot root, LLVMTypeRef typeRef) {
        this.typeRef = typeRef;
        this.root = root;

        funcType = new FunctionType(
                root, root.getIntType(32)
        ).withArgs(root.CSTRING_TYPE, typeRef).build();

        this.functionBuilder = new FunctionBuilder(
                root, "intToString", funcType
        );

        zero = root.integer(0, typeRef);
        one = root.integer(1, root.getIntType(32));
        ten = root.integer(10, typeRef);
        fortyEight = root.integer(48, root.getIntType(8));
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
        BlockBuilder ifItIs0 = functionBuilder.block("zero");
        BlockBuilder builder = functionBuilder.block("not_zero");

        entry.enableBuilding();
        LLVMValueRef arg0 = functionBuilder.getArg(0, root.CSTRING_TYPE);
        LLVMValueRef arg1 = functionBuilder.getArg(1, typeRef);
        {
            LLVMValueRef isItTrue = root.compareInt(ECompOp.EQ, arg1, zero, "is_it_zero");
            entry.conditionalJump(isItTrue, ifItIs0, builder);

            ifItIs0.enableBuilding();
            root.setValueI8(arg0, root.integer(0, 64), fortyEight);
            ifItIs0.ret(root.integer(1, 32));
        }

        builder.enableBuilding();


        LLVMValueRef conditionPN = root.compareInt(ECompOp.GE, arg1, zero, "comp_val_pos");

		LLVMTypeRef i32 = root.getIntType(32);
        LLVMValueRef index = root.allocA(i32, "index");
        LLVMValueRef interm = root.allocA(typeRef, "interm");
        root.setValue(index, root.integer(0, 32));
        root.setValue(interm, arg1);

        BlockBuilder sign = functionBuilder.block("sign");

        {
            BlockBuilder header = functionBuilder.block("header");
            builder.jump(header);

            header.enableBuilding();

            LLVMValueRef value = root.getValue(typeRef, interm, "tmp_cmp_interm");
            LLVMValueRef condition = root.compareInt(ECompOp.NE, value, zero, "condition_eq_0");
            BlockBuilder body = functionBuilder.block("body");

            header.conditionalJump(condition, body, sign);

            body.enableBuilding();

            value = root.getValue(typeRef, interm, "value");
            LLVMValueRef dig = root.simod(value, ten, "get_last_digit");
            value = root.sidiv(value, ten, "div_by_10");
            root.setValue(interm, value);

            dig = root.select(
                    conditionPN,
                    dig, root.negate(dig)
            );

            value = root.getValue(i32, index, "index");
            root.setValueI8(arg0, value, root.sisum(root.truncate(
                    root.getIntType(8),
                    dig,
                    "as_int8"
            ), fortyEight, "offset_to_utf"));
            value = root.sisum(value, one, "index_incr");
            root.setValue(index, value);

            body.jump(header);
        }

        BlockBuilder reverse = functionBuilder.block("reverse");

        {
            sign.enableBuilding();

            BlockBuilder neg = functionBuilder.block("neg");

            sign.conditionalJump(conditionPN, reverse, neg);

            neg.enableBuilding();

            LLVMValueRef value = root.getValue(i32, index, "index");
            root.setValueI8(arg0, value, root.sisum(root.truncate(
                    root.getIntType(8),
                    fortyFive,
                    "as_int8"
            ), fortyEight, "offset_to_utf"));
            root.setValue(index, root.sisum(root.getValue(i32, index, "tmp_get_idx"), one, "incr_idx"));
            neg.jump(reverse);
        }

        reverse.enableBuilding();
        LLVMValueRef ip = root.getValue(i32, index, "get_index");
        LLVMValueRef ipm1 = root.sisub(ip, one, "index_minus_one");
        LLVMValueRef ip1 = root.sisum(ip, one, "index_plus_one");
        LLVMValueRef ip1d2 = root.sidiv(ip1, root.integer(2, 32), "div_by_2");
        root.setValue(index, root.integer(0, 32));

        BlockBuilder conclusion = functionBuilder.block("conclusion");
        {
            BlockBuilder header = functionBuilder.block("loop_header");
            BlockBuilder body = functionBuilder.block("loop_body");
            reverse.jump(header);

            header.enableBuilding();
            LLVMValueRef indx = root.getValue(i32, index, "get_index");
            LLVMValueRef cond = root.compareInt(ECompOp.LT, indx, ip1d2, "compare_termin");
            header.conditionalJump(cond, body, conclusion);

            body.enableBuilding();
            indx = root.getValue(i32, index, "get_indx");

            LLVMValueRef left = root.getValue(root.BYTE_TYPE, arg0, indx, "get_left");
            LLVMValueRef right_indx = root.sisub(ipm1, indx, "calc_right_indx");
            LLVMValueRef right = root.getValue(root.BYTE_TYPE, arg0, right_indx, "get_right");
            root.setValueI8(arg0, indx, right);
            root.setValueI8(arg0, right_indx, left);

            indx = root.sisum(indx, one, "incr_indx");
            root.setValue(index, indx);
            body.jump(header);
        }

        conclusion.enableBuilding();
        conclusion.ret(root.getValue(i32, index, "res_index"));

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
        LLVMValueRef str = root.allocA(root.BYTE_TYPE, baseStrLen + 1, "str_buf");
        root.memSet(str, root.integer(0, 8), root.integer(baseStrLen + 1, 32), 8);
        PointerPointer args = root.track(new PointerPointer(2));
        args.put(0, str);
        args.put(1, value);

        root.track(LLVM.LLVMBuildCall2(
                root.getBuilder(),
		        functionBuilder.getType(),
                functionBuilder.getDirect(),
                args, 2, ""
        ));
        return str;
    }
}
