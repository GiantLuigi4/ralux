package testing.compiler.llvm.target.part;

import java.util.ArrayList;
import java.util.List;

public record Template(String name) {
    private static final List<Template> vendors = new ArrayList<>();

    public Template(String name) {
        this.name = name;
        vendors.add(this);
    }

    public Template[] values() {
        return vendors.toArray(new Template[0]);
    }
}
