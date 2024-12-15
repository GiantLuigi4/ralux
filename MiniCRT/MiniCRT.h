#pragma once

// #define size_t __int64
// #include "mem.h"
// #undef size_t
#include <stdlib.h>
#define DEBUG
#define bool _Bool

#undef size_t
#define size_t __int32
#include "mem.h"
#undef size_t

#ifdef DEBUG
#include "prints.h"
#endif
