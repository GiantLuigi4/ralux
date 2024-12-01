#include "RlxRt.h"
#include "pch.h"

namespace ralux {
    extern "C++" {
        struct EXPORT rlxGCData {
            EXPORT_FUNC void tfc_ralux_runtime_GCData_ref(RlxObj);
            EXPORT_FUNC void tfc_ralux_runtime_GCData_deref(RlxObj);
        };

        struct EXPORT rlxClass {
            void (*__rlxrt_gc_track)(RlxObj, std::unordered_set<RlxObj>);
            void (*__rlxrt_gc_free)(RlxObj);
        };

        struct EXPORT rlxObj {
            size_t operator()(const RlxObj obj) const {
                return (size_t)obj->tfc_ralux_runtime_Object_hashCode(obj);
            }

            RlxCls clazz;
            rlxGCData* gc_info;
            int (*tfc_ralux_runtime_Object_hashCode)(RlxObj);
            // data goes here
        };

        struct EXPORT rlxGC : rlxObj {
            std::unordered_set<RlxObj> roots;
            std::unordered_set<RlxObj> allObjs;
        };

        struct EXPORT rlxStandardGCData : rlxGCData {
            int scopeRefs;
            RlxGC gc;

            EXPORT_FUNC void tfc_ralux_runtime_GCData_ref(RlxObj obj) {
                scopeRefs++;
                if (scopeRefs == 1)
                    gc->roots.insert(obj);
            }

            EXPORT_FUNC void tfc_ralux_runtime_GCData_deref(RlxObj obj) {
                this->scopeRefs--;
                if (scopeRefs == 0)
                    gc->roots.erase(obj);
            }
        };

        const RlxGC tfc_ralux_runtime_GC_GLOBAL_GC = new rlxGC();
    }


    extern "C" {
        // gc functions
        EXPORT EXPORT_FUNC void* tfc_ralux_runtime_GC_allocate(RlxGC gc, int32_t size) {
            return calloc(std::_Bit_cast<uint32_t>(size), 1);
        }
        
        // gc functions
        EXPORT EXPORT_FUNC void* tfc_ralux_runtime_GC_allocateObj(RlxGC gc, int32_t size) {
            void* data = tfc_ralux_runtime_GC_allocate(gc, size + sizeof(rlxObj));
            __rlxrt_obj_created((RlxObj) data, gc);
            static_cast<RlxObj>(data)->tfc_ralux_runtime_Object_hashCode = __rlxrt_default_hash;
            return data;
        }

        EXPORT EXPORT_FUNC void tfc_ralux_runtime_GC_collect(RlxGC gc) {
            std::unordered_set<RlxObj> refd;
            for (const RlxObj root : gc->roots)
                root->clazz->__rlxrt_gc_track(root, refd);
            for (const RlxObj obj : gc->allObjs) {
                if (refd.find(obj) == refd.end())
                    __rlxrt_free_obj(obj);
            }
        }

        // runtime functions
        EXPORT EXPORT_FUNC bool __rlxrt_mark_obj(std::unordered_set<RlxObj> refd, RlxObj obj) {
            if (refd.find(obj) != refd.end()) {
                refd.insert(obj);
                return false;
            }
            return true;
        }

        EXPORT EXPORT_FUNC void __rlxrt_free_obj(const RlxObj obj) {
            obj->clazz->__rlxrt_gc_free(obj);
            free(obj->gc_info);
            free(obj);
        }

        EXPORT EXPORT_FUNC long long __rlxrt_get_pointer(RlxObj obj) {
            return reinterpret_cast<long long>(obj);
        }

        EXPORT EXPORT_FUNC void __rlxrt_obj_created(const RlxObj obj, RlxGC gc) {
            rlxStandardGCData* gc_data = new rlxStandardGCData();
            gc_data->gc = gc;
            obj->gc_info = gc_data;
            gc_data->gc->allObjs.insert(obj);
        }

        EXPORT EXPORT_FUNC auto __rlxrt_get_global_gc() -> RlxGC {
            return tfc_ralux_runtime_GC_GLOBAL_GC;
        }

        EXPORT EXPORT_FUNC void __rlxrt_init() {
        }

        EXPORT EXPORT_FUNC int __rlxrt_default_hash(RlxObj obj) {
            return static_cast<int>(reinterpret_cast<long long>(obj));
        }
    }
}
