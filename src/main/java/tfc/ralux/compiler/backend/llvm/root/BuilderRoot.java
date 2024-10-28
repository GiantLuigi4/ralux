package tfc.ralux.compiler.backend.llvm.root;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.*;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.FunctionType;
import tfc.ralux.compiler.backend.llvm.helper.STDLib;
import tfc.ralux.compiler.backend.llvm.helper.Util;
import tfc.ralux.compiler.backend.llvm.root.enums.ECompOp;

import java.util.ArrayList;
import java.util.List;

import static org.bytedeco.llvm.global.LLVM.*;

public class BuilderRoot extends ModuleRoot {
    public final LLVMTypeRef VOID;
    public STDLib stdLib;
    LLVMBuilderRef builder = LLVMCreateBuilderInContext(context);

    List<LLVMTypeRef> intTypes = new ArrayList<>();
    List<LLVMTypeRef> floatTypes = new ArrayList<>();

    public BuilderRoot(String moduleName) {
        super(moduleName);
        for (int i = 0; i < 8; i++) {
            intTypes.add(LLVMIntTypeInContext(context, 1 << i));
            System.out.println(1 << i);
        }

        floatTypes.add(null);
        floatTypes.add(null);
        floatTypes.add(null);
        floatTypes.add(null);
        floatTypes.add(LLVMHalfTypeInContext(context));
        floatTypes.add(LLVMFloatTypeInContext(context));
        floatTypes.add(LLVMDoubleTypeInContext(context));
        floatTypes.add(LLVMFP128TypeInContext(context));

        VOID = LLVM.LLVMVoidTypeInContext(context);
        stdLib = new STDLib(this);
    }

    List<FunctionBuilder> functions = new ArrayList<>();

    public FunctionType functionType(LLVMTypeRef returnType) {
        return new FunctionType(this, returnType);
    }

    public LLVMTypeRef arrayType(LLVMTypeRef type, int elements) {
        return LLVM.LLVMArrayType(type, elements);
    }

    public LLVMTypeRef pointerType(LLVMTypeRef type) {
        return pointerType(type, 0);
    }

    public LLVMTypeRef pointerType(LLVMTypeRef type, int addrSpace) {
        return LLVMPointerType(type, addrSpace);
    }

    public LLVMValueRef integer(int i, LLVMTypeRef typeRef) {
        return track(LLVM.LLVMConstInt(typeRef, i, 0));
    }

    public LLVMValueRef integer(int i, int bits) {
        int index = Util.log2(bits) - 1;
        return track(LLVM.LLVMConstInt(intTypes.get(index), i, 0));
    }

    public LLVMTypeRef getIntType(int bits) {
        int index = Util.log2(bits) - 1;
        return intTypes.get(index);
    }

    public int getIntSize(LLVMTypeRef typeRef) {
        for (int i = 0; i < intTypes.size(); i++) {
            if (intTypes.get(i).equals(typeRef))
                return 1 << i;
        }
        throw new RuntimeException("Not a valid int type");
    }

    public LLVMTypeRef getFloatType(int bits) {
        int index = Util.log2(bits) - 1;
        return floatTypes.get(index);
    }

    public int getFloatSize(LLVMTypeRef typeRef) {
        for (int i = 0; i < floatTypes.size(); i++) {
            if (typeRef.equals(floatTypes.get(i)))
                return 1 << i;
        }
        throw new RuntimeException("Not a valid float type");
    }

    public FunctionBuilder function(
            String functionName,
            FunctionType type
    ) {
        return new FunctionBuilder(this, LLVM.LLVMAddFunction(
                module, functionName, type.getDirect()
        ), functionName);
    }

    public LLVMBuilderRef getBuilder() {
        return builder;
    }

    public LLVMValueRef globalString(String string) {
        return track(LLVM.LLVMBuildGlobalString(
                builder,
                string, string
        ));
    }

    public LLVMValueRef allocA(LLVMTypeRef type, String name) {
        return track(LLVM.LLVMBuildAlloca(builder, type, name));
    }

    public LLVMValueRef allocA(LLVMTypeRef type, int length, String name) {
        return track(LLVM.LLVMBuildArrayAlloca(builder, type, integer(length, 32), name));
    }

    public LLVMValueRef allocA(LLVMTypeRef type, LLVMValueRef length, String name) {
        return track(LLVM.LLVMBuildArrayAlloca(builder, type, length, name));
    }

    public void setValue(LLVMValueRef pointer, LLVMValueRef value) {
        track(LLVM.LLVMBuildStore(builder, value, pointer));
    }

    public void setValue(LLVMValueRef pointer, LLVMValueRef index, LLVMValueRef value) {
//        %3 = getelementptr inbounds [20 x i8], [20 x i8]* %1, i64 0, i64 1
//        store i8 49, i8* %3, align 1, !tbaa !3

        PointerPointer indices = track(new PointerPointer(2));
        indices.put(0, track(LLVM.LLVMBuildZExtOrBitCast(
                builder, index, getIntType(64), "as_int64"
        )));
        LLVMValueRef gep = track(LLVM.LLVMBuildInBoundsGEP(
                builder, pointer,
                indices, 1,
                "get_element_ptr"
        ));
        setValue(gep, value);
    }

    public LLVMValueRef getValue(LLVMValueRef pointer, String name) {
        return track(LLVM.LLVMBuildLoad(builder, pointer, name));
    }

    public LLVMValueRef getValue(LLVMValueRef pointer, LLVMValueRef index, String name) {
        PointerPointer indices = track(new PointerPointer(2));
        indices.put(0, track(LLVM.LLVMBuildZExtOrBitCast(
                builder, index, getIntType(64), "as_int64"
        )));
        LLVMValueRef gep = track(LLVM.LLVMBuildInBoundsGEP(
                builder, pointer,
                indices, 1,
                "get_element_ptr"
        ));
        return getValue(gep, name);
    }

    public LLVMValueRef compareInt(ECompOp op, LLVMValueRef lh, LLVMValueRef rh, String label) {
        return track(LLVM.LLVMBuildICmp(builder, op.opSInt, lh, rh, label));
    }

    public LLVMValueRef compareFloat(ECompOp op, LLVMValueRef lh, LLVMValueRef rh, String label) {
        return track(LLVM.LLVMBuildFCmp(builder, op.opFP, lh, rh, label));
    }

    BlockBuilder building;

    public void buildBlock(BlockBuilder blockBuilder) {
        LLVM.LLVMPositionBuilderAtEnd(builder, blockBuilder.getDirect());
        building = blockBuilder;
    }

    public BlockBuilder getBlockBuilding() {
        return building;
    }

    public LLVMValueRef simul(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return track(LLVM.LLVMBuildMul(builder, lh, rh, name));
    }

    public LLVMValueRef sidiv(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return track(LLVM.LLVMBuildSDiv(builder, lh, rh, name));
    }

    public LLVMValueRef simod(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return track(LLVM.LLVMBuildSRem(builder, lh, rh, name));
    }

    public LLVMValueRef sisum(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return track(LLVM.LLVMBuildAdd(builder, lh, rh, name));
    }

    public LLVMValueRef sisub(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return track(LLVM.LLVMBuildSub(builder, lh, rh, name));
    }

    public LLVMValueRef fsum(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return track(LLVM.LLVMBuildFAdd(builder, lh, rh, name));
    }

    public LLVMValueRef fsub(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return track(LLVM.LLVMBuildFSub(builder, lh, rh, name));
    }

    public LLVMValueRef fmul(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return track(LLVM.LLVMBuildFMul(builder, lh, rh, name));
    }

    public LLVMValueRef fdiv(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return track(LLVM.LLVMBuildFDiv(builder, lh, rh, name));
    }

    public void validate() {
        boolean valid = true;
        for (FunctionBuilder function : functions)
            valid = function.verifyFunction() && valid;
        super.validate();
    }

    public void trackFunction(FunctionBuilder functionBuilder) {
        track(functionBuilder);
        functions.add(functionBuilder);
    }

    public LLVMValueRef bitcast(LLVMTypeRef toType, LLVMValueRef value, String name) {
        return track(LLVM.LLVMBuildBitCast(builder, value, toType, name));
    }

    public LLVMValueRef castSIToFP(LLVMTypeRef toType, LLVMValueRef value, String name) {
        return track(LLVM.LLVMBuildCast(builder, LLVMSIToFP, value, toType, name));
    }

    public LLVMValueRef castFP(LLVMTypeRef toType, LLVMValueRef value, String name) {
        return track(LLVM.LLVMBuildFPCast(builder, value, toType, name));
    }

    public LLVMValueRef castFPToSI(LLVMTypeRef toType, LLVMValueRef value, String name) {
        return track(LLVM.LLVMBuildCast(builder, LLVMFPToSI, value, toType, name));
    }

    public LLVMValueRef bitcastOrExtend(LLVMTypeRef toType, LLVMValueRef value, String name) {
        return track(LLVM.LLVMBuildZExtOrBitCast(builder, value, toType, name));
    }

    public LLVMValueRef truncate(LLVMTypeRef toType, LLVMValueRef value, String name) {
        return track(LLVM.LLVMBuildTrunc(builder, value, toType, name));
    }

    public LLVMValueRef extend(LLVMTypeRef toType, LLVMValueRef value, String name) {
        return track(LLVM.LLVMBuildZExt(builder, value, toType, name));
    }

    public LLVMValueRef gepString(LLVMValueRef text) {
        PointerPointer indices = track(new PointerPointer(2));
        LLVMValueRef long0 = integer(0, 64);
        indices.put(0, long0);
        indices.put(1, long0);
        return track(LLVM.LLVMBuildGEP(
                builder, text,
                indices, 2,
                "gep_str"
        ));
    }

    public LLVMValueRef negate(LLVMValueRef dig) {
        return track(LLVM.LLVMBuildNeg(builder, dig, "negate"));
    }

    public LLVMValueRef negateFloat(LLVMValueRef dig) {
        return track(LLVM.LLVMBuildFNeg(builder, dig, "negate"));
    }

    public LLVMValueRef select(LLVMValueRef conditionPN, LLVMValueRef dig, LLVMValueRef negate) {
        return track(LLVM.LLVMBuildSelect(builder, conditionPN, dig, negate, "select"));
    }

    public void hyperAggressiveOptimizer(boolean forFunction, LLVMPassManagerRef pass) {
        // setup
        LLVMAddCFGSimplificationPass(pass);
        LLVMAddPromoteMemoryToRegisterPass(pass);
        LLVMAddAggressiveDCEPass(pass);
        LLVMAddEarlyCSEPass(pass);
        LLVMAddSimplifyLibCallsPass(pass);
        LLVMAddAlwaysInlinerPass(pass);
        LLVMAddInstructionSimplifyPass(pass);
        LLVMAddReassociatePass(pass);
        LLVMAddInstructionCombiningPass(pass);
        LLVMAddIndVarSimplifyPass(pass);
        LLVMAddNewGVNPass(pass);
        LLVMAddConstantMergePass(pass);
        LLVMAddTailCallEliminationPass(pass);

        // analysis
        LLVMAddTypeBasedAliasAnalysisPass(pass);
        LLVMAddBasicAliasAnalysisPass(pass);
        LLVMAddAlignmentFromAssumptionsPass(pass);

        // erase branches
        LLVMAddLoopIdiomPass(pass);
        LLVMAddLoopRotatePass(pass);
        LLVMAddLoopUnrollAndJamPass(pass);
        LLVMAddCFGSimplificationPass(pass);
        if (!forFunction)
            LLVMAddLoopUnswitchPass(pass);
        LLVMAddLoopDeletionPass(pass);
        LLVMAddLoopRerollPass(pass);
        LLVMAddJumpThreadingPass(pass);
        LLVMAddLICMPass(pass);
        LLVMAddSCCPPass(pass);

        // simplify
        LLVMAddInstructionSimplifyPass(pass);
        LLVMAddIndVarSimplifyPass(pass);
        LLVMAddSLPVectorizePass(pass);
        LLVMAddDeadStoreEliminationPass(pass);
        LLVMAddStripDeadPrototypesPass(pass);
        LLVMAddMergedLoadStoreMotionPass(pass);
        LLVMAddMemCpyOptPass(pass);

        // re-associate
        LLVMAddReassociatePass(pass);
        LLVMAddInstructionCombiningPass(pass);

        // finalize
        LLVMAddCFGSimplificationPass(pass);
        LLVMAddAggressiveInstCombinerPass(pass);
        LLVMAddScopedNoAliasAAPass(pass);
        LLVMAddSLPVectorizePass(pass);
    }

    public void memSet(LLVMValueRef ptr, LLVMValueRef value, LLVMValueRef len, int alignment) {
        LLVM.LLVMBuildMemSet(builder, ptr, value, len, alignment);
    }
}
