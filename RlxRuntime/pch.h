#pragma once
#include <malloc.h>
#include <stdio.h>
#include <stdbool.h>


#if defined(_WIN64) || defined(_WIN32)
    #include <windows.h>
#endif

#if defined(__clang__)
    #define EXPORT __declspec(dllexport)
#elif defined(_MSC_VER)
    #define EXPORT __declspec(dllexport)
#endif

#define EXPORT_FUNC __stdcall __attribute__((fastcall))

#define internal __attribute__((always_inline)) __inline__ __attribute__((fastcall))
