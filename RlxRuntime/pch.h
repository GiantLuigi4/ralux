#include <cstdlib>
#include <unordered_set>
#include <vector>

#ifdef __clang__
    #define EXPORT __declspec(dllexport) __attribute__((visibility("default")))
#elifdef _MSC_VER
    #define EXPORT __declspec(dllexport)
#endif
#define EXPORT_FUNC __fastcall
