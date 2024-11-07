package testing.compiler.llvm.compiler.cache;

import testing.compiler.llvm.FunctionBuilder;
import testing.compiler.llvm.compiler.analysis.Type;
import testing.compiler.llvm.compiler.analysis.Value;
import tfc.ralux.compiler.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class ClassCache {
    protected HashMap<String, ClassFile> classes = new HashMap<>();
    protected HashMap<String, List<ClassFile>> pkgs = new HashMap<>();

    public void addFile(ClassFile file) {
        classes.put(file.getQualifier(), file);
        List<ClassFile> files = pkgs.get(file.getPackage());
        if (files == null) {
            files = new ArrayList<>();
            pkgs.put(file.getPackage(), files);
        }
        files.add(file);
    }

    public void iterateFiles(Consumer<ClassFile> fileConsumer) {
        for (ClassFile value : classes.values()) {
            fileConsumer.accept(value);
        }
    }

    public Pair<FunctionBuilder, Type> findFunction(String owner, ClassFile generating, String funcName, List<Value> args) {
        List<ClassFile> samePkg = pkgs.get(generating.getPackage());
        boolean found = false;
        if (samePkg != null) {
            for (ClassFile classFile : samePkg) {
                if (classFile.getName().equals(owner)) {
                    generating = classFile;
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            generating = this.classes.get(owner);
            if (generating == null) {
                throw new RuntimeException("Could not resolve class " + owner);
            }
        }

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
