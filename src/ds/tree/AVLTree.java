package ds.tree;

public class AVLTree <T extends Comparable<T>> {

    public TreeNode<T> root;

    public AVLTree() {
        this(null);
    }

    public AVLTree(TreeNode<T> root) {
        this.root = root;
    }

    public void insert(T data) {
        root = insertHelper(root, data);
    }

    private TreeNode<T> insertHelper(TreeNode<T> node, T data) {
        // If null, found the spot to insert
        if (node == null) {
            return new TreeNode<>(data, 0);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertHelper(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertHelper(node.right, data);
        }

        // Rebalance if necessary and adjust height
        if (Math.abs(getHeight(node.left) - getHeight(node.right)) > 1) {
            node = rebalance(node);

        }

        // Update self height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return node;
    }

    private int getHeight(TreeNode<T> node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    // ref: https://en.wikipedia.org/wiki/AVL_tree#/media/File:AVL_Tree_Rebalancing.svg
    // http://users.cis.fiu.edu/~weiss/dsj4/code/weiss/nonstandard/Rotations.java
    private TreeNode<T> rebalance(TreeNode<T> node) {

        // Left case
        if (getHeight(node.left) - getHeight(node.right) > 0) {

            if (getHeight(node.left.left) < getHeight(node.left.right)) {
                return doubleRotateLeftRight(node);
            } else {
                return rotateRight(node);
            }

        } else {

            if (getHeight(node.right.right) < getHeight(node.right.left)) {
                return doubleRotateRightLeft(node);
            } else {
                return rotateLeft(node);
            }

        }

    }

    private TreeNode<T> rotateRight(TreeNode<T> node) {
        node.height--; node.left.height++;
        TreeNode<T> left = node.left;
        node.left = left.right;
        left.right = node;
        return left;
    }

    private TreeNode<T> rotateLeft(TreeNode<T> node) {
        node.height--; node.right.height++;
        TreeNode<T> right = node.right;
        node.right = right.left;
        right.left = node;
        return right;
    }

    private TreeNode<T> doubleRotateLeftRight(TreeNode<T> node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private TreeNode<T> doubleRotateRightLeft(TreeNode<T> node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

}
