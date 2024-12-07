#pragma once
#include <malloc.h>
#include <stdio.h>
#include <stdbool.h>

// #include <signal.h>
// #include <csignal>
// #include <windows.h>
// #include <dbghelp.h>

#if defined(__clang__)
    #define EXPORT __declspec(dllexport)
#elif defined(_MSC_VER)
    #define EXPORT __declspec(dllexport)
#endif

#define EXPORT_FUNC __stdcall

#define internal __attribute__((always_inline)) __inline__
