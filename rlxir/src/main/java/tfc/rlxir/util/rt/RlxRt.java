package tfc.rlxir.util.rt;

import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxEnclosure;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.RlxModule;
import tfc.rlxir.typing.RlxTypes;

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
                    RlxTypes.VOID_PTR,
                    "__rlxrt_get_global_gc",
                    RlxTypes.EMPTY_LIST
            )
    ).exportName("__rlxrt_get_global_gc");

    public RlxRt(RlxCls rt) {
        this.cls = rt;
        rt.addFunction(rtInit);
        rt.addFunction(rtGlobalGC);
        rt.addFunction(rtObjCreated);
        rt.addFunction(rtFree);
    }

    public static RlxRt inject(RlxModule module, RlxGc gc) {
        RlxCls rt = new RlxCls(null, "!__rt__!");
        RlxRt rtObj = new RlxRt(rt);
        module.addClass(rt);
        return rtObj;
    }
}
