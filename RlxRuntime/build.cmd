clang -c ./RlxRt.cpp -o ./x64/RlxRt.obj -target x86_64-apple-windows-uclibc -fno-exceptions -fno-rtti -nostdlib -nodefaultlibs -fsanitize-minimal-runtime -std=c++20 -fno-PIC -fno-PIE -fno-modules -fno-rwpi -fno-ropi -fmerge-all-constants -O3
llvm-ar rc ./x64/RlxRt.lib ./x64/RlxRt.obj
