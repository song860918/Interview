package ds.linkedlist;

import org.junit.Test;
import util.TestUtil;

public class PartitionTest {

    private  Partition<Integer> partition = new Partition<>();

    @Test
    public void noPivotInListTest() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(6, 3, 1, 7, 5, 2);

        root = partition.partition(root, 4);

        System.out.println(root);
    }

    @Test
    public void pivotInListTest() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(6, 3, 1, 4, 5, 2);

        root = partition.partition(root, 4);

        System.out.println(root);
    }

    @Test
    public void smallerThanPivotOnlyTest() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(6, 3, 1, 7, 5, 2);

        root = partition.partition(root, 14);

        System.out.println(root);
    }

    @Test
    public void largerThanPivotOnlyTest() {
        LinkedListNode<Integer> root = TestUtil.integerLinkedList(6, 13, 10, 7, 15, 12);

        root = partition.partition(root, 4);

        System.out.println(root);
    }
}
