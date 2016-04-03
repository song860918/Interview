package ds.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import util.TestUtil;

public class FindDuplicatesTest {

    private FindDuplicates<Integer> findDuplicates = new FindDuplicates<>();

    @Test
    public void noNodeTest() {
        LinkedListNode<Integer> root = null;

        findDuplicates.dedup(root);

        Assert.assertEquals(0, TestUtil.size(root));
    }

    @Test
    public void oneNodeTest() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(1);

        findDuplicates.dedup(root);

        Assert.assertEquals(1, TestUtil.size(root));
    }

    @Test
    public void noDuplicatesTest() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(1, 2, 3, 4, 5);

        findDuplicates.dedup(root);

        Assert.assertEquals(5, TestUtil.size(root));
    }

    @Test
    public void someDuplicatesTest() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(1, 2, 3, 2, 1);

        findDuplicates.dedup(root);

        Assert.assertEquals(3, TestUtil.size(root));
    }

    @Test
    public void someDuplicatesTest2() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(1, 2, 3, 3, 3, 4, 5);

        findDuplicates.dedup(root);

        Assert.assertEquals(5, TestUtil.size(root));
    }

    @Test
    public void someDuplicatesTest3() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(1, 2, 1, 2, 1, 2, 1);

        findDuplicates.dedup(root);

        Assert.assertEquals(2, TestUtil.size(root));
    }

    @Test
    public void allDuplicatesTest() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(1, 1, 1, 1, 1);

        findDuplicates.dedup(root);

        Assert.assertEquals(1, TestUtil.size(root));
    }
}
