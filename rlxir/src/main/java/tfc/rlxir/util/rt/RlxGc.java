package tfc.rlxir.util.rt;

import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxEnclosure;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.RlxModule;
import tfc.rlxir.typing.RlxTypes;

import java.util.Arrays;

public class RlxGc {
    public final RlxCls cls;
    public final RlxFunction gcAlloc = new RlxFunction(
            RlxFunction.ACC_PUBLIC,
            false, false,
            new RlxEnclosure(
                    true,
                    RlxTypes.VOID_PTR,
                    "allocate",
                    Arrays.asList(RlxTypes.VOID_PTR, RlxTypes.INT)
            )
    ).exportName("tfc_ralux_runtime_GC_allocate");
    public final RlxFunction gcCollect = new RlxFunction(
            RlxFunction.ACC_PUBLIC,
            false, false,
            new RlxEnclosure(
                    true,
                    RlxTypes.VOID_PTR,
                    "collect",
                    Arrays.asList(RlxTypes.VOID_PTR, RlxTypes.INT)
            )
    ).exportName("tfc_ralux_runtime_GC_collect");

    public RlxGc(RlxCls cls) {
        this.cls = cls;
        cls.addFunction(gcAlloc);
        cls.addFunction(gcCollect);
    }

    public static RlxGc inject(RlxModule module) {
        RlxCls gc = new RlxCls("tfc.ralux.runtime", "GC");
        RlxGc gcObj = new RlxGc(gc);
        module.addClass(gc);
        return gcObj;
    }
}
