package tfc.rlxir.comphints;

import tfc.rlxir.RlxCls;

public interface ClassCompilerHint {
    void preprocess(RlxCls clazz);

    void process(RlxCls clazz);
}
