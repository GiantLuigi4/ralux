#pragma once
#include "pch.h"

#if defined(_WIN64) || defined(_WIN32)

internal void* rlx_calloc(int size) {
    return calloc(1, size);
}

internal void* rlx_malloc(int size) {
    return malloc(size);
}

#endif
