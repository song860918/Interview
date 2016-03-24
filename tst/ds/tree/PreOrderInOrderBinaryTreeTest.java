package ds.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PreOrderInOrderBinaryTreeTest {

    @Test
    public void createBinaryTreeThenConvertBackToListsAreSameAsOriginal() {
        List<Integer> preOrderList = Arrays.asList(4, 2, 1, 3, 6, 5, 7);
        List<Integer> inOrderList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        PreOrderInOrderBinaryTree<Integer> bt = new PreOrderInOrderBinaryTree<>(preOrderList, inOrderList);

        Assert.assertEquals(Integer.valueOf(4), bt.getRoot().data);

        Assert.assertArrayEquals(inOrderList.toArray(new Integer[0]), bt.inOrderTraversal().toArray(new Integer[0]));
        Assert.assertArrayEquals(preOrderList.toArray(new Integer[0]), bt.preOrderTraversal().toArray(new Integer[0]));
    }


}
