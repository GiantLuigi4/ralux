package testing.compiler.llvm.target;

import testing.compiler.llvm.target.part.Architecture;
import testing.compiler.llvm.target.part.Environment;
import testing.compiler.llvm.target.part.OperatingSystem;
import testing.compiler.llvm.target.part.Vendor;

public record Target(Architecture arch, Vendor vendor, OperatingSystem os, Environment env) {
    public String toString() {
        return arch.name() + "-" + vendor.name() + "-" + os.name() + "-" + env.name();
    }
}
