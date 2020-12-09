
public abstract class BinaryTree<T> {
    abstract String toString(String indent);

    public abstract int height();

    public abstract boolean isEmpty();

    public abstract int nodeCount();

    public abstract int leafCount();

    public abstract int levelCount(int level);

    public abstract BinaryTree<T> mirrorImage();

    public abstract int weightBalanceFactor();

    public abstract int nodeSum();

    public abstract void doubles();

    public abstract int maxPathSum();

    public abstract String preOrder();

    public abstract String postOrder();

    public abstract String inOrder();
    
    protected abstract int levelCountInternal(int level, int current);
}
