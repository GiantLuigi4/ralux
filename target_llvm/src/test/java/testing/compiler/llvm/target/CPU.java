package testing.compiler.llvm.target;

import java.util.ArrayList;
import java.util.List;

public record CPU(String name) {
    private static final List<CPU> vendors = new ArrayList<>();

    public static final CPU X86 = new CPU("x86");
    public static final CPU X86_64 = new CPU("x86_64");
    public static final CPU ARM = new CPU("arm");
    public static final CPU ARM64 = new CPU("aarch64");
    public static final CPU MIPS = new CPU("mips");
    public static final CPU MIPS64 = new CPU("mips64");
    public static final CPU POWERPC = new CPU("ppc");
    public static final CPU POWERPC64 = new CPU("ppc64");
    public static final CPU RISC_V = new CPU("riscv");
    public static final CPU SPARC = new CPU("sparc");
    public static final CPU ITANIUM = new CPU("ia64");
    public static final CPU AARCH32 = new CPU("arm"); // For 32-bit ARM
    public static final CPU AARCH64 = new CPU("aarch64"); // For 64-bit ARM
    public static final CPU Z_ARCHITECTURE = new CPU("s390x");
    public static final CPU S390 = new CPU("s390");
    public static final CPU AVR = new CPU("avr");
    public static final CPU R8C = new CPU("r8c");
    public static final CPU RL78 = new CPU("rl78");
    public static final CPU H8 = new CPU("h8300");
    public static final CPU HEXAGON = new CPU("hexagon");
    public static final CPU WEBASSEMBLY_32 = new CPU("wasm32");
    public static final CPU WEBASSEMBLY_64 = new CPU("wasm64");
    public static final CPU M68K = new CPU("m68k");
    public static final CPU GENERIC = new CPU("generic");

    public CPU(String name) {
        this.name = name;
        vendors.add(this);
    }

    public CPU[] values() {
        return vendors.toArray(new CPU[0]);
    }
}
