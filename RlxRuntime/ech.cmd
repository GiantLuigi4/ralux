clang -c ./RlxRt.cpp -o ./x64/RlxRt.obj -target x86_64-apple-windows-uclibc -fno-exceptions -fno-rtti -nostdlib -nodefaultlibs -fsanitize-minimal-runtime -O3 -nostdlibinc -std=c++20
llvm-ar rc ./x64/RlxRt.lib ./x64/RlxRt.obj
