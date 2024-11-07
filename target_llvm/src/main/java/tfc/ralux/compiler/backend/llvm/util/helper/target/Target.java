package tfc.ralux.compiler.backend.llvm.util.helper.target;

import tfc.ralux.compiler.backend.llvm.util.helper.target.part.Architecture;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.Environment;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.OperatingSystem;
import tfc.ralux.compiler.backend.llvm.util.helper.target.part.Vendor;

public record Target(Architecture arch, Vendor vendor, OperatingSystem os, Environment env) {
    public String toString() {
        return arch.name() + "-" + vendor.name() + "-" + os.name() + "-" + env.name();
    }
}
