package ds.linkedlist;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListNode)) {
            return false;
        }
        ListNode toCompare = (ListNode)obj;
        ListNode curr = this;
        ListNode toCompareCurr = toCompare;

        while (curr != null && toCompareCurr != null) {
            if (curr.val != toCompareCurr.val) {
                return false;
            }
            curr = curr.next;
            toCompareCurr = toCompareCurr.next;
        }

        return curr == null && toCompareCurr == null;
    }

}
