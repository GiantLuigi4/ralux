package tfc.ralux.compiler.backend.llvm.util.helper.target.part;

import java.util.ArrayList;
import java.util.List;

public record Environment(String name) {
    private static final List<Environment> vendors = new ArrayList<>();

    public static final Environment GNU = new Environment("gnu");
    public static final Environment MSVC = new Environment("msvc");
    public static final Environment MUSL = new Environment("musl");
    public static final Environment NEWLIB = new Environment("newlib");
    public static final Environment WINDOWS = new Environment("windows");
    public static final Environment CYGWIN = new Environment("cygwin");
    public static final Environment ANDROID = new Environment("android");
    public static final Environment UCLIBC = new Environment("uclibc");
    public static final Environment NONE = new Environment("none");
    public static final Environment EABI = new Environment("eabi");
    public static final Environment EB = new Environment("eb");
    public static final Environment KERNEL = new Environment("kernel");
    public static final Environment CORE_CLR = new Environment("coreclr");

    public Environment(String name) {
        this.name = name;
        vendors.add(this);
    }

    public Environment[] values() {
        return vendors.toArray(new Environment[0]);
    }
}
