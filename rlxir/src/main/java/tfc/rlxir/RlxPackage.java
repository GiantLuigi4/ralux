package tfc.rlxir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RlxPackage {
    public HashMap<String, RlxCls> classes = new HashMap<>();

    public RlxCls getClass(String name) {
        return classes.get(name);
    }
}
