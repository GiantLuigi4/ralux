package tfc.rlxir.comphints;

import tfc.rlxir.RlxCls;
import tfc.rlxir.RlxFunction;

public interface FunctionCompilerHint {
    void preprocess(RlxCls clazz, RlxFunction function);

    /**
     * Processes the function
     * This may also remove the function or create new ones if necessary
     *
     * @param clazz    the owner of the function
     * @param function the function
     * @return whether the function was removed, or a function was added
     */
    boolean process(RlxCls clazz, RlxFunction function);
}
