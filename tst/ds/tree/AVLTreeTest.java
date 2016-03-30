package ds.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static util.TestUtil.*;

public class AVLTreeTest {

    private AVLTree<Integer> avlTree;

    @Before
    public void setUp() {
        avlTree = new AVLTree<>();
    }

    @Test
    public void insertTest() {
        List<Integer> list = randomIntegerList();

        System.out.println(list);

        for (int i : list) {
            avlTree.insert(i);
        }

        Assert.assertTrue(verifyAVLTree(avlTree.root));
    }

    private boolean verifyAVLTree(TreeNode<Integer> node) {
        if (node == null) {
            return true;
        }

        return verifyAVLTree(node.left) && verifyAVLTree(node.right) && Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1;
    }

    private int getHeight(TreeNode<Integer> node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }
}
