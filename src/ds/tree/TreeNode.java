package ds.tree;

public class TreeNode<T> {

    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public int height;

    public TreeNode(T data) {
        this(data, null, null);
    }

    public TreeNode(T data, int height) {
        this(data, null, null, height);
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this(data, left, right, -1);
    }

    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right, int height) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = height;
    }

}
