package tfc.ralux.compiler.backend.llvm.root;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.*;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.enums.ECompOp;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;
import tfc.ralux.compiler.backend.llvm.util.helper.STDLib;
import tfc.ralux.compiler.backend.llvm.util.helper.Util;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.instr.RlxInstr;
import tfc.rlxir.instr.value.MathInstr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuilderRoot extends ModuleRoot {
    public final LLVMTypeRef VOID;
    public STDLib stdLib;
    LLVMBuilderRef builder = LLVM.LLVMCreateBuilderInContext(context);
    LLVMDIBuilderRef debug;

    List<LLVMTypeRef> intTypes = new ArrayList<>();
    List<LLVMTypeRef> floatTypes = new ArrayList<>();

    public BuilderRoot(String moduleName) {
        super(moduleName);
        debug = LLVM.LLVMCreateDIBuilder(module);
        for (int i = 0; i < 8; i++) {
            intTypes.add(LLVM.LLVMIntTypeInContext(context, 1 << i));
            System.out.println(1 << i);
        }
        LLVM.LLVMSetModuleIdentifier(module, moduleName, moduleName.length());

        floatTypes.add(null);
        floatTypes.add(null);
        floatTypes.add(null);
        floatTypes.add(null);
        floatTypes.add(LLVM.LLVMHalfTypeInContext(context));
        floatTypes.add(LLVM.LLVMFloatTypeInContext(context));
        floatTypes.add(LLVM.LLVMDoubleTypeInContext(context));
        floatTypes.add(LLVM.LLVMFP128TypeInContext(context));

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

    Map<LLVMTypeRef, LLVMTypeRef> defaultPtrs = new HashMap<>();

    public LLVMTypeRef pointerType(LLVMTypeRef type, int addrSpace) {
        if (addrSpace == 0) {
            LLVMTypeRef ptrType = defaultPtrs.get(type);
            if (ptrType != null) return ptrType;
        }
        return LLVM.LLVMPointerType(type, addrSpace);
    }

    public LLVMValueRef integer(int i, LLVMTypeRef typeRef) {
        return track(LLVM.LLVMConstInt(typeRef, i, 0));
    }

    public LLVMValueRef integer(long i, LLVMTypeRef typeRef) {
        return track(LLVM.LLVMConstInt(typeRef, i, 0));
    }

    public LLVMValueRef integer(int i, int bits) {
        int index = Util.log2(bits) - 1;
        return track(LLVM.LLVMConstInt(intTypes.get(index), i, 0));
    }

    public LLVMValueRef integer(long i, int bits) {
        int index = Util.log2(bits) - 1;
        return track(LLVM.LLVMConstInt(intTypes.get(index), i, 0));
    }

    // TODO: properly deal with this?
    public LLVMValueRef loadFloat(float data, LLVMTypeRef llvmTypeRef) {
        LLVMValueRef vI = integer(Float.floatToIntBits(data), getIntType(32));
        return bitcast(llvmTypeRef, vI, "convert_floatBits_toFloat");
    }

    public LLVMValueRef loadFloat(double data, LLVMTypeRef llvmTypeRef) {
        LLVMValueRef vI = integer(Double.doubleToLongBits(data), getIntType(64));
        return bitcast(llvmTypeRef, vI, "convert_floatBits_toFloat");
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
        ), functionName, type.getDirect());
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
                name + "_gep"
        ));
        return getValue(gep, name);
    }

    public LLVMValueRef getElement(LLVMValueRef pointer, LLVMValueRef index, String name) {
        PointerPointer indices = track(new PointerPointer(2));
        indices.put(0, track(LLVM.LLVMBuildZExtOrBitCast(
                builder, index, getIntType(64), "as_int64"
        )));
        return track(LLVM.LLVMBuildGEP(
                builder, pointer,
                indices, 1,
                "get_element_ptr"
        ));
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
        return track(LLVM.LLVMBuildCast(builder, LLVM.LLVMSIToFP, value, toType, name));
    }

    public LLVMValueRef castFP(LLVMTypeRef toType, LLVMValueRef value, String name) {
        return track(LLVM.LLVMBuildFPCast(builder, value, toType, name));
    }

    public LLVMValueRef castFPToSI(LLVMTypeRef toType, LLVMValueRef value, String name) {
        return track(LLVM.LLVMBuildCast(builder, LLVM.LLVMFPToSI, value, toType, name));
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
        return track(LLVM.LLVMBuildInBoundsGEP(
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
        LLVM.LLVMAddCFGSimplificationPass(pass);
        LLVM.LLVMAddPromoteMemoryToRegisterPass(pass);
        LLVM.LLVMAddAggressiveDCEPass(pass);
        LLVM.LLVMAddEarlyCSEPass(pass);
        LLVM.LLVMAddSimplifyLibCallsPass(pass);
        LLVM.LLVMAddAlwaysInlinerPass(pass);
        LLVM.LLVMAddInstructionSimplifyPass(pass);
        LLVM.LLVMAddReassociatePass(pass);
        LLVM.LLVMAddInstructionCombiningPass(pass);
        LLVM.LLVMAddIndVarSimplifyPass(pass);
        LLVM.LLVMAddNewGVNPass(pass);
        LLVM.LLVMAddConstantMergePass(pass);
        LLVM.LLVMAddTailCallEliminationPass(pass);

        // analysis
        LLVM.LLVMAddTypeBasedAliasAnalysisPass(pass);
        LLVM.LLVMAddBasicAliasAnalysisPass(pass);
        LLVM.LLVMAddAlignmentFromAssumptionsPass(pass);

        // erase branches
        LLVM.LLVMAddLoopIdiomPass(pass);
        LLVM.LLVMAddLoopRotatePass(pass);
        LLVM.LLVMAddLoopUnrollAndJamPass(pass);
        LLVM.LLVMAddCFGSimplificationPass(pass);
        if (!forFunction)
            LLVM.LLVMAddLoopUnswitchPass(pass);
        LLVM.LLVMAddLoopDeletionPass(pass);
        LLVM.LLVMAddLoopRerollPass(pass);
        LLVM.LLVMAddJumpThreadingPass(pass);
        LLVM.LLVMAddLICMPass(pass);
        LLVM.LLVMAddSCCPPass(pass);

        // simplify
        LLVM.LLVMAddInstructionSimplifyPass(pass);
        LLVM.LLVMAddIndVarSimplifyPass(pass);
        LLVM.LLVMAddSLPVectorizePass(pass);
        LLVM.LLVMAddDeadStoreEliminationPass(pass);
        LLVM.LLVMAddStripDeadPrototypesPass(pass);
        LLVM.LLVMAddMergedLoadStoreMotionPass(pass);
        LLVM.LLVMAddMemCpyOptPass(pass);

        // re-associate
        LLVM.LLVMAddReassociatePass(pass);
        LLVM.LLVMAddInstructionCombiningPass(pass);

        // finalize
        LLVM.LLVMAddCFGSimplificationPass(pass);
        LLVM.LLVMAddAggressiveInstCombinerPass(pass);
        LLVM.LLVMAddScopedNoAliasAAPass(pass);
        LLVM.LLVMAddSLPVectorizePass(pass);
    }

    public void memSet(LLVMValueRef ptr, LLVMValueRef value, LLVMValueRef len, int alignment) {
        LLVM.LLVMBuildMemSet(builder, ptr, value, len, alignment);
    }

    public LLVMValueRef and(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return LLVM.LLVMBuildAnd(builder, lh, rh, name);
    }

    public LLVMValueRef or(LLVMValueRef lh, LLVMValueRef rh, String name) {
        return LLVM.LLVMBuildOr(builder, lh, rh, name);
    }

    public LLVMValueRef bitcastTruncOrExt(LLVMTypeRef toType, LLVMValueRef value, String name) {
        int sizeTo = getIntSize(toType);
        LLVMTypeRef typeRef2 = LLVM.LLVMTypeOf(value);
        LLVMTargetDataRef targetData = LLVM.LLVMCreateTargetData("");
        int sizeFrom = (int) LLVM.LLVMSizeOfTypeInBits(targetData, typeRef2);
        if (sizeFrom < sizeTo) {
            return extend(toType, value, name);
        } else if (sizeFrom > sizeTo) {
            return truncate(toType, value, name);
        }
        return value;
    }

    public LLVMValueRef ptrCast(LLVMValueRef valueRef, LLVMTypeRef type, String name) {
        return track(LLVM.LLVMBuildPointerCast(
                builder, valueRef, type, name
        ));
    }

    HashMap<String, LLVMMetadataRef> scopes = new HashMap<>();

    protected LLVMMetadataRef file(String name) {
        LLVMMetadataRef md = scopes.get(name);
        if (md != null) return md;

        String dir = name.substring(0, name.lastIndexOf('/'));
        String fileName = name.substring(name.lastIndexOf('/') + 1);
        LLVMMetadataRef metadataRef = LLVM.LLVMDIBuilderCreateFile(
                debug,
                dir, dir.length(),
                fileName, fileName.length()
        );
        track(metadataRef);
        metadataRef = LLVM.LLVMDIBuilderCreateCompileUnit(
                debug,
                LLVM.LLVMDWARFSourceLanguageUPC,
                metadataRef, "RaluxLang" + (char) 0, "RaluxLang".length(),
                0, "", 0,
                0, "", 0,
                0, 0, 0, 0,
                "", 0, "RlxRt" + (char) 0, 5
        );
        scopes.put(name, metadataRef);
        return metadataRef;
    }

//    protected LLVMMetadataRef dbgFunction(RlxInstr instr, LLVMMetadataRef scope) {
//        RlxFunction function = instr.getFunction();
//        FunctionBuilder builder1 = function.getCompilerData();
//        LLVM.LLVMDIBuilderCreateFunction(
//                debug,
//                scope,
//                instr.getFunction().getExportName(),
//                instr.getFunction().getExportName().length(),
//                instr.getFunction().getExportName(),
//                instr.getFunction().getExportName().length(),
//                file,
//                0,
//
//        )
//        builder1.getDirect();
//    }

    public void setDebug(LLVMValueRef ref, RlxInstr instr) {
        if (instr.getSourceFile() != null) {
            // TODO: scopes are per-function...

//            LLVMMetadataRef md = file(instr.getSourceFile());
//            LLVMMetadataRef llvmMetadataRef = LLVM.LLVMDIBuilderCreateDebugLocation(
//                    context, instr.getLine(), instr.getColumn(),
//                    md, null
//            );
//            track(llvmMetadataRef);
//            LLVM.LLVMInstructionSetDebugLoc(ref, llvmMetadataRef);
        }
    }

    public LLVMValueRef toPtr(LLVMValueRef valueRef, LLVMTypeRef llvmTypeRef, String name) {
        return track(LLVM.LLVMBuildIntToPtr(
                builder, valueRef, llvmTypeRef, name
        ));
    }

    public LLVMValueRef globalMemory(String varName) {
        return globalMemory(pointerType(VOID), varName);
    }

    public LLVMValueRef globalMemory(LLVMTypeRef typeRef, String varName) {
        LLVMValueRef valueRef = LLVM.LLVMAddGlobal(module, typeRef, varName);
        LLVM.LLVMSetLinkage(valueRef, LLVM.LLVMInternalLinkage);
        LLVM.LLVMSetInitializer(
                valueRef,
                ptrCast(integer(0, 64), typeRef, "to_type")
        );
        return track(valueRef);
    }
}
