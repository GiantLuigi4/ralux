#pragma once

#include "extern.h"

export void memset(
    void* dst,
    char data,
    size_t size,
    bool unused
) {
    void** vppD = (void**)dst;

    char* charp = (char*)malloc(4);
    charp[0] = data;
    charp[1] = data;
    short* sp = (short*)charp;
    sp[1] = sp[0];
    void** vp = (void**)charp;

    size_t endFast = size >> 2;

    for (int i = 0; i < endFast; i++) {
        vppD[i] = vp[0];
    }

    char* bppD = (char*)dst;
    size_t endFastIdx = endFast << 2;
    size_t diff = size - endFastIdx;
    for (int i = endFastIdx; i < endFastIdx + diff; i++) {
        bppD[i] = data;
    }
    return;
}

export void memcpy(
    void* dst,
    void const* src,
    size_t size,
    bool unused
) {
    void** vppD = (void**)dst;
    void* const* vppS = (void* const*)src;
    size_t endFast = size >> 2;

    for (int i = 0; i < endFast; i++) {
        vppD[i] = (void*)vppS[i];
    }

    char* bppD = (char*)dst;
    const char* bppS = (const char*)src;
    size_t endFastIdx = endFast << 2;
    size_t diff = size - endFastIdx;
    for (int i = endFastIdx; i < endFastIdx + diff; i++) {
        bppD[i] = bppS[i];
    }
    return;
}

export void memmove(
    void* dst,
    void const* src,
    size_t size,
    bool unused
) {
    if (dst < src) {
        void** vppD = (void**)dst;
        void* const* vppS = (void* const*)src;
        size_t endFast = size >> 2;

        for (int i = 0; i < endFast; i++) {
            vppD[i] = (void*)vppS[i];
        }

        char* bppD = (char*)dst;
        const char* bppS = (const char*)src;
        size_t endFastIdx = endFast << 2;
        size_t diff = size - endFastIdx;
        for (int i = endFastIdx; i < endFastIdx + diff; i++) {
            bppD[i] = bppS[i];
        }
        return;
    }

    void** vppD = (void**)dst;
    void* const* vppS = (void* const*)src;
    size_t endFast = size >> 2;

    for (int i = endFast - 1; i >= 0; i--) {
        vppD[i] = (void*)vppS[i];
    }

    char* bppD = (char*)dst;
    const char* bppS = (const char*)src;
    size_t endFastIdx = endFast << 2;
    size_t diff = size - endFastIdx;
    for (int i = diff - 1; i >= 0; i--) {
        bppD[i] = bppS[i];
    }
    return;
}
