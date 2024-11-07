package testing.compiler.llvm.compiler.analysis;

import org.bytedeco.llvm.LLVM.LLVMValueRef;
import testing.compiler.llvm.root.BuilderRoot;

public class Variable {
    public LLVMValueRef llvm;
    Type type;
    // TODO: scope nonsense (and I really mean nonsense, 'cuz it is gonna be some really real nonsense)
    Value currentValue;
    BuilderRoot root;

    public Variable(BuilderRoot root, Type type) {
        this.root = root;
        this.type = type;
    }

    public void setValue(Scope currentScope, Value value) {
        currentValue = value;
        root.setValue(llvm, type.cast(root, value));
    }

    public Type getType() {
        return type;
    }

    public Value getValue() {
        return new Value(
                root, null,
                root.getValue(llvm, "get_value"), type
        );
    }
}
