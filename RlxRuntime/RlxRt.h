#include "pch.h"
#include "intrinsics.h"

namespace ralux {
    extern "C++" {
        // core types
        struct EXPORT rlxClass;
        struct EXPORT rlxObj;

        // gc types
        struct EXPORT rlxGCData;
        struct EXPORT rlxStandardGCData;
        struct EXPORT rlxGC;

        typedef rlxClass* RlxCls;
        typedef rlxObj* RlxObj;
        typedef rlxGC* RlxGC;

        // static variables
        // static rlxGC* tfc_ralux_runtime_GC_GLOBAL_GC;
    }

    extern "C" {
        // runtime methods
        EXPORT EXPORT_FUNC bool __rlxrt_mark_obj(std::unordered_set<RlxObj> refd, RlxObj obj);
        EXPORT EXPORT_FUNC void __rlxrt_obj_created(RlxObj obj, RlxGC gc);
        EXPORT EXPORT_FUNC void __rlxrt_free_obj(RlxObj obj);
        EXPORT EXPORT_FUNC long long __rlxrt_get_pointer(RlxObj obj);
        EXPORT EXPORT_FUNC int __rlxrt_default_hash(RlxObj obj);

        // gc class functions
        EXPORT EXPORT_FUNC void* tfc_ralux_runtime_GC_allocate(RlxGC gc, int32_t size);
        EXPORT EXPORT_FUNC void* tfc_ralux_runtime_GC_allocateObj(RlxGC gc, int32_t size);
        EXPORT EXPORT_FUNC void tfc_ralux_runtime_GC_collect(RlxGC gc);
        EXPORT EXPORT_FUNC auto __rlxrt_get_global_gc() -> RlxGC;

        // initialization functions
        EXPORT EXPORT_FUNC void __rlxrt_init();
    }
}
