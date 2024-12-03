clang -c ./RlxRt.cpp -o ./x64/RlxRt.obj -target x86_64-apple-windows-uclibc -fno-exceptions -fno-rtti -nostdlib -nodefaultlibs -fsanitize-minimal-runtime -std=c++20 -fno-PIC -fno-PIE -fno-modules -fno-rwpi -fno-ropi -fmerge-all-constants -O3 -Xclang -no-opaque-pointers
clang -emit-llvm -fverbose-asm -S -g ./RlxRt.cpp -o ./x64/RlxRt.ll -target x86_64-apple-windows-uclibc -fno-exceptions -Wno-ignored-attributes -fno-inline -Og -fno-discard-value-names -Xclang -no-opaque-pointers
clang -emit-llvm -S -g ./RlxRt.cpp -o ./x64/RlxRtSlim.ll -target x86_64-apple-windows-uclibc -fno-exceptions -Wno-ignored-attributes -fno-inline -Og -fno-discard-value-names -Xclang -no-opaque-pointers
clang -emit-llvm -S -g ./RlxRt.cpp -o ./x64/RlxRtO3.ll -target x86_64-apple-windows-uclibc -fno-exceptions -Wno-ignored-attributes -fno-inline -O3 -fno-discard-value-names -Xclang -no-opaque-pointers
llvm-ar rc ./x64/RlxRt.lib ./x64/RlxRt.obj
