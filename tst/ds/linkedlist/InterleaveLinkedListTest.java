package ds.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import util.TestUtil;

public class InterleaveLinkedListTest {

    private InterleaveLinkedList interleaveLinkedList = new InterleaveLinkedList();

    @Test
    public void oddTest() {
        ListNode root = TestUtil.intLinkedList(1, 2, 3, 4, 5);
        ListNode expected = TestUtil.intLinkedList(1, 5, 2, 4, 3);

        Assert.assertEquals(expected, interleaveLinkedList.interleave(root));
    }

    @Test
    public void evenTest() {
        ListNode root = TestUtil.intLinkedList(1, 2, 3, 4, 5, 6);
        ListNode expected = TestUtil.intLinkedList(1, 6, 2, 5, 3, 4);

        Assert.assertEquals(expected, interleaveLinkedList.interleave(root));
    }

}
