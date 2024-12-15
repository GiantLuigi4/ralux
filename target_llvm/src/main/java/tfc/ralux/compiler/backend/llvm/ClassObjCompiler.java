package tfc.ralux.compiler.backend.llvm;

import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMTypeRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.root.enums.ECompOp;
import tfc.ralux.compiler.backend.llvm.util.BlockBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.util.FunctionType;
import tfc.ralux.compiler.frontend.ralux.RlxClassData;
import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxField;
import tfc.rlxir.RlxModule;
import tfc.rlxir.util.rt.RlxRt;

public class ClassObjCompiler {
    protected static LLVMValueRef extractField(BuilderRoot root, LLVMValueRef obj, LLVMTypeRef type, int offset) {
        LLVMTypeRef tr = root.pointerType(type);
        // TODO: super calls
        LLVMValueRef valueRef = obj;
        // TODO: GEP?
        valueRef = root.ptrCast(valueRef, root.getIntType(64), "cast_to_long");
        valueRef = root.sisum(valueRef, root.integer(offset + RlxCls.OBJ_BASE, 64), "offset_ptr");
        valueRef = root.toPtr(valueRef, tr, "ensure_ptr");
        return valueRef;
    }

    public static RlxClassData compileClass(RlxRt rt, BuilderRoot root, RlxCls clazz, RlxModule module) {
        LLVMTypeRef voidPtr = root.pointerType(root.VOID);

        RlxClassData data = clazz.getCompilerData();
        if (data == null) {
            data = new RlxClassData();
            clazz.setCompilerData(data);
        }

        {
            FunctionType tyTrack = root.functionType(root.VOID).withArgs(
                    voidPtr, voidPtr, voidPtr
            ).build();
            FunctionBuilder trackFunc = root.function(clazz.qualifiedName() + "::cls::<objtrack>", tyTrack);
            data.trackFunc = trackFunc;

            BlockBuilder builder = trackFunc.block("entry");
            builder.enableBuilding();

            LLVMValueRef val0 = trackFunc.getArg(1, voidPtr);
            LLVMValueRef val1 = trackFunc.getArg(2, voidPtr);
            LLVMValueRef object = trackFunc.getArg(0, voidPtr);

            for (RlxField field : clazz.getFields()) {
                if (field.type.clazz != null) {
                    int offset = clazz.getFieldOffset(field);

                    FunctionBuilder markObj = rt.rtMarkObj.getCompilerData();
                    PointerPointer<LLVMValueRef> args = root.track(new PointerPointer<>(3));
                    args.put(0, val0);
                    args.put(1, val1);

                    LLVMValueRef val2 = root.getValue(extractField(
                            root, object,
                            voidPtr, offset
                    ), "get_field_value");

                    args.put(2, val2);
                    root.track(LLVM.LLVMBuildCall(
                            root.getBuilder(),
                            markObj.getDirect(),
                            args, 3,
                            ""
                    ));
                } else if (field.type.isArray()) throw new RuntimeException("TODO");
            }

            builder.ret();
        }

        {
            // TODO: locate finalize function (if present)
            data.finalizeFunc = module.rt.rtNoop.getCompilerData();
        }

        {
            LLVMValueRef classObject = root.globalMemory(clazz.qualifiedName() + "::cls");

            FunctionType ty = root.functionType(root.pointerType(voidPtr)).build();
            FunctionBuilder initFunc = root.function(clazz.qualifiedName() + "::cls::<clinit>", ty);
            data.loadFunc = initFunc;
            buildInit(initFunc, root, classObject, module, (FunctionBuilder) data.trackFunc, (FunctionBuilder) data.finalizeFunc);
        }

        return data;
    }

    private static void buildInit(FunctionBuilder builder, BuilderRoot root, LLVMValueRef classObject, RlxModule module, FunctionBuilder trackObj, FunctionBuilder finalizeObj) {
        BlockBuilder block = builder.block("entry");
        block.enableBuilding();

        BlockBuilder abranch = builder.block("already_init");
        BlockBuilder mbranch = builder.block("must_init");

        LLVMValueRef nullCheck = root.compareInt(
                ECompOp.EQ,
                root.getValue(
                        root.ptrCast(classObject, root.pointerType(root.getIntType(64)), "to_long_ptr"),
                        "extract_pointee"
                ),
                root.integer(0, 64),
                "is_null"
        );

        block.conditionalJump(nullCheck, mbranch, abranch);

        // TODO: init static fields

        mbranch.enableBuilding();
        PointerPointer<LLVMValueRef> noArg = new PointerPointer<>(0);
        PointerPointer<LLVMValueRef> allocArgs = new PointerPointer<>(2);
        root.track(noArg);
        root.track(allocArgs);

        LLVMValueRef gc = root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                ((FunctionBuilder) module.gc.rtGlobalGC.getCompilerData()).getDirect(),
                noArg, 0,
                "get_gc"
        ));

        allocArgs.put(0, gc);
        allocArgs.put(1, root.integer(8 * 2, 32));

        LLVMValueRef classValue = root.track(LLVM.LLVMBuildCall(
                root.getBuilder(),
                ((FunctionBuilder) module.gc.gcAlloc.getCompilerData()).getDirect(),
                allocArgs, 2,
                "alloc_class"
        ));
        LLVMValueRef ptrptr = root.ptrCast(classValue, root.pointerType(root.pointerType(root.VOID)), "to_ptr_ptr");

        root.setValue(classObject, classValue);

        {
            LLVMValueRef ptr = root.ptrCast(
                    trackObj.getDirect(),
                    root.pointerType(root.VOID),
                    "to_ptr"
            );
            root.setValue(ptrptr, root.integer(0, 32), ptr);
        }
        {
            LLVMValueRef ptr = root.ptrCast(
                    finalizeObj.getDirect(),
                    root.pointerType(root.VOID),
                    "to_ptr"
            );
            root.setValue(ptrptr, root.integer(1, 32), ptr);
        }
        mbranch.jump(abranch);

        abranch.enableBuilding();
        abranch.ret(root.ptrCast(root.getValue(classObject, "get_class"), root.pointerType(root.pointerType(root.VOID)), "cst"));
    }
}
