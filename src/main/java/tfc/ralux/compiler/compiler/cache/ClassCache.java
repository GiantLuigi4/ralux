package tfc.ralux.compiler.compiler.cache;

import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.compiler.analysis.Type;
import tfc.ralux.compiler.compiler.analysis.Value;
import tfc.ralux.compiler.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class ClassCache {
    protected HashMap<String, ClassFile> classes = new HashMap<>();

    public void addFile(ClassFile file) {
        classes.put(file.getQualifier(), file);
    }

    public void iterateFiles(Consumer<ClassFile> fileConsumer) {
        for (ClassFile value : classes.values()) {
            fileConsumer.accept(value);
        }
    }

    public Pair<FunctionBuilder, Type> findFunction(ClassFile generating, String funcName, List<Value> args) {
        // TODO: package lookup
        List<Type> argsTypes = new ArrayList<>(args.size());
        for (int i = 0; i < args.size(); i++)
            argsTypes.add(args.get(i).type);
        CachedFunction function = generating.getFunction(funcName, argsTypes);
        if (function != null) {
            return Pair.of(function.functionBuilder, function.returnType);
        }
        // TODO: display arg types
        throw new RuntimeException("Could not find function " + funcName);
    }
}
