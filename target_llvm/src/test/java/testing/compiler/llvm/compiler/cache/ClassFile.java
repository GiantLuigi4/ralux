package testing.compiler.llvm.compiler.cache;

import testing.compiler.llvm.compiler.RaluxFunctionConsumer;
import testing.compiler.llvm.compiler.analysis.Type;
import testing.compiler.llvm.FunctionBuilder;
import tfc.ralux.compiler.parse.RaluxParser;
import tfc.ralux.compiler.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class ClassFile {
    String pkg;
    String name;

    public ClassFile(String pkg, String name) {
        this.pkg = pkg;
        this.name = name;
    }

    public String getQualifier() {
        if (pkg == null) return name;
        return pkg + "." + name;
    }

    List<Pair<RaluxParser.BodyContext, RaluxFunctionConsumer>> functions = new ArrayList<>();
    HashMap<String, List<CachedFunction>> functionCache = new HashMap<>();

    public void addFunction(RaluxFunctionConsumer functionConsumer, RaluxParser.BodyContext context) {
        this.functions.add(Pair.of(context, functionConsumer));
    }

    public void iterateFunctions(Consumer<Pair<RaluxParser.BodyContext, RaluxFunctionConsumer>> consumer) {
        for (Pair<RaluxParser.BodyContext, RaluxFunctionConsumer> function : functions) {
            consumer.accept(function);
        }
    }

    public void addFuncByParams(FunctionBuilder func, String name, Type typ, List<Type> args) {
        List<CachedFunction> list = functionCache.get(name);
        if (list == null) {
            list = new ArrayList<>();
            functionCache.put(name, list);
        }
        list.add(new CachedFunction(func, typ, args));
    }

    public CachedFunction getFunction(String name, List<Type> args) {
        for (CachedFunction cachedFunction : functionCache.get(name)) {
            if (cachedFunction.check(args))
                return cachedFunction;
        }
        throw new RuntimeException("Could not find function " + name);
    }

    public String getPackage() {
        return pkg;
    }

    public String getName() {
        return name;
    }
}
