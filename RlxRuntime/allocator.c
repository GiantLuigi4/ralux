#include "allocator.h"

#if defined(_WIN64) || defined(_WIN32)

void* rlx_calloc(int size) {
    return calloc(1, size);
}

void* rlx_malloc(int size) {
    return malloc(size);
}

#endif
