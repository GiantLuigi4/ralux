clang -c ./RlxRt.c -o ./x64/RlxRtHi.obj -target x86_64-apple-windows-ucrt -march=x86-64-v2 -mtune=generic -O3 -fno-use-cxa-atexit -fdata-sections -ffunction-sections -fvisibility=hidden -fmerge-all-constants -fwhole-program-vtables -fstrict-vtable-pointers -flto=full -fbuiltin
clang -c -emit-llvm -S ./RlxRt.c -o ./x64/RlxRtHi.ll -target x86_64-apple-windows-ucrt -march=x86-64-v2 -mtune=generic -O3 -fno-use-cxa-atexit -fdata-sections -ffunction-sections -fvisibility=hidden -fmerge-all-constants -fwhole-program-vtables -fstrict-vtable-pointers -flto=full -fbuiltin
llvm-ar rc ./x64/RlxRtHi.lib ./x64/RlxRtHi.obj

clang -c ./RlxRt.c -o ./x64/RlxRt.obj -target x86_64-apple-windows-ucrt -march=x86-64-v2 -mtune=generic -fmerge-all-constants -nostdlib -nodefaultlibs -ffreestanding -fno-use-cxa-atexit -fdata-sections -ffunction-sections -fvisibility=hidden -fwhole-program-vtables -fstrict-vtable-pointers -flto=full -fno-unroll-loops -fno-rtti -fmerge-all-constants -fomit-frame-pointer -fno-exceptions -mregparm=3 -ffast-math -fassociative-math -freciprocal-math -ffp-contract=fast -fvectorize -fslp-vectorize -fbuiltin -O3
clang -c -emit-llvm -S ./RlxRt.c -o ./x64/RlxRt.ll -target x86_64-apple-windows-ucrt -march=x86-64-v2 -mtune=generic -fmerge-all-constants -nostdlib -nodefaultlibs -ffreestanding -fno-use-cxa-atexit -fdata-sections -ffunction-sections -fvisibility=hidden -fwhole-program-vtables -fstrict-vtable-pointers -flto=full -fbuiltin -Xclang -O3
llvm-ar rc ./x64/RlxRt.lib ./x64/RlxRt.obj

clang -c ./RlxRt.c -o ./x64/RlxRtLo.obj -target x86_64-apple-windows-ucrt -march=x86-64-v2 -mtune=generic -flto=full -fbuiltin -O3
clang -c -emit-llvm -S ./RlxRt.c -o ./x64/RlxRtLo.ll -target x86_64-apple-windows-ucrt -march=x86-64-v2 -mtune=generic -flto=full -fbuiltin -Xclang -O3
llvm-ar rc ./x64/RlxRtLo.lib ./x64/RlxRtLo.obj
