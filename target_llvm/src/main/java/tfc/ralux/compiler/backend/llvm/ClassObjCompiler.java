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
import tfc.rlxir.typing.RlxType;
import tfc.rlxir.typing.RlxTypes;
import tfc.rlxir.util.rt.RlxRt;

import java.lang.reflect.Field;

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

    public static RlxClassData compileClass(RlxRt rt, LLVMCompiler compiler, BuilderRoot root, RlxCls clazz, RlxModule module) {
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
//            LLVMValueRef val1 = trackFunc.getArg(2, voidPtr);
            LLVMValueRef object = trackFunc.getArg(0, voidPtr);

			if (clazz.qualifiedName().equals("tfc.ralux.runtime.ArrayObj")) {
				RlxField aOfObj = clazz.getField("ofObjects");
				int off = clazz.getFieldOffset(aOfObj);
				
//				LLVMValueRef strVr = LLVM.LLVMBuildGlobalStringPtr(root.getBuilder(), "TextA", "TextA");
//				LLVMValueRef str1Vr = LLVM.LLVMBuildGlobalStringPtr(root.getBuilder(), "TextB", "TextB");
//				LLVMValueRef str2Vr = LLVM.LLVMBuildGlobalStringPtr(root.getBuilder(), "TextC", "TextC");
				
				LLVMValueRef v0 = object;
				v0 = extractField(root, v0, compiler.typeData(RlxTypes.BOOLEAN), off);
				v0 = root.getValue(compiler.typeData(RlxTypes.BOOLEAN), v0, "get_isObj_data");
				LLVMValueRef isObject = v0;
				
				BlockBuilder bpreloop = trackFunc.block("pre_loop");
				BlockBuilder bloop = trackFunc.block("loop");
				BlockBuilder bend = trackFunc.block("end");
				BlockBuilder bgetdata = trackFunc.block("get_data");
				BlockBuilder bskip = trackFunc.block("skip");
				builder.conditionalJump(isObject, bpreloop, bskip);
				
				RlxField alen = clazz.getField("length");
				off = clazz.getFieldOffset(alen);
				
				
				bpreloop.enableBuilding();
				
				LLVMValueRef var = root.track(root.allocA(
						root.getIntType(32),
						"track_index"
				));
				root.setValue(var, root.integer(0, 32));
				
				
				v0 = object;
				v0 = extractField(root, v0, root.INT_TYPE, off);
				v0 = root.getValue(root.INT_TYPE, v0, "get_length_data");
				LLVMValueRef quantity = v0;
				
				LLVMValueRef shouldSkip = root.compareInt(ECompOp.EQ, root.integer(0, 32), quantity, "check_loop");
				
				bpreloop.conditionalJump(shouldSkip, bend, bgetdata);
				
				bgetdata.enableBuilding();
				
				aOfObj = clazz.getField("data");
				off = clazz.getFieldOffset(aOfObj);
				v0 = object;
				v0 = extractField(root, v0, root.VOID_PTR_PTR, off);
				v0 = root.getValue(root.VOID_PTR_PTR, v0, "get_array_data");
				bgetdata.jump(bloop);
				
				BlockBuilder bnonnull = trackFunc.block("non_null");
				BlockBuilder bcontinue = trackFunc.block("continue");
				{
					bloop.enableBuilding();
//					root.stdLib.print(strVr);
					
					LLVMValueRef index = root.track(root.getValue(root.INT_TYPE, var, "get_index_ptr"));
					
					LLVMValueRef ptr = root.getValue(root.VOID_PTR, v0, index, "get_value");
					LLVMValueRef asLong = root.ptrCast(ptr, root.LONG_TYPE, "as_long");
					
					LLVMValueRef vcomp = root.compareInt(ECompOp.NE, asLong, root.integer(0, 64), "check_nonnull");
					bloop.conditionalJump(vcomp, bnonnull, bcontinue);
					
					bnonnull.enableBuilding();
					{
						FunctionBuilder markObj = rt.rtMarkObj.getCompilerData();
						PointerPointer<LLVMValueRef> args = root.track(new PointerPointer<>(2));
						args.put(0, val0);
						args.put(1, ptr);
						root.track(LLVM.LLVMBuildCall2(
								root.getBuilder(),
								markObj.getType(),
								markObj.getDirect(),
								args, 2,
								""
						));
					}
					
					bnonnull.jump(bcontinue);
					
					bcontinue.enableBuilding();
					LLVMValueRef vr = root.sisum(index, root.integer(1, 32), "incr_index");
					root.setValue(var, vr);
					
					LLVMValueRef shouldEnd = root.compareInt(ECompOp.LT, index, quantity, "check_loop");
					bcontinue.conditionalJump(shouldEnd, bloop, bend);
				}
				
				bskip.enableBuilding();
//				root.stdLib.print(str2Vr);
				bskip.ret();
				
				bend.enableBuilding();
//				root.stdLib.print(str1Vr);
				builder = bend;
			}
			
            for (RlxField field : clazz.getFields()) {
                if (field.type.clazz != null || field.type.isArray()) {
					if (field.type.isArray() && field.type.arrayOf == RlxTypes.VOID) {
						// this is a special case, we do not want to do anything here
						continue;
					}
					
                    int offset = clazz.getFieldOffset(field);

                    FunctionBuilder markObj = rt.rtMarkObj.getCompilerData();
                    PointerPointer<LLVMValueRef> args = root.track(new PointerPointer<>(2));
                    args.put(0, val0);
//                    args.put(1, val1);

                    LLVMValueRef val2 = root.getValue(
							compiler.typeData(field.type),
							extractField(
		                            root, object,
		                            voidPtr, offset
		                    ), "get_field_value"
                    );

                    args.put(1, val2);
                    root.track(LLVM.LLVMBuildCall2(
                            root.getBuilder(),
                            markObj.getType(),
                            markObj.getDirect(),
                            args, 2,
                            ""
                    ));
                } else {
//	                throw new RuntimeException("TODO");
                }
            }

            builder.ret();
        }

        {
            // TODO: locate finalize function (if present)
            data.finalizeFunc = module.rt == null ? null : module.rt.rtNoop.getCompilerData();
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
		                root.getIntType(64),
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

		if (module.gc != null) {
			LLVMValueRef gc = root.track(LLVM.LLVMBuildCall2(
					root.getBuilder(),
					((FunctionBuilder) module.gc.rtGlobalGC.getCompilerData()).getType(),
					((FunctionBuilder) module.gc.rtGlobalGC.getCompilerData()).getDirect(),
					noArg, 0,
					"get_gc"
			));
			
			allocArgs.put(0, gc);
			allocArgs.put(1, root.integer(8 * 2, 32));
			
			LLVMValueRef classValue = root.track(LLVM.LLVMBuildCall2(
					root.getBuilder(),
					((FunctionBuilder) module.gc.gcAlloc.getCompilerData()).getType(),
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
				root.setValue(root.pointerType(root.VOID), ptrptr, root.integer(0, 32), ptr);
			}
			{
				LLVMValueRef ptr = root.ptrCast(
						finalizeObj.getDirect(),
						root.pointerType(root.VOID),
						"to_ptr"
				);
				root.setValue(root.pointerType(root.VOID), ptrptr, root.integer(1, 32), ptr);
			}
		}

        mbranch.jump(abranch);

        abranch.enableBuilding();
		LLVMTypeRef voidPtr = root.pointerType(root.pointerType(root.VOID));
        abranch.ret(root.getValue(voidPtr, classObject, "get_class"));
    }
}
