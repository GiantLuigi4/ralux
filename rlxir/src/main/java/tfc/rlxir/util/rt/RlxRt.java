package tfc.rlxir.util.rt;

import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxEnclosure;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.RlxModule;
import tfc.rlxir.typing.RlxTypes;
import tfc.rlxir.util.CompilerDataHolder;

import java.util.Arrays;

public class RlxRt {
    public final RlxCls cls;

    public final RlxFunction rtInit = new RlxFunction(
            RlxFunction.ACC_PUBLIC,
            true, true,
            new RlxEnclosure(
                    true,
                    RlxTypes.VOID,
                    "__rlxrt_init",
                    RlxTypes.EMPTY_LIST
            )
    ).exportName("__rlxrt_init");
    public final RlxFunction rtFree = new RlxFunction(
            RlxFunction.ACC_PUBLIC,
            true, true,
            new RlxEnclosure(
                    true,
                    RlxTypes.VOID,
                    "__rlxrt_free_obj",
                    Arrays.asList(RlxTypes.VOID_PTR)
            )
    ).exportName("__rlxrt_free_obj");
    public final RlxFunction rtObjCreated = new RlxFunction(
            RlxFunction.ACC_PUBLIC,
            true, true,
            new RlxEnclosure(
                    true,
                    RlxTypes.VOID,
                    "__rlxrt_obj_created",
                    Arrays.asList(RlxTypes.VOID_PTR)
            )
    ).exportName("__rlxrt_obj_created");
    public final RlxFunction rtGlobalGC = new RlxFunction(
            RlxFunction.ACC_PUBLIC,
            true, true,
            new RlxEnclosure(
                    true,
                    RlxTypes.VOID_PTR_PTR,
                    "__rlxrt_get_global_gc",
                    RlxTypes.EMPTY_LIST
            )
    ).exportName("__rlxrt_get_global_gc");
    public final RlxFunction rtMarkObj = new RlxFunction(
            RlxFunction.ACC_PUBLIC,
            true, true,
            new RlxEnclosure(
                    true,
                    RlxTypes.BOOLEAN,
                    "__rlxrt_mark_obj",
                    Arrays.asList(RlxTypes.VOID_PTR, RlxTypes.VOID_PTR)
            )
    ).exportName("__rlxrt_mark_obj");
    public final RlxFunction rtRef = new RlxFunction(
            RlxFunction.ACC_PUBLIC,
            true, true,
            new RlxEnclosure(
                    true,
                    RlxTypes.VOID,
                    "__rlxrt_ref",
                    Arrays.asList(RlxTypes.OBJ)
            )
    ).exportName("__rlxrt_ref");
    public final RlxFunction rtDeref = new RlxFunction(
            RlxFunction.ACC_PUBLIC,
            true, true,
            new RlxEnclosure(
                    true,
                    RlxTypes.VOID,
                    "__rlxrt_deref",
                    Arrays.asList(RlxTypes.OBJ)
            )
    ).exportName("__rlxrt_deref");

    public RlxRt(RlxCls rt) {
        this.cls = rt;
        rt.addFunction(rtInit);
        rt.addFunction(rtGlobalGC);
        rt.addFunction(rtObjCreated);
        rt.addFunction(rtMarkObj);
        rt.addFunction(rtFree);
        rt.addFunction(rtRef);
        rt.addFunction(rtDeref);
    }

    public static RlxRt inject(RlxModule module, RlxGc gc) {
        RlxCls rt = new RlxCls(null, "!__rt__!");
        RlxRt rtObj = new RlxRt(rt);
        module.addClass(rt);
        return rtObj;
    }
}
