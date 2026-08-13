#include "RlxRt.h"
#include "pch.h"
#include "rtset.h"
#include "allocator.h"

// void segfaultHandler(int signal) {
//     std::cerr << "Segmentation fault caught! Signal: " << signal << std::endl;
//     exit(1);
// }

// void segfaultHandler(int sig) {
//     // puts("segfault");
//     // puts(std::to_string(sig).c_str());
//     fprintf(stderr, "Exception occurred\n");
//     
//     HANDLE process = GetCurrentProcess();
//     SymInitialize(process, NULL, TRUE);
//
//     void *stack[100];
//     WORD frames = CaptureStackBackTrace(0, 100, stack, NULL);
//
//     for (WORD i = 0; i < frames; i++) {
//         fprintf(stderr, "Frame %d: %p\n", i, stack[i]);
//     }
//
//     // SymCleanup(process);
//     abort();
// }

struct rlxGCData {
    void (*tfc_ralux_runtime_GCData_ref)(RlxObj);
    void (*tfc_ralux_runtime_GCData_deref)(RlxObj);
    bool visited;
};

struct rlxClass {
    void (*__rlxrt_gc_track)(RlxObj, SetT);
    void (*__rlxrt_gc_free)(RlxObj);
};

struct rlxObj {
    RlxCls clazz;
    struct rlxGCData* gc_info;
    int (*tfc_ralux_runtime_Object_hashCode)(RlxObj);
    // data goes here
};

struct rlxGC {
    RlxCls clazz;
    struct rlxGCData* gc_info;
    int (*tfc_ralux_runtime_Object_hashCode)(RlxObj);
    SetT roots;
    SetT allObjs;
};

struct rlxStandardGCData {
    void (*tfc_ralux_runtime_GCData_ref)(RlxObj obj);
    void (*tfc_ralux_runtime_GCData_deref)(RlxObj obj);
    bool visited;

    RlxGC gc;
    int scopeRefs;
};

static RlxGC tfc_ralux_runtime_GC_GLOBAL_GC;

// gc functions
EXPORT EXPORT_FUNC void* tfc_ralux_runtime_GC_allocate(RlxGC gc, int size) {
    return rlx_calloc(size);
}

// gc functions
EXPORT EXPORT_FUNC void** tfc_ralux_runtime_GC_allocateObj(RlxGC gc, int size, RlxCls clazz) {
    void** obj = rlx_malloc(size + sizeof(struct rlxObj));
    // long long base = (long long) obj;
    // base += 3 * 8;
    __builtin_memset(((byte*) obj) + 3 * 8, 0, size);

    obj[0] = clazz;
    obj[2] = __rlxrt_default_hash;
    __rlxrt_obj_created((RlxObj) obj, gc);
    return obj;
}

EXPORT EXPORT_FUNC void tfc_ralux_runtime_GC_collect(RlxGC gc) {
    SetT fref = createSet();

    printf("roots %i\n", setSize(gc->roots));
    printf("objects %i\n", setSize(gc->allObjs));

    int numVisited = 0;
    for (int i = 0; i < setSize(gc->roots); i++) {
        RlxObj root = setGet(gc->roots, i);
        root->clazz->__rlxrt_gc_track(root, fref);
        struct rlxGCData* inf = root->gc_info;
        inf->visited = true;
        numVisited++;
    }

    SetT frefSwap = createSet();
    while (setSize(fref) != 0) {
        for (int i = 0; i < setSize(fref); i++) {
            RlxObj root = setGet(fref, i);

            struct rlxGCData* inf = root->gc_info;
            bool wasVisited = inf->visited;
            if (!wasVisited) {
                root->clazz->__rlxrt_gc_track(root, frefSwap);
                inf->visited = true;
                numVisited++;
            }
        }
        clear(fref);
        SetT temp = fref;
        fref = frefSwap;
        frefSwap = temp;
    }
    setFree(frefSwap);
    setFree(fref);

    printf("visited %i\n", numVisited);

    SetT freed = createSet();
    for (int i = 0; i < setSize(gc->allObjs); i++) {
        RlxObj obj = setGet(gc->allObjs, i);
        struct rlxGCData* inf = obj->gc_info;
        bool wasVisited = inf->visited;
        if (!wasVisited)
            setAdd(freed, obj);
        inf->visited = false;
    }
    printf("freeing %i\n", setSize(freed));
    for (int i = setSize(freed) - 1; i >= 0; i--) {
        RlxObj obj = setGet(freed, i);
        setRemove(gc->allObjs, obj);
        __rlxrt_free_obj(obj);
    }
    setFree(freed);

    printf("survived %i\n", setSize(gc->allObjs));
}

// runtime functions
EXPORT EXPORT_FUNC void __rlxrt_mark_obj(SetT freshRefs, RlxObj obj) {
    if (freshRefs != 0) {
        struct rlxGCData* inf = obj->gc_info;
        bool wasVisited = inf->visited;
        if (!wasVisited) {
            add(freshRefs, obj);
        }
    }
}

EXPORT EXPORT_FUNC void __rlxrt_free_obj(RlxObj obj) {
    obj->clazz->__rlxrt_gc_free(obj);
    free(obj->gc_info);
    free(obj);
}

EXPORT EXPORT_FUNC long long __rlxrt_get_pointer(RlxObj obj) {
    return (long long) obj;
}

EXPORT EXPORT_FUNC RlxGC __rlxrt_get_global_gc() {
    return tfc_ralux_runtime_GC_GLOBAL_GC;
}

EXPORT EXPORT_FUNC int __rlxrt_default_hash(RlxObj obj) {
    return (int) obj;
}

// #pragma optimize("", off)
EXPORT EXPORT_FUNC void __rlxrt_init_gc() {
    RlxGC obj = tfc_ralux_runtime_GC_GLOBAL_GC;
    obj->tfc_ralux_runtime_Object_hashCode = __rlxrt_default_hash;
    void** gc_data = rlx_malloc(sizeof(struct rlxStandardGCData));
    gc_data[0] = __rlxrt_noop;
    gc_data[1] = __rlxrt_noop;
    obj->gc_info = gc_data;
}

EXPORT EXPORT_FUNC void __rlxrt_obj_created(RlxObj obj, RlxGC gc) {
    struct rlxStandardGCData* gc_data = (struct rlxStandardGCData*) rlx_malloc(sizeof(struct rlxStandardGCData));
    gc_data->tfc_ralux_runtime_GCData_ref = __rlxrt_standard_ref;
    gc_data->tfc_ralux_runtime_GCData_deref = __rlxrt_standard_deref;
    gc_data->visited = false;
    gc_data->gc = gc;
    gc_data->scopeRefs = 0;
    obj->gc_info = (struct rlxGCData*) gc_data;
    add(gc->allObjs, obj);
}
// #pragma optimize("", on)

EXPORT EXPORT_FUNC void __rlxrt_deref(RlxObj obj) {
    obj->gc_info->tfc_ralux_runtime_GCData_deref(obj);
}

EXPORT EXPORT_FUNC void __rlxrt_ref(RlxObj obj) {
    obj->gc_info->tfc_ralux_runtime_GCData_ref(obj);
}

typedef struct rlxStandardGCData* STDGCD;

EXPORT EXPORT_FUNC void __rlxrt_standard_ref(RlxObj obj) {
    STDGCD gc_data = (struct rlxStandardGCData*) obj->gc_info;
    gc_data->scopeRefs++;
    if (gc_data->scopeRefs == 1) {
        add(gc_data->gc->roots, obj);
    }
}

EXPORT EXPORT_FUNC void __rlxrt_standard_deref(RlxObj obj) {
    STDGCD gc_data = (struct rlxStandardGCData*) obj->gc_info;
    gc_data->scopeRefs--;
    if (gc_data->scopeRefs == 0) {
        erase(gc_data->gc->roots, obj);
    }
}

EXPORT EXPORT_FUNC void __rlxrt_noop(RlxObj obj) {
}

EXPORT EXPORT_FUNC void __rlxrt_init() {
    // signal(SIGSEGV, segfaultHandler);
    // signal(SIGABRT, segfaultHandler);
    // signal(SIGILL, segfaultHandler);
    // signal(SIGFPE, segfaultHandler);
    
    tfc_ralux_runtime_GC_GLOBAL_GC = calloc(1, sizeof(struct rlxGC));
    tfc_ralux_runtime_GC_GLOBAL_GC->roots = createSet();
    tfc_ralux_runtime_GC_GLOBAL_GC->allObjs = createSet();
    __rlxrt_init_gc();
}
