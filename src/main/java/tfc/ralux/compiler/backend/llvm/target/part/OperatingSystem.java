package tfc.ralux.compiler.backend.llvm.target.part;

import java.util.ArrayList;
import java.util.List;

public record OperatingSystem(String name) {
    private static final List<OperatingSystem> vendors = new ArrayList<>();

    public static final OperatingSystem LINUX = new OperatingSystem("linux");
    public static final OperatingSystem WINDOWS = new OperatingSystem("windows");
    public static final OperatingSystem DARWIN = new OperatingSystem("darwin");
    public static final OperatingSystem FREEBSD = new OperatingSystem("freebsd");
    public static final OperatingSystem NETBSD = new OperatingSystem("netbsd");
    public static final OperatingSystem OPENBSD = new OperatingSystem("openbsd");
    public static final OperatingSystem ANDROID = new OperatingSystem("android");
    public static final OperatingSystem CYGWIN = new OperatingSystem("cygwin");
    public static final OperatingSystem HAIKU = new OperatingSystem("haiku");
    public static final OperatingSystem QNX = new OperatingSystem("qnx");
    public static final OperatingSystem VXWORKS = new OperatingSystem("vxworks");
    public static final OperatingSystem SOLARIS = new OperatingSystem("solaris");
    public static final OperatingSystem ILLUMOS = new OperatingSystem("illumos");

    public OperatingSystem(String name) {
        this.name = name;
        vendors.add(this);
    }

    public OperatingSystem[] values() {
        return vendors.toArray(new OperatingSystem[0]);
    }
}
