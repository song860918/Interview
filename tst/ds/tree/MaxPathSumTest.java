package ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class MaxPathSumTest {

    private MaxPathSum maxPathSum = new MaxPathSum();

    @Test
    public void basicTest() {
        IntTreeNode root = new IntTreeNode(1);
        root.left = new IntTreeNode(2);
        root.left.left = new IntTreeNode(3);
        root.left.right = new IntTreeNode(4);
        root.right = new IntTreeNode(-1);

        Assert.assertEquals(9, maxPathSum.maxPathSum(root));
    }

}
