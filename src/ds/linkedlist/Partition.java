package ds.linkedlist;

/**
 * Cracking The Coding Interview 2.4
 */
public class Partition<T extends Comparable<T>> {

    public LinkedListNode<T>  partition(LinkedListNode<T> root, T pivot) {
        if (root == null || root.next == null) {
            return root;
        }

        LinkedListNode<T> startList = null;
        LinkedListNode<T> startListEnd = null;
        LinkedListNode<T> endList = null;

        LinkedListNode<T> curr = root;

        while (curr != null) {
            LinkedListNode<T> next = curr.next;

            if (curr.data.compareTo(pivot) < 0) {
                curr.next = startList;
                startList = curr;
            } else {
                curr.next = endList;
                endList = curr;
            }

            curr = next;
        }

        if (startList == null) {
            startList = endList;
        } else {
            startListEnd = startList;
            while (startListEnd.next != null) {
                startListEnd = startListEnd.next;
            }
            startListEnd.next = endList;
        }

        return startList;
    }

}
