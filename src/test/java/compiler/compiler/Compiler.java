package compiler.compiler;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.bytedeco.llvm.LLVM.LLVMPassManagerRef;
import org.bytedeco.llvm.global.LLVM;
import tfc.ralux.compiler.backend.llvm.FunctionBuilder;
import tfc.ralux.compiler.backend.llvm.FunctionType;
import tfc.ralux.compiler.backend.llvm.root.BuilderRoot;
import tfc.ralux.compiler.parse.RaluxParser;

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
        // TODO: write type&params
        FunctionType funcType = new FunctionType(root, root.getIntType(32));
        funcType = funcType.build();
        return root.function(
                name,
                funcType
        );
    }

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
                    case RaluxParser.RULE_full_type -> {
                        type = ((RaluxParser.Full_typeContext) node);
                    }
                    case RaluxParser.RULE_def_params -> {
                        params = ((RaluxParser.Def_paramsContext) node);
                    }
                    case RaluxParser.RULE_body -> {
                        built = true;
                        FunctionBuilder builder = writeFunctionHeader(
                                type, name, params
                        );
                        new RaluxFunctionConsumer(root, builder, this).acceptBlock((RaluxParser.BodyContext) node);
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
    }

    public void dump() {
        root.dump();
    }

    public void optimize(int llvm, int rlx) {
        LLVMPassManagerRef pass = LLVM.LLVMCreatePassManager();
        if (rlx == 4) {
            root.hyperAggressiveOptimizer(false, pass);
        }
        LLVM.LLVMRunPassManager(pass, root.getModule());
        LLVM.LLVMDisposePassManager(pass);
    }
}
