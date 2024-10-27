package compiler.compiler;

import compiler.compiler.analysis.Scope;
import compiler.compiler.analysis.Type;
import compiler.compiler.analysis.Value;
import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.parse.RaluxParser;
import tfc.ralux.compiler.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class CallCompiler {
    public static Value compileCall(BuilderRoot root, RaluxFunctionConsumer consumer, Scope currentScope, RaluxParser.CallContext ctx) {
        Compiler compiler = consumer.compiler;
        if (ctx.getChildCount() == 1) {
            RaluxParser.Method_callContext mcall = (RaluxParser.Method_callContext) ctx.getChild(0);
            if (mcall.getChildCount() == 4) {
                String funcName = mcall.getChild(0).getText();
                RaluxParser.ParamsContext params = (RaluxParser.ParamsContext) mcall.getChild(2);
                List<Value> args = new ArrayList<>();
                for (int i = 0; i < params.getChildCount(); i += 2) {
                    args.add(new Value(
                            root, consumer, currentScope,
                            (RaluxParser.ExprContext) params.getChild(i)
                    ));
                }
                Pair<FunctionBuilder, Type> toCall = compiler.getFunction(consumer, funcName, args);
                PointerPointer argsPtrPtr = root.track(new PointerPointer(args.size()));
                for (int i = 0; i < args.size(); i++)
                    argsPtrPtr.put(i, args.get(i).llvm);
                LLVMValueRef valueRef = root.track(LLVM.LLVMBuildCall(
                        root.getBuilder(),
                        toCall.getFirst().getDirect(),
                        argsPtrPtr,
                        args.size(),
                        "call_" + funcName
                ));
                return new Value(
                        root, consumer,
                        valueRef, toCall.getSecond()
                );
            }
            throw new RuntimeException("TODO");
        }
        throw new RuntimeException("TODO");
    }
}
