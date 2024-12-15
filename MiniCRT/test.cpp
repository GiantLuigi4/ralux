// #include <stdio.h>
// #include <stdlib.h>
//
// #include "MiniCRT.h"
// #include "malloc.h"
//
// int cmp(const void* left, const void* right, int count) {
//     const char* lchr = (const char*)left;
//     const char* rchr = (const char*)right;
//     for (int i = 0; i < count; i++) {
//         if (lchr[i] < rchr[i]) return -1;
//         if (lchr[i] > rchr[i]) return 1;
//     }
//     return 0;
// }
//
// void display(const char* name, const void* data, int count) {
//     printf("%s: ", name);
//
//     const char* dchr = (const char*)data;
//     for (int i = 0; i < count; i++) {
//         printf("%i ", (int)dchr[i]);
//     }
//
//     printf("\n");
// }
//
// void setRand(void* data, int count) {
//     char* dchr = (char*)data;
//     for (int i = 0; i < count; i++) {
//         dchr[i] = rand();
//     }
// }
//
// int main(void) {
//     puts("init");
//
//     int count = 33;
//     void* left = malloc(count);
//     setRand(left, count);
//     void* right = malloc(count);
//     setRand(right, count);
//
//     ((void**)right)[0] = (void*)0;
//     ((void**)right)[1] = (void*)1;
//
//     display("left", left, count);
//     display("right", right, count);
//     printf("cmp: %i\n", cmp(left, right, count));
//
//     printf("memcpy\n");
//     memcpy(left, right, count, 0);
//
//     display("left", left, count);
//     display("right", right, count);
//
//     printf("cmp: %i\n", cmp(left, right, count));
//
//     printf("memmov\n");
//     memmove(left, (void*) (((long long) left) + 4), count - 4, 0);
//
//     display("left", left, count);
//     display("right", right, count);
//
//     printf("memmov\n");
//     memmove((void*) (((long long) left) + 4), left, count - 4, 0);
//
//     display("left", left, count);
//     display("right", right, count);
//
//     return 0;
// }
