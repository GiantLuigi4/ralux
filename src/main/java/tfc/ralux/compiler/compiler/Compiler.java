package tfc.ralux.compiler.compiler;

import org.bytedeco.llvm.LLVM.LLVMPassManagerBuilderRef;
import tfc.ralux.compiler.compiler.analysis.Type;
import tfc.ralux.compiler.compiler.analysis.Value;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.bytedeco.llvm.LLVM.LLVMPassManagerRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.FunctionType;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.backend.llvm.root.ModuleRoot;
import tfc.ralux.compiler.parse.RaluxParser;
import tfc.ralux.compiler.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Compiler {
    // TODO: module should be named based upon project
    BuilderRoot root = new BuilderRoot("module");

    private void acceptHeader(RaluxParser.HeaderContext tree) {
        // TODO
        System.out.println(tree);
    }

    private void acceptClass(RaluxParser.ClassContext tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree node = tree.getChild(i);
            System.out.println(node.getPayload());
            if (node.getPayload() instanceof CommonToken token) {
                switch (token.getType()) {
                    case RaluxParser.MODIFIER -> {
                        System.out.println(node.getText());
                    }
                    case RaluxParser.C_TYPE -> {
                        System.out.println("CType");
                        System.out.println(node.getText());
                    }
                    case RaluxParser.WORD -> {
                        System.out.println("CName");
                        System.out.println(node.getText());
                    }
                    default -> throw new RuntimeException("Unexpected token: " + token);
                }
            } else {
                acceptBody((RaluxParser.C_bodyContext) node);
            }
        }
    }

    private void acceptBody(RaluxParser.C_bodyContext node) {
        // first and last token are { and }, so can be skipped
        for (int i = 1; i < node.getChildCount() - 1; i++) {
            ParseTree tree = node.getChild(i);
            switch (((RuleContext) tree.getPayload()).getRuleIndex()) {
                case RaluxParser.RULE_c_component -> {
                    switch (((RuleContext) tree.getChild(0)).getPayload().getRuleIndex()) {
                        case RaluxParser.RULE_method -> {
                            acceptMethod((RaluxParser.MethodContext) tree.getChild(0));
                        }
                        default -> throw new RuntimeException("Unexpected rule: " + tree.getChild(0));
                        // TODO: field
                    }
                }
                default -> throw new RuntimeException("Unexpected rule: " + tree);
            }
        }
    }

    private FunctionBuilder writeFunctionHeader(RaluxParser.Full_typeContext type, String name, RaluxParser.Def_paramsContext params) {
        return writeFunctionHeader(type, name, params, new Type[1], new Consumer[1]);
    }

    // TODO: should account for access, hierarchy, owners, function names, etc
    //       this is a lazy solution which will be slow
    List<Pair<Pair<String, List<Type>>, Pair<FunctionBuilder, Type>>> funcsByParams = new ArrayList<>();

    private FunctionBuilder writeFunctionHeader(RaluxParser.Full_typeContext type, String name, RaluxParser.Def_paramsContext params, Type[] outType, Consumer<RaluxFunctionConsumer>[] parameterInserter) {
        // TODO: write type&params
        Type typ = new Type(root, null, type);
        FunctionType funcType = new FunctionType(root, typ.llvm());

        List<Type> args = new ArrayList<>();
        {
            RaluxParser.Def_paramsContext paramsContext = params;
            RaluxParser.Full_typeContext typeCtx = null;
            for (int i = 0; i < paramsContext.getChildCount(); i++) {
                if (typeCtx == null) typeCtx = (RaluxParser.Full_typeContext) paramsContext.getChild(i);
                else {
                    Type typa;
                    funcType.withArgs(
                            (typa = new Type(
                                    root, null, // TODO: account for generics
                                    typeCtx
                            )).llvm()
                    );
                    args.add(typa);
                    typeCtx = null;
                    i++;
                }
            }
        }

        funcType = funcType.build();
        outType[0] = typ;
        parameterInserter[0] = (consumer) -> {
            RaluxParser.Def_paramsContext paramsContext = params;
            if (paramsContext.getChildCount() == 0) {
                return;
            }
            RaluxParser.Full_typeContext typeCtx = null;
            for (int i = 0; i < paramsContext.getChildCount(); i++) {
                if (typeCtx == null) typeCtx = (RaluxParser.Full_typeContext) paramsContext.getChild(i);
                else {
                    String varName = paramsContext.getChild(i).getText();
                    consumer.addParam(varName, new Type(
                            root, consumer,
                            typeCtx
                    ));
                    typeCtx = null;
                    i++;
                }
            }
        };

        FunctionBuilder func = root.function(
                name,
                funcType
        );
        funcsByParams.add(Pair.of(Pair.of(name, args), Pair.of(func, typ)));
        return func;
    }

    ArrayList<Pair<RaluxParser.BodyContext, RaluxFunctionConsumer>> functions = new ArrayList<>();

    private void acceptMethod(RaluxParser.MethodContext tree) {
        RaluxParser.Full_typeContext type = null;
        String name = null;
        RaluxParser.Def_paramsContext params = null;
        boolean built = false;

        for (int i = 0; i < tree.getChildCount(); i++) {
            ParseTree node = tree.getChild(i);

            if (node.getText().equals("(") || node.getText().equals(")")) {
                continue;
            }

            if (node.getPayload() instanceof CommonToken token) {
                switch (token.getType()) {
                    case RaluxParser.MODIFIER -> {
                        System.out.println(node.getText());
                    }
                    case RaluxParser.STATIC -> {
                        System.out.println(node.getText());
                    }
                    case RaluxParser.WORD -> {
                        System.out.println("MName");
                        name = node.getText();
                        System.out.println(name);
                    }
                    default -> throw new RuntimeException("Unexpected token: " + token);
                }
            } else {
                switch (((RuleContext) node).getRuleIndex()) {
                    case RaluxParser.RULE_full_type -> type = ((RaluxParser.Full_typeContext) node);
                    case RaluxParser.RULE_def_params -> params = ((RaluxParser.Def_paramsContext) node);
                    case RaluxParser.RULE_body -> {
                        built = true;
                        Type[] outType = new Type[1];
                        Consumer<RaluxFunctionConsumer>[] outParams = new Consumer[1];
                        FunctionBuilder builder = writeFunctionHeader(
                                type, name, params, outType, outParams
                        );
                        RaluxFunctionConsumer functionConsumer = new RaluxFunctionConsumer(root, builder, this, outType[0]);
                        outParams[0].accept(functionConsumer);
                        functions.add(Pair.of((RaluxParser.BodyContext) node, functionConsumer));
                    }
                    default -> throw new RuntimeException("Unexpected rule: " + node);
                }
            }
        }

        if (!built) {
            // stubs should be marked as built, since they're more akin to fields than methods
            FunctionBuilder builder = writeFunctionHeader(type, name, params);
        }
    }

    public void accept(RaluxParser.FileContext file) {
        for (int i = 0; i < file.getChildCount(); i++) {
            ParseTree tree = file.getChild(i);

            switch (((RuleContext) tree.getPayload()).getRuleIndex()) {
                case RaluxParser.RULE_header -> acceptHeader((RaluxParser.HeaderContext) tree);
                case RaluxParser.RULE_class -> acceptClass((RaluxParser.ClassContext) tree);
                default -> throw new RuntimeException("Unexpected rule: " + tree.getPayload());
            }
        }

        for (Pair<RaluxParser.BodyContext, RaluxFunctionConsumer> function : functions) {
            function.getSecond().buildRoot();
            function.getSecond().acceptBlock(function.getFirst());
            if (!root.getBlockBuilding().isTerminated()) root.getBlockBuilding().ret();
        }
    }

    public void dump() {
        root.dump();
    }

    public void optimize(int llvm, int rlx) {
        LLVMPassManagerBuilderRef builderRef = LLVM.LLVMPassManagerBuilderCreate();
        LLVM.LLVMPassManagerBuilderSetOptLevel(builderRef, llvm);

        LLVMPassManagerRef pass = LLVM.LLVMCreatePassManager();
        if (rlx >= 5) {
            LLVM.LLVMAddFunctionAttrsPass(pass);
            LLVM.LLVMPassManagerBuilderPopulateModulePassManager(builderRef, pass);
            LLVM.LLVMAddDeadArgEliminationPass(pass);
            LLVM.LLVMAddInternalizePass(pass, 1);
            LLVM.LLVMAddAlwaysInlinerPass(pass);
            LLVM.LLVMAddMergeFunctionsPass(pass);
            LLVM.LLVMAddFunctionInliningPass(pass);
            LLVM.LLVMAddAggressiveDCEPass(pass);
            LLVM.LLVMAddGlobalDCEPass(pass);
            LLVM.LLVMAddArgumentPromotionPass(pass);
            LLVM.LLVMAddPruneEHPass(pass);
            LLVM.LLVMPassManagerBuilderPopulateModulePassManager(builderRef, pass);
            LLVM.LLVMAddCalledValuePropagationPass(pass);
            root.hyperAggressiveOptimizer(false, pass);
            LLVM.LLVMAddStripSymbolsPass(pass);
            LLVM.LLVMAddLowerExpectIntrinsicPass(pass);
            LLVM.LLVMAddLowerConstantIntrinsicsPass(pass);
        } else {
            LLVM.LLVMPassManagerBuilderPopulateModulePassManager(builderRef, pass);
            if (rlx >= 4) {
                LLVM.LLVMAddFunctionAttrsPass(pass);
                root.hyperAggressiveOptimizer(false, pass);
            } else if (rlx >= 1) {
                LLVM.LLVMAddFunctionAttrsPass(pass);
                LLVM.LLVMAddCFGSimplificationPass(pass);
                LLVM.LLVMAddReassociatePass(pass);
                LLVM.LLVMAddLoopUnrollAndJamPass(pass);
                LLVM.LLVMAddReassociatePass(pass);
                LLVM.LLVMAddCFGSimplificationPass(pass);
            }
        }
        LLVM.LLVMRunPassManager(pass, root.getModule());
        LLVM.LLVMDisposePassManager(pass);
        LLVM.LLVMPassManagerBuilderDispose(builderRef);
    }

    public ModuleRoot getModule() {
        return root;
    }

    public Pair<FunctionBuilder, Type> getFunction(RaluxFunctionConsumer consumer, String funcName, List<Value> args) {
        loopFuncs:
        for (Pair<Pair<String, List<Type>>, Pair<FunctionBuilder, Type>> funcByParam : funcsByParams) {
            if (funcByParam.getFirst().getFirst().equals(funcName)) {
                List<Type> argTypes = funcByParam.getFirst().getSecond();

                // TODO: var-args
                if (argTypes.size() != args.size())
                    continue;

                for (int i = 0; i < args.size(); i++) {
                    if (!argTypes.get(i).equals(args.get(i).type)) {
                        continue loopFuncs;
                    }
                }

                return funcByParam.getSecond();
            }
        }
        throw new RuntimeException("Method not found " + funcName);
    }
}
