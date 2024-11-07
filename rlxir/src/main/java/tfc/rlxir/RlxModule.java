package tfc.rlxir;

import tfc.rlxir.enumeration.LinkMode;

import java.util.ArrayList;
import java.util.List;

public class RlxModule {
    public LinkMode preferredLinkMode = LinkMode.PROGRAM;
    final String name;
    List<RlxCls> classes =  new ArrayList<>();

    public RlxModule(String name) {
        this.name = name;
    }

    public RlxModule(String name, LinkMode preferredLinkMode) {
        this.name = name;
        this.preferredLinkMode = preferredLinkMode;
    }

    public String getName() {
        return name;
    }

    public void addClass(RlxCls cls) {
        this.classes.add(cls);
    }

    public List<RlxCls> getClasses() {
        // TODO: read-only list
        return classes;
    }
}
