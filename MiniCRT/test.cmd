clang -emit-llvm -S ./test.cpp -o ./test/test.ll -nostdlib -nodefaultlibs -fdata-sections -ffunction-sections -fvisibility=default -fwhole-program-vtables -fstrict-vtable-pointers -flto -funroll-loops -fno-rtti -fmerge-all-constants -fomit-frame-pointer -fno-exceptions -ffast-math -fassociative-math -freciprocal-math -ffp-contract=fast -fvectorize -fslp-vectorize -O3
clang -o ./test/test.exe ./test/test.ll
cd test/
test.exe
