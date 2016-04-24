package ds.linkedlist;

/**
 * Cracking The Coding Interview 2.5, leetcode 2
 */
public class AddTwoNumbers {

    public IntLinkedListNode addTwoNumbers(IntLinkedListNode l1, IntLinkedListNode l2) {
        IntLinkedListNode dummy = new IntLinkedListNode(-1);
        IntLinkedListNode curr = dummy;
        boolean carry = false;
        while (l1 != null || l2 != null || carry) {
            int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (carry ? 1 : 0);
            if (val > 9) {
                carry = true;
                val -= 10;
            } else {
                carry = false;
            }
            curr.next = new IntLinkedListNode(val);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummy.next;

    }

}
