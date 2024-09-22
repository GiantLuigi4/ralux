package tfc.ralux.compiler.util;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.RuleNode;

import java.util.*;
import java.util.function.Consumer;

public class TreeNode implements ListIterable<TreeNode> {
    final List<TreeNode> nodes = new ArrayList<>();
    int depth = -1;
    RuleContext context;
    String text;
    Object payload;
    Interval sourceInterval;
    TreeNode parent;

    public TreeNode(ParseTree tree) {
        this.text = tree.getText();
        this.payload = tree.getPayload();
        this.sourceInterval = tree.getSourceInterval();

        for (int i = 0; i < tree.getChildCount(); i++) {
            add(new TreeNode(tree.getChild(i)));
        }

        if (tree instanceof RuleNode) {
            this.context = ((RuleNode) tree).getRuleContext();
        }
    }

    public TreeNode(String text, Object payload, Interval sourceInterval) {
        this.text = text;
        this.payload = payload;
        this.sourceInterval = sourceInterval;
    }

    public void add(TreeNode node) {
        this.nodes.add(node);
        if (node.parent != null)
            throw new RuntimeException("Node already has a parent.");
        node.parent = this;
    }

    public void remove(TreeNode node) {
        this.nodes.remove(node);
        node.parent = null;
        node.depth = -1;
    }

    @Override
    public Iterator<TreeNode> iterator() {
        return nodes.iterator();
    }

    @Override
    public void forEach(Consumer<? super TreeNode> action) {
        nodes.forEach(action);
    }

    @Override
    public Spliterator<TreeNode> spliterator() {
        return nodes.spliterator();
    }

    public void forEachRecursive(Consumer<? super TreeNode> action) {
        action.accept(this);
        for (TreeNode treeNode : this) {
            treeNode.forEachRecursive(action);
        }
    }

    @Override
    public ListIterator<TreeNode> listIterator() {
        return nodes.listIterator();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                ", text='" + text + '\'' +
                ", payload=" + payload +
                ", sourceInterval=" + sourceInterval +
                ", parent=" + parent.superStr() +
                '}';
    }

    public String superStr() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(nodes, treeNode.nodes) && Objects.equals(text, treeNode.text) && Objects.equals(payload, treeNode.payload) && Objects.equals(sourceInterval, treeNode.sourceInterval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes, text, payload, sourceInterval);
    }

    public <T> T getPayload(Class<T> clz) {
        if (payload == null) return null;
        if (clz.isAssignableFrom(payload.getClass()))
            return (T) payload;
        return null;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RuleContext getContext() {
        return context;
    }

    public Object getPayload() {
        return payload;
    }

    public Interval getSourceInterval() {
        return sourceInterval;
    }

    public Object getRealPayload() {
        return payload;
    }

    public TreeNode get(int index) {
        return nodes.get(index);
    }

    public boolean isFromRule() {
        if (payload instanceof RuleContext)
            return true;
        return false;
    }

    public int rule() {
        return context.getRuleIndex();
    }

    public int textStart() {
        return sourceInterval.a;
    }

    public int textEnd() {
        return sourceInterval.b;
    }

    public int size() {
        return nodes.size();
    }

    public TreeNode remove(int i) {
        TreeNode old = nodes.remove(i);
        if (old == null) return null;
        old.depth = -1;
        return old;
    }

    public TreeNode replace(int index, TreeNode node) {
        TreeNode node1 = nodes.set(index, node);
        if (node1 == null) return null;
        node1.depth = -1;
        return node1;
    }

    public TreeNode getParent() {
        return parent;
    }

    public int getDepth() {
        if (this.depth != -1) return depth;

        TreeNode curr = this.parent;
        int depth = 0;
        while (curr != null) {
            if (curr.depth != -1) {
                this.depth = curr.depth + 1;
                return this.depth;
            }
            curr = curr.parent;
            depth++;
        }
        this.depth = depth;
        return depth;
    }

    public String getText(Parser parser) {
        if (isFromRule())
            return parser.getRuleNames()[rule()];
        return text;
    }

    public String getRawText() {
        return text;
    }
}
