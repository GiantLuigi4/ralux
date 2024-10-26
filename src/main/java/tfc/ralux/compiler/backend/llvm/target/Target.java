package tfc.ralux.compiler.backend.llvm.target;

import tfc.ralux.compiler.backend.llvm.target.part.Architecture;
import tfc.ralux.compiler.backend.llvm.target.part.Environment;
import tfc.ralux.compiler.backend.llvm.target.part.OperatingSystem;
import tfc.ralux.compiler.backend.llvm.target.part.Vendor;

public record Target(Architecture arch, Vendor vendor, OperatingSystem os, Environment env) {
    public String toString() {
        return arch.name() + "-" + vendor.name() + "-" + os.name() + "-" + env.name();
    }
}
