clang -c ./RlxRt.cpp -o ./x64/RlxRt.obj -target x86_64-apple-windows-uclibc -fno-exceptions -fno-rtti -nostdlib -nodefaultlibs -fsanitize-minimal-runtime -std=c++20 -fno-PIC -fno-PIE -fno-modules -fno-rwpi -fno-ropi -fmerge-all-constants -O3
clang -emit-llvm -fverbose-asm -S ./RlxRt.cpp -o ./x64/RlxRt.ll -target x86_64-apple-windows-uclibc -fno-exceptions -Wno-ignored-attributes -fno-inline -Og -g
clang -emit-llvm -S ./RlxRt.cpp -o ./x64/RlxRtSlim.ll -target x86_64-apple-windows-uclibc -fno-exceptions -Wno-ignored-attributes -fno-inline -Og -g
clang -emit-llvm -S ./RlxRt.cpp -o ./x64/RlxRtO3.ll -target x86_64-apple-windows-uclibc -fno-exceptions -Wno-ignored-attributes -fno-inline -O3 -g
llvm-ar rc ./x64/RlxRt.lib ./x64/RlxRt.obj
