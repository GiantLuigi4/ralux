#include "RlxRt.h"
#include "pch.h"
#include "rtset.h"
#include "list.h"
#include "allocator.h"
#include "hash_set.h"
#include "array_set.h"

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
    void (*__rlxrt_gc_track)(RlxObj, ArrayList);
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
    struct iterable_set* roots;
    struct iterable_set* allObjs;
};

// TODO: memory overhead could be reduced by 8 bytes per object if the functions are stored in an object that gets stored to the class instance
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
    ArrayList fref = listCreate();

    printf("roots %i\n", gc->roots->size);
    printf("objects %i\n", gc->allObjs->size);

    int numVisited = 0;
    struct set_iterator* iterator = gc->roots->ops->createIterator(gc->roots);
    while (iterator->hasNext(iterator)) {
        RlxObj root = (RlxObj) iterator->current(iterator);
        struct rlxGCData* inf = root->gc_info;
        inf->visited = true;
        root->clazz->__rlxrt_gc_track(root, fref);
        numVisited++;
        iterator->next(iterator);

        // TODO: probably should walk the object tree before continuing to minimize allocated working memory
    }

    if (listSize(fref) != 0) {
        ArrayList frefSwap = listCreate();
        while (listSize(fref) != 0) {
            for (int i = 0; i < listSize(fref); i++) {
                RlxObj root = listGet(fref, i);

                struct rlxGCData* inf = root->gc_info;
                bool wasVisited = inf->visited;
                if (!wasVisited) {
                    root->clazz->__rlxrt_gc_track(root, frefSwap);
                    inf->visited = true;
                    numVisited++;
                }
            }
            listClear(fref);
            ArrayList temp = fref;
            fref = frefSwap;
            frefSwap = temp;
        }
        listFree(frefSwap);
    }
    listFree(fref);

    printf("visited %i\n", numVisited);

    ArrayList freed = listCreate();
    iterator = gc->allObjs->ops->createIterator(gc->allObjs);
    while (iterator->hasNext(iterator)) {
        RlxObj obj = (RlxObj) iterator->current(iterator);
        struct rlxGCData* inf = obj->gc_info;
        bool wasVisited = inf->visited;
        if (!wasVisited)
            listAdd(freed, obj);
        inf->visited = false;
        iterator->next(iterator);
    }
    printf("freeing %i\n", listSize(freed));

    // TODO: in reality, I should go through with the frees first and do a single-pass consolidation
    // actually, under that logic, I shouldn't even need a working list for which objects should get removed
    // I suppose the "free" solution to tracking this is to null out the GC data of objects that have been freed
    // I can then in the consolidation pass check if the gc data is null, and if so, free the object itself and change the shift delta

    // go through in reverse order to minimize required shifting
    for (int i = listSize(freed) - 1; i >= 0; i--) {
//    for (int i = 0; i < listSize(freed); i++) {
        RlxObj obj = listGet(freed, i);

        struct iterable_set* set = gc->allObjs;
        set->ops->remove_element(set, obj);

        __rlxrt_free_obj(obj);
    }
    listFree(freed);

    printf("survived %i\n", gc->allObjs->size);
}

// runtime functions
EXPORT EXPORT_FUNC void __rlxrt_mark_obj(ArrayList freshRefs, RlxObj obj) {
    if (freshRefs != 0) {
        struct rlxGCData* inf = obj->gc_info;
        bool wasVisited = inf->visited;
        if (!wasVisited) {
            listAdd(freshRefs, obj);
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
    struct rlxStandardGCData* gc_data = rlx_malloc(sizeof(struct rlxStandardGCData));
    gc_data->tfc_ralux_runtime_GCData_ref = __rlxrt_noop;
    gc_data->tfc_ralux_runtime_GCData_deref = __rlxrt_noop;
    gc_data->visited = false;
    gc_data->scopeRefs = 1; // spoof a ref for safety
    obj->gc_info = (struct rlxGCData*) gc_data;
}

EXPORT EXPORT_FUNC void __rlxrt_obj_created(RlxObj obj, RlxGC gc) {
    struct rlxStandardGCData* gc_data = (struct rlxStandardGCData*) rlx_malloc(sizeof(struct rlxStandardGCData));
    gc_data->tfc_ralux_runtime_GCData_ref = __rlxrt_standard_ref;
    gc_data->tfc_ralux_runtime_GCData_deref = __rlxrt_standard_deref;
    gc_data->visited = false;
    gc_data->gc = gc;
    gc_data->scopeRefs = 0;
    obj->gc_info = (struct rlxGCData*) gc_data;

    struct iterable_set* set = gc_data->gc->allObjs;
    set->ops->add_element(set, obj);
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
        struct iterable_set* set = gc_data->gc->roots;
        set->ops->add_element(set, obj);
    }
}

EXPORT EXPORT_FUNC void __rlxrt_standard_deref(RlxObj obj) {
    STDGCD gc_data = (struct rlxStandardGCData*) obj->gc_info;
    gc_data->scopeRefs--;
    if (gc_data->scopeRefs == 0) {
        struct iterable_set* set = gc_data->gc->roots;
        set->ops->remove_element(set, obj);
    }
}

EXPORT EXPORT_FUNC void __rlxrt_noop(RlxObj obj) {
}

EXPORT EXPORT_FUNC void __rlxrt_noop2(RlxObj obj, ArrayList list) {
}

EXPORT EXPORT_FUNC void __rlxrt_init() {
    // signal(SIGSEGV, segfaultHandler);
    // signal(SIGABRT, segfaultHandler);
    // signal(SIGILL, segfaultHandler);
    // signal(SIGFPE, segfaultHandler);
    
    tfc_ralux_runtime_GC_GLOBAL_GC = calloc(1, sizeof(struct rlxGC));
    tfc_ralux_runtime_GC_GLOBAL_GC->roots = createArraySet(16);
    tfc_ralux_runtime_GC_GLOBAL_GC->allObjs = createArraySet(16);
    __rlxrt_init_gc();
}
