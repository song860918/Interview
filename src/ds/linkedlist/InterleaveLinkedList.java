package ds.linkedlist;

/**
 * This is a good question to test fundamentals, it basically test your ability to find middle, reverse linked list and manipulate pointers.
 * Facebook question:
 * input: 1->2->3->4->5
 * output: 1->5->2->4->3
 */
public class InterleaveLinkedList {

    public ListNode interleave(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }

        ListNode firstHalfEnd = findMiddle(root);
        ListNode secondHalfStart = firstHalfEnd.next;
        // Break first and second half linkedList
        firstHalfEnd.next = null;

        //Reverse second half linkedList
        ListNode secondHalfReversedStart = reverse(secondHalfStart);

        // Interleave two linkedList
        ListNode i1 = root;
        ListNode i2 = secondHalfReversedStart;
        ListNode toReturnRoot = new ListNode(-1);
        // Make sure toReturnRoot is not null, easier for while condition
        ListNode i = toReturnRoot;
        // We know that first linkedList size is 1 bigger or equal to second linkedList
        while (i1 != null) {
            i.next = i1;
            i = i.next;
            i1 = i1.next;
            if (i2 != null) {
                i.next = i2;
                i = i.next;
                i2 = i2.next;
            }
        }

        return toReturnRoot.next;

    }

    private ListNode reverse(ListNode start) {

        if (start == null || start.next == null) {
            return start;
        }

        ListNode reversedRoot = null;
        ListNode curr = start;
        while (curr != null) {
            ListNode next = curr.next;
            //Remove node from linkedList
            curr.next = null;
            //Add curr to head of reversedLinkedList
            curr.next = reversedRoot;
            reversedRoot = curr;
            // Move curr pointer to next
            curr = next;
        }

        return reversedRoot;

    }

    // Return the end of first half of linkedList
    private ListNode findMiddle(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        // two scenarios: try it out yourself to find the condition for while loop
        // 1) odd #nodes: 1->2->3->4->5
        // 2) even #nodes: 1->2->3->4->5->6
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
