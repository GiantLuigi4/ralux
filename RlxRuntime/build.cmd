clang -c ./RlxRt.c -o ./x64/RlxRt.obj -target x86_64-apple-windows-ucrt -fno-omit-frame-pointer -fno-inline -gdwarf -nostdlib -nodefaultlibs -std=c99 -O3
clang -c -emit-llvm -S ./RlxRt.c -o ./x64/RlxRt.ll -target x86_64-apple-windows-ucrt -fno-omit-frame-pointer -fno-inline -gdwarf -nostdlib -nodefaultlibs -std=c99 -O3 -Xclang -no-opaque-pointers

clang -c ./set.c -o ./x64/set.obj -target x86_64-apple-windows-ucrt -fno-omit-frame-pointer -fno-inline -gdwarf -nostdlib -nodefaultlibs -std=c99 -O3
clang -c -emit-llvm -S ./set.c -o ./x64/set.ll -target x86_64-apple-windows-ucrt -fno-omit-frame-pointer -fno-inline -gdwarf -nostdlib -nodefaultlibs -std=c99 -O3

clang -c ./intrinsics.c -o ./x64/intrinsics.obj -target x86_64-apple-windows-ucrt -fno-omit-frame-pointer -fno-inline -gdwarf -nostdlib -nodefaultlibs -std=c99 -O3
clang -c -emit-llvm -S ./intrinsics.c -o ./x64/intrinsics.ll -target x86_64-apple-windows-ucrt -fno-omit-frame-pointer -fno-inline -gdwarf -nostdlib -nodefaultlibs -std=c99 -O3

llvm-ar rc ./x64/RlxRt.lib ./x64/*.obj
