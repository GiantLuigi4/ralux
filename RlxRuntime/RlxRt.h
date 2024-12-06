#pragma once
#include "pch.h"
#include "intrinsics.h"
#include "set.h"

#define SetT SimpleSet*

// core types
struct rlxClass;
struct rlxObj;

// gc types
struct rlxGCData;
struct rlxStandardGCData;
struct rlxGC;

typedef struct rlxClass* RlxCls;
typedef struct rlxObj* RlxObj;
typedef struct rlxGC* RlxGC;

// static variables
// static rlxGC* tfc_ralux_runtime_GC_GLOBAL_GC;

// runtime methods
EXPORT EXPORT_FUNC bool __rlxrt_mark_obj(SetT refd, RlxObj obj);
EXPORT EXPORT_FUNC void __rlxrt_obj_created(RlxObj obj, RlxGC gc);
EXPORT EXPORT_FUNC void __rlxrt_free_obj(RlxObj obj);
EXPORT EXPORT_FUNC long long __rlxrt_get_pointer(RlxObj obj);
EXPORT EXPORT_FUNC int __rlxrt_default_hash(RlxObj obj);

// ref counting methods
EXPORT EXPORT_FUNC void __rlxrt_ref(RlxObj obj);
EXPORT EXPORT_FUNC void __rlxrt_deref(RlxObj obj);
EXPORT EXPORT_FUNC void __rlxrt_standard_ref(RlxObj obj);
EXPORT EXPORT_FUNC void __rlxrt_standard_deref(RlxObj obj);
EXPORT EXPORT_FUNC void __rlxrt_noop(RlxObj obj);

// gc class functions
EXPORT EXPORT_FUNC void* tfc_ralux_runtime_GC_allocate(RlxGC gc, int size);
EXPORT EXPORT_FUNC void** tfc_ralux_runtime_GC_allocateObj(RlxGC gc, int size);
EXPORT EXPORT_FUNC void tfc_ralux_runtime_GC_collect(RlxGC gc);
EXPORT EXPORT_FUNC RlxGC __rlxrt_get_global_gc();

// initialization functions
EXPORT EXPORT_FUNC void __rlxrt_init();
