#include <string>
#include <unordered_set>

#if defined(__clang__)
    #define EXPORT __declspec(dllexport)
#elif defined(_MSC_VER)
    #define EXPORT __declspec(dllexport)
#endif

#define EXPORT_FUNC __stdcall
