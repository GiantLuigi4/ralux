package testing.compiler.llvm.compiler.cache;

import testing.compiler.llvm.FunctionBuilder;
import testing.compiler.llvm.compiler.analysis.Type;

import java.util.List;

public class CachedFunction {
    FunctionBuilder functionBuilder;
    Type returnType;
    List<Type> args;
    boolean varg;

    public CachedFunction(FunctionBuilder functionBuilder, Type returnType, List<Type> args) {
        this.functionBuilder = functionBuilder;
        this.returnType = returnType;
        this.args = args;
        this.varg = !args.isEmpty() && args.get(args.size() - 1).isVarArg();
    }

    public boolean check(List<Type> refArgs) {
        if (!varg) if (refArgs.size() != args.size()) return false;
        else if (refArgs.size() < (args.size() - 1)) return false;

        // TODO: check var-args
        for (int i = 0; i < Math.min(refArgs.size(), args.size()); i++) {
            if (!refArgs.get(i).canAutoCast(args.get(i))) {
                return false;
            }
        }

        return true;
    }
}
