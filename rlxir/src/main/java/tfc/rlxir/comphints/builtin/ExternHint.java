package tfc.rlxir.comphints.builtin;

import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;
import tfc.rlxir.comphints.ClassCompilerHint;
import tfc.rlxir.comphints.FieldCompilerHint;
import tfc.rlxir.comphints.FunctionCompilerHint;

public class ExternHint implements ClassCompilerHint, FunctionCompilerHint, FieldCompilerHint {
    String callConvention;
    String name;

    public ExternHint(String name) {
        this.callConvention = null;
        this.name = name;
    }

    public ExternHint(String convention, String name) {
        this.callConvention = convention;
        this.name = name;
    }

    @Override
    public void preprocess(RlxCls clazz) {
        throw new RuntimeException("TODO");
    }

    @Override
    public void process(RlxCls clazz) {
        throw new RuntimeException("TODO");
    }

    @Override
    public void preprocess(RlxCls clazz, RlxFunction function) {
        function.exportName(name);
    }

    @Override
    public boolean process(RlxCls clazz, RlxFunction function) {
        return false;
    }
}
