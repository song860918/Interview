package ds.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

    private TreeNode<T> root;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(TreeNode<T> root) {
        this.root = root;
    }

    public List<T> inOrderTraversal() {
        List<T> list = new ArrayList<>();
        inOrderTraversalHelper(list, root);
        return list;
    }

    private void inOrderTraversalHelper(List<T> list, TreeNode<T> node) {
        if (node == null) {
            return;
        }

        inOrderTraversalHelper(list, node.left);
        list.add(node.data);
        inOrderTraversalHelper(list, node.right);
    }

    public List<T> preOrderTraversal() {
        List<T> list = new ArrayList<>();
        preOrderTraversalHelper(list, root);
        return list;
    }

    private void preOrderTraversalHelper(List<T> list, TreeNode<T> node) {
        if (node == null) {
            return;
        }

        list.add(node.data);
        preOrderTraversalHelper(list, node.left);
        preOrderTraversalHelper(list, node.right);
    }

    public List<T> postOrderTraversal() {
        List<T> list = new ArrayList<>();
        postOrderTraversalHelper(list, root);
        return list;
    }

    private void postOrderTraversalHelper(List<T> list, TreeNode<T> node) {
        if (node == null) {
            return;
        }

        postOrderTraversalHelper(list, node.left);
        postOrderTraversalHelper(list, node.right);
        list.add(node.data);
    }

    public void insert(T data) {
        root = insertHelper(root, data);
    }

    private TreeNode<T> insertHelper(TreeNode<T> node, T data) {
        // If null, found the spot to insert
        if (node == null) {
            return new TreeNode<T>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertHelper(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertHelper(node.right, data);
        }

        return node;
    }

    public boolean find(T data) {
        return findHelper(root, data);
    }

    private boolean findHelper(TreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.compareTo(node.data) < 0) {
            return findHelper(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            return findHelper(node.right, data);
        } else {
            return true;
        }
    }

    public void delete(T data) {
        root = deleteHelper(root, data);
    }

    private TreeNode<T> deleteHelper(TreeNode<T> node, T data) {
        if (node == null) {
            return null;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = deleteHelper(node.left, data);
            return node;
        } else if (data.compareTo(node.data) > 0) {
            node.right = deleteHelper(node.right, data);
            return node;
        } else {
            // find match
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // find left child's right most node
                node.left = replaceWithRightMostNode(node.left, node);
                return node;
            }
        }
    }

    private TreeNode<T> replaceWithRightMostNode(TreeNode<T> node, TreeNode<T> target) {
        if (node.right == null) {
            //found node
            target.data = node.data;
            return node.left;
        } else {
            node.right = replaceWithRightMostNode(node.right, target);
        }
        return node;
    }

    @Override
    public Iterator<T> iterator() {
        return new BinarySearchTreeIterator();
    }

    private class BinarySearchTreeIterator implements Iterator {

        private List<T> itrArr;
        private int index;

        private BinarySearchTreeIterator() {
            itrArr = new ArrayList<>();
            inOrderTraversal(itrArr, root);
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < itrArr.size();
        }

        @Override
        public T next() {
            return itrArr.get(index++);

        }
        private void inOrderTraversal(List<T> itrArr, TreeNode<T> node) {
            if (node == null) {
                return;
            }

            inOrderTraversal(itrArr, node.left);
            itrArr.add(node.data);
            inOrderTraversal(itrArr, node.right);
        }
    }

}
