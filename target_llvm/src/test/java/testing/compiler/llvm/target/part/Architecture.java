package testing.compiler.llvm.target.part;

import java.util.ArrayList;
import java.util.List;

public record Architecture(String name) {
    private static final List<Architecture> architectures = new ArrayList<>();

    public static final Architecture AARCH64 = new Architecture("aarch64");
    public static final Architecture AARCH64_32 = new Architecture("aarch64_32");
    public static final Architecture AARCH64_BE = new Architecture("aarch64_be");
    public static final Architecture AMDGCN = new Architecture("amdgcn");
    public static final Architecture ARM = new Architecture("arm");
    public static final Architecture ARM64 = new Architecture("arm64");
    public static final Architecture ARM64_32 = new Architecture("arm64_32");
    public static final Architecture ARMBE = new Architecture("armeb");
    public static final Architecture AVR = new Architecture("avr");
    public static final Architecture BPF = new Architecture("bpf");
    public static final Architecture BPFEB = new Architecture("bpfeb");
    public static final Architecture BPFEL = new Architecture("bpfel");
    public static final Architecture HEXAGON = new Architecture("hexagon");
    public static final Architecture LANAI = new Architecture("lanai");
    public static final Architecture LOONGARCH32 = new Architecture("loongarch32");
    public static final Architecture LOONGARCH64 = new Architecture("loongarch64");
    public static final Architecture MIPS = new Architecture("mips");
    public static final Architecture MIPS64 = new Architecture("mips64");
    public static final Architecture MIPS64EL = new Architecture("mips64el");
    public static final Architecture MIPSEL = new Architecture("mipsel");
    public static final Architecture MSP430 = new Architecture("msp430");
    public static final Architecture NVPTX = new Architecture("nvptx");
    public static final Architecture NVPTX64 = new Architecture("nvptx64");
    public static final Architecture PPC32 = new Architecture("ppc32");
    public static final Architecture PPC32LE = new Architecture("ppc32le");
    public static final Architecture PPC64 = new Architecture("ppc64");
    public static final Architecture PPC64LE = new Architecture("ppc64le");
    public static final Architecture R600 = new Architecture("r600");
    public static final Architecture RISC32 = new Architecture("riscv32");
    public static final Architecture RISC64 = new Architecture("riscv64");
    public static final Architecture SPARC = new Architecture("sparc");
    public static final Architecture SPARCLE = new Architecture("sparcel");
    public static final Architecture SPARCV9 = new Architecture("sparcv9");
    public static final Architecture SYSTEMZ = new Architecture("systemz");
    public static final Architecture THUMB = new Architecture("thumb");
    public static final Architecture THUMBEB = new Architecture("thumbeb");
    public static final Architecture VE = new Architecture("ve");
    public static final Architecture WASM32 = new Architecture("wasm32");
    public static final Architecture WASM64 = new Architecture("wasm64");
    public static final Architecture X86 = new Architecture("x86");
    public static final Architecture X86_64 = new Architecture("x86_64");
    public static final Architecture XCORE = new Architecture("xcore");

    public Architecture(String name) {
        this.name = name;
        architectures.add(this);
    }

    public Architecture[] values() {
        return architectures.toArray(new Architecture[0]);
    }
}
