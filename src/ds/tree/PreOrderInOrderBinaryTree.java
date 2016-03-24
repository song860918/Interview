package ds.tree;

import util.TODO;

import java.util.ArrayList;
import java.util.List;

public class PreOrderInOrderBinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root;
    private static int preIndex = 0;

    public PreOrderInOrderBinaryTree(List<T> preOrderList, List<T> inOrderList) {
        if (preOrderList.size() != inOrderList.size()) {
            throw new RuntimeException("Size of two lists doesn't match!");
        }
        root = constructTree(preOrderList, inOrderList, 0, inOrderList.size() - 1);
    }

    // In order index range is the range to find the current node in the pre order list
    private TreeNode<T> constructTree(List<T> preOrderList, List<T> inOrderList, int inOrderIndextStart, int inOrderIndexEnd) {

        // No node, return null;
        if (inOrderIndextStart > inOrderIndexEnd) {
            return null;
        }

        // Only one node, this is it
        if (inOrderIndextStart == inOrderIndexEnd) {
            preIndex++;
            return new TreeNode<>(inOrderList.get(inOrderIndextStart));
        }

        T data = preOrderList.get(preIndex);
        int inOrderIndex = find(inOrderList, data, inOrderIndextStart, inOrderIndexEnd);
        preIndex++;



        return new TreeNode<>(data,
                constructTree(preOrderList, inOrderList, inOrderIndextStart, inOrderIndex - 1),
                constructTree(preOrderList, inOrderList, inOrderIndex + 1, inOrderIndexEnd)
        );
    }

    private int find(List<T> inOrderList, T key, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inOrderList.get(i).equals(key)) {
                return i;
            }
        }

        throw new RuntimeException("Not found key: " + key);
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    @TODO
    public List<T> inOrderTraversal() {
        List<T> list = new ArrayList<>();
        inOrderTraversalHelper(list, root);
        return list;
    }

    private void inOrderTraversalHelper(List<T> list, TreeNode<T> node) {
        // Null check
        if (node == null) return;

        // Else, add left, then self, then right
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
        // Null check
        if (node == null) return;

        // Else, add self, then left, then right
        list.add(node.data);
        preOrderTraversalHelper(list, node.left);
        preOrderTraversalHelper(list, node.right);
    }
}
