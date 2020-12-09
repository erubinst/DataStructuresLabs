
public class ConsTree<T> extends BinaryTree<T> {
    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public ConsTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
	this.data = data;
	leftChild = left;
	rightChild = right;
    }

    public ConsTree(T data) {
	this(data, new EmptyTree<T>(), new EmptyTree<T>());
    }

    public String toString(String indent) {
	return rightChild.toString(indent + "   ") + "\n" + indent + "/\n" + indent + data.toString() + "\n" + indent
		+ "\\" + leftChild.toString(indent + "   ");
    }

    public String toString() {
	return toString("");
    }

    public int height() {
	return 1 + Math.max(leftChild.height(), rightChild.height());

    }

    public boolean isEmpty() {
	return false;
    }

    public int nodeCount() {
	return 1 + leftChild.nodeCount() + rightChild.nodeCount();
    }

    public int leafCount() {
	// baseCase for recursion is if there are no left or right children of the node
	// - return 1
	if (leftChild.isEmpty() & rightChild.isEmpty()) {
	    return 1;
	} else {
	    return leftChild.leafCount() + rightChild.leafCount();
	}
	// LeafCount = LeafCount of left subtree + LeafCount of right subtree
    }

    protected int levelCountInternal(int level, int current) {
	if (current == level) {
	    return 1;
	} else {
	    current++;
	    return leftChild.levelCountInternal(level, current) + rightChild.levelCountInternal(level, current);
	}
    }

    public int levelCount(int level) {
	return levelCountInternal(level, 0);
    }

    public BinaryTree<T> mirrorImage() {
	return new ConsTree<T>(data, rightChild.mirrorImage(), leftChild.mirrorImage());
    }

    public int weightBalanceFactor() {
	int nodeWeight = Math.abs(leftChild.nodeCount() - rightChild.nodeCount());
	int maxChildWeight = Math.max(leftChild.weightBalanceFactor(), rightChild.weightBalanceFactor());
	return Math.max(nodeWeight, maxChildWeight);
    }

    public int nodeSum() {
	// Total nodeSum = data + SumLeft + SumRight
	return Integer.parseInt((String) data) + leftChild.nodeSum() + rightChild.nodeSum();
	// What is the base case? just if the tree is empty? and u deal with this
	// in the empty tree class??
    }

    public void doubles() {
	data = (T) Integer.toString(Integer.parseInt((String) data) * 2);
	leftChild.doubles();
	rightChild.doubles();
    }

    public int maxPathSum() {
	return Integer.parseInt((String) data) + Math.max(leftChild.maxPathSum(), rightChild.maxPathSum());
    }

    public String preOrder() {
	return data + "\n" + leftChild.preOrder() + rightChild.preOrder();
    }

    public String postOrder() {
	return leftChild.postOrder() + rightChild.postOrder() + data + "\n";
    }

    public String inOrder() {
	return leftChild.inOrder() + data + "\n" + rightChild.inOrder();
    }

}
