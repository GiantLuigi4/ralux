#include "RlxRt.h"
#include "pch.h"
#include "rtset.h"

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

    RlxGC gc;
    int scopeRefs;
};

static RlxGC tfc_ralux_runtime_GC_GLOBAL_GC;

#pragma optimize("", off)
void** makeObj(int size) {
    // puts("c0");
    void* obj = malloc(size);
    // puts("c2");
    return obj;
}
#pragma optimize("", on)

// gc functions
EXPORT EXPORT_FUNC void* tfc_ralux_runtime_GC_allocate(RlxGC gc, int size) {
    return calloc(size, 1);
}

// gc functions
EXPORT EXPORT_FUNC void** tfc_ralux_runtime_GC_allocateObj(RlxGC gc, int size) {
    // puts("create");
    void** obj = makeObj(size + sizeof(struct rlxObj));
    // puts("created");

    obj[2] = __rlxrt_default_hash;
    // puts("hash_set");
    __rlxrt_obj_created((RlxObj) obj, gc);
    // puts("buffred");
    return obj;
}

EXPORT EXPORT_FUNC void tfc_ralux_runtime_GC_collect(RlxGC gc) {
    SetT refd = createSet();
    printf("roots %i\n", setSize(gc->roots));
    printf("objs %i\n", setSize(gc->allObjs));
    printf("Iteration time\n");
    for (int i = 0; i < setSize(gc->roots); i++) {
        printf("Obj%i\n", i);
        RlxObj root = setGet(gc->roots, i);
        // root->clazz->__rlxrt_gc_track(root, refd);
        __rlxrt_mark_obj(refd, root);
    }
    for (int i = 0; i < setSize(gc->allObjs); i++) {
        RlxObj obj = setGet(gc->allObjs, i);
        if (!contains(refd, obj))
            __rlxrt_free_obj(obj);
    }
    freeSet(refd);
}

// runtime functions
EXPORT EXPORT_FUNC bool __rlxrt_mark_obj(SetT refd, RlxObj obj) {
    if (!contains(refd, obj)) {
        add(refd, obj);
        return 0;
    }
    return 1;
}

EXPORT EXPORT_FUNC void __rlxrt_free_obj(RlxObj obj) {
    puts("Freeing object");
    // obj->clazz->__rlxrt_gc_free(obj);
    puts("Released");
    free(obj->gc_info);
    puts("Freed GC Info");
    free(obj);
    puts("Freed object");
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

#pragma optimize("", off)
EXPORT EXPORT_FUNC void __rlxrt_init_gc() {
    RlxGC obj = tfc_ralux_runtime_GC_GLOBAL_GC;
    obj->tfc_ralux_runtime_Object_hashCode = __rlxrt_default_hash;
    void** gc_data = calloc(1, sizeof(struct rlxStandardGCData));
    gc_data[0] = __rlxrt_noop;
    gc_data[1] = __rlxrt_noop;
    obj->gc_info = gc_data;
}
#pragma optimize("", on)

#pragma optimize("", off)
EXPORT EXPORT_FUNC void __rlxrt_obj_created(RlxObj obj, RlxGC gc) {
    void** gc_data = calloc(1, sizeof(struct rlxStandardGCData));
    gc_data[0] = __rlxrt_standard_ref;
    gc_data[1] = __rlxrt_standard_deref;
    gc_data[2] = gc;
    gc_data[3] = 0;
    // printf("alloc\n");
    // printf("obj ptr %lld\n", (long long) obj);
    // printf("gc_dat ptr %lld\n", (long long) gc_data);
    // printf("deref ptr %lld\n", (long long) gc_data[1]);
    obj->gc_info = (struct rlxGCData*) gc_data;
    add(gc->allObjs, obj);
    // puts("added");
}
#pragma optimize("", on)

EXPORT EXPORT_FUNC void __rlxrt_deref(RlxObj obj) {
    // printf("deref\n");
    // printf("obj ptr %lld\n", (long long) obj);
    // printf("gc_dat ptr %lld\n", (long long) obj->gc_info);
    // printf("deref ptr %lld\n", (long long) obj->gc_info->tfc_ralux_runtime_GCData_deref);
    obj->gc_info->tfc_ralux_runtime_GCData_deref(obj);
    // puts("Deref'd");
}

EXPORT EXPORT_FUNC void __rlxrt_ref(RlxObj obj) {
    // printf("ref\n");
    obj->gc_info->tfc_ralux_runtime_GCData_ref(obj);
    // puts("Ref'd");
}

typedef struct rlxStandardGCData* STDGCD;

EXPORT EXPORT_FUNC void __rlxrt_standard_ref(RlxObj obj) {
    STDGCD gc_data = (struct rlxStandardGCData*) obj->gc_info;
    gc_data->scopeRefs++;
    // printf("scopec: %i\n", gc_data->scopeRefs);
    if (gc_data->scopeRefs == 1) {
        // printf("Add Root\n");
        add(gc_data->gc->roots, obj);
    }
}

EXPORT EXPORT_FUNC void __rlxrt_standard_deref(RlxObj obj) {
    STDGCD gc_data = (struct rlxStandardGCData*) obj->gc_info;
    gc_data->scopeRefs--;
    // printf("scopec: %i\n", gc_data->scopeRefs);
    if (gc_data->scopeRefs == 0) {
        // printf("Remove root\n");
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
