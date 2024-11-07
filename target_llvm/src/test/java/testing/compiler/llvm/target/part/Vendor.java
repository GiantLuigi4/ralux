package testing.compiler.llvm.target.part;

import java.util.ArrayList;
import java.util.List;

public record Vendor(String name) {
    private static final List<Vendor> vendors = new ArrayList<>();

    public static final Vendor GNU = new Vendor("gnu");
    public static final Vendor APPLE = new Vendor("apple");
    public static final Vendor UNKNOWN = new Vendor("unknown");
    public static final Vendor PC = new Vendor("pc");
    public static final Vendor IBM = new Vendor("ibm");
    public static final Vendor SUN = new Vendor("sun");
    public static final Vendor W64 = new Vendor("w64");
    public static final Vendor EMBEDDED = new Vendor("embedded");

    public Vendor(String name) {
        this.name = name;
        vendors.add(this);
    }

    public Vendor[] values() {
        return vendors.toArray(new Vendor[0]);
    }
}
