package tfc.rlxir.comphints.builtin;

import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.comphints.FunctionCompilerHint;
import tfc.rlxir.typing.GenericType;

public class PrimitiveTypesHint implements FunctionCompilerHint {
    String generic, name;

    @Override
    public void preprocess(RlxCls clazz, RlxFunction function) {
        function.defineGeneric(generic, new GenericType());
    }

    @Override
    public boolean process(RlxCls clazz, RlxFunction function) {
        throw new RuntimeException("TODO");
    }
}
