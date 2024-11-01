package tfc.ralux.compiler.compiler;

import org.bytedeco.llvm.LLVM.LLVMAttributeRef;
import org.bytedeco.llvm.LLVM.LLVMPassManagerBuilderRef;
import org.bytedeco.llvm.LLVM.LLVMValueRef;
import tfc.ralux.compiler.backend.llvm.helper.Util;
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
import tfc.ralux.compiler.compiler.cache.ClassCache;
import tfc.ralux.compiler.compiler.cache.ClassFile;
import tfc.ralux.compiler.parse.RaluxParser;
import tfc.ralux.compiler.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Compiler {
    // TODO: module should be named based upon project
    BuilderRoot root = new BuilderRoot("module");
    ClassFile generating;
    String pkg = null;

    private void acceptHeader(RaluxParser.HeaderContext tree) {
        // TODO
        System.out.println(tree);
        if (tree.getChild(0).getText().equals("pkg")) {
            RaluxParser.Named_typeContext pkgName = (RaluxParser.Named_typeContext) tree.getChild(1);
            pkg = pkgName.getText();
        } else {
            throw new RuntimeException("TODO");
        }
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
                        generating = new ClassFile(this.pkg, node.getText()); // TODO: package
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

        String mName = name;
        // TODO: should be when cExtern that it does this, not when "main"
        if (!name.equals("main")) {
            mName = this.generating.getQualifier() + "::" + name;
        }
        FunctionBuilder func = root.function(
                mName,
                funcType
        );
        generating.addFuncByParams(
                func, name,
                typ, args
        );
        return func;
    }

    ClassCache cache = new ClassCache();

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
                        generating.addFunction(functionConsumer, (RaluxParser.BodyContext) node);
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
        pkg = null;
        generating = null;

        for (int i = 0; i < file.getChildCount(); i++) {
            ParseTree tree = file.getChild(i);

            switch (((RuleContext) tree.getPayload()).getRuleIndex()) {
                case RaluxParser.RULE_header -> acceptHeader((RaluxParser.HeaderContext) tree);
                case RaluxParser.RULE_class -> acceptClass((RaluxParser.ClassContext) tree);
                default -> throw new RuntimeException("Unexpected rule: " + tree.getPayload());
            }
        }

        cache.addFile(generating);
    }

    public void buildModule() {
        cache.iterateFiles((classFile) -> {
            generating = classFile;
            System.out.println("Compiling: " + classFile.getName());
            classFile.iterateFunctions((function) -> {
                System.out.println("Function: " + Util.string(LLVM.LLVMGetValueName(function.getSecond().getDirect().getDirect())));
                function.getSecond().buildRoot();
                function.getSecond().acceptBlock(function.getFirst());
                if (!root.getBlockBuilding().isTerminated()) root.getBlockBuilding().ret();
            });
        });
    }

    public void dump() {
        root.dump();
    }

    public void optimize(int llvm, int rlx, boolean noIntrinsics) {
        LLVMPassManagerBuilderRef builderRef = LLVM.LLVMPassManagerBuilderCreate();
        LLVM.LLVMPassManagerBuilderSetOptLevel(builderRef, llvm);

        LLVMPassManagerRef pass = LLVM.LLVMCreatePassManager();
        if (rlx >= 5) {
            LLVM.LLVMAddInternalizePass(pass, 1);
            LLVM.LLVMAddGlobalOptimizerPass(pass);
            LLVM.LLVMAddFunctionAttrsPass(pass);
            LLVM.LLVMAddLICMPass(pass);
            LLVM.LLVMAddDeadArgEliminationPass(pass);
            LLVM.LLVMAddAlwaysInlinerPass(pass);
            LLVM.LLVMAddMergeFunctionsPass(pass);
            LLVM.LLVMAddFunctionInliningPass(pass);
            LLVM.LLVMAddAggressiveDCEPass(pass);
            LLVM.LLVMAddGlobalDCEPass(pass);
            LLVM.LLVMAddScalarReplAggregatesPass(pass);
            LLVM.LLVMAddArgumentPromotionPass(pass);
            LLVM.LLVMAddPruneEHPass(pass);
            LLVM.LLVMAddCalledValuePropagationPass(pass);
            LLVM.LLVMAddCorrelatedValuePropagationPass(pass);
            LLVM.LLVMAddUnifyFunctionExitNodesPass(pass);
            LLVM.LLVMAddIPSCCPPass(pass);
            LLVM.LLVMAddLICMPass(pass);
            root.hyperAggressiveOptimizer(false, pass);
            LLVM.LLVMAddLICMPass(pass);
            LLVM.LLVMAddStripSymbolsPass(pass);
            LLVM.LLVMAddLowerExpectIntrinsicPass(pass);
            LLVM.LLVMAddLowerConstantIntrinsicsPass(pass);
            LLVM.LLVMAddCFGSimplificationPass(pass);
            root.hyperAggressiveOptimizer(false, pass);
            LLVM.LLVMPassManagerBuilderPopulateModulePassManager(builderRef, pass);
        } else {
            if (rlx >= 4) {
                LLVM.LLVMAddAlignmentFromAssumptionsPass(pass);
                LLVM.LLVMAddFunctionAttrsPass(pass);
                root.hyperAggressiveOptimizer(false, pass);
            } else {
                // passes for cleanup; always used for lower optimization levels
                LLVM.LLVMAddCFGSimplificationPass(pass);
                LLVM.LLVMAddPromoteMemoryToRegisterPass(pass);
                LLVM.LLVMAddEarlyCSEPass(pass);
                LLVM.LLVMAddDCEPass(pass);
                LLVM.LLVMAddConstantMergePass(pass);
                LLVM.LLVMAddInstructionSimplifyPass(pass);
                LLVM.LLVMAddCFGSimplificationPass(pass);

                if (rlx >= 1) {
                    LLVM.LLVMAddFunctionAttrsPass(pass);
                    LLVM.LLVMAddCFGSimplificationPass(pass);
                    LLVM.LLVMAddReassociatePass(pass);
                    LLVM.LLVMAddLoopUnrollAndJamPass(pass);
                    LLVM.LLVMAddReassociatePass(pass);
                    LLVM.LLVMAddCFGSimplificationPass(pass);

                    if (rlx >= 2) {
                        if (rlx == 3) {
                            LLVM.LLVMAddAlignmentFromAssumptionsPass(pass);
                            LLVM.LLVMAddEarlyCSEPass(pass);
                            LLVM.LLVMAddReassociatePass(pass);
                            LLVM.LLVMAddLoopRotatePass(pass);
                            LLVM.LLVMAddLoopUnrollPass(pass);
                            LLVM.LLVMAddLoopDeletionPass(pass);
                            LLVM.LLVMAddLoopIdiomPass(pass);
                            LLVM.LLVMAddLoopRerollPass(pass);
                            LLVM.LLVMAddCFGSimplificationPass(pass);
                            LLVM.LLVMAddAggressiveDCEPass(pass);
                        }

                        LLVM.LLVMAddJumpThreadingPass(pass);
                        LLVM.LLVMAddLoopVectorizePass(pass);
                        LLVM.LLVMAddSLPVectorizePass(pass);
                        LLVM.LLVMAddNewGVNPass(pass);
                        LLVM.LLVMAddCFGSimplificationPass(pass);
                        LLVM.LLVMAddInstructionCombiningPass(pass);
                    }
                }
            }
            LLVM.LLVMPassManagerBuilderPopulateModulePassManager(builderRef, pass);
        }

        if (noIntrinsics) {
            LLVM.LLVMAddInternalizePass(pass, 1);
            LLVM.LLVMPassManagerBuilderPopulateModulePassManager(builderRef, pass);
        }

        LLVM.LLVMRunPassManager(pass, root.getModule());
        LLVM.LLVMDisposePassManager(pass);
        LLVM.LLVMPassManagerBuilderDispose(builderRef);
    }

    public ModuleRoot getModule() {
        return root;
    }

    public Pair<FunctionBuilder, Type> getFunction(String owner, RaluxFunctionConsumer consumer, String funcName, List<Value> args) {
        return cache.findFunction(owner, generating, funcName, args);
    }

    public Pair<FunctionBuilder, Type> getFunction(RaluxFunctionConsumer consumer, String funcName, List<Value> args) {
        return cache.findFunction(generating, funcName, args);
    }
}
