package ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates<T extends Comparable<T>> {

    public void dedup(LinkedListNode<T> root) {
        if (root == null) {
            return;
        }

        Set<T> set = new HashSet<>();
        LinkedListNode<T> curr = root;
        set.add(curr.data);

        while(curr.next != null) {
            if (set.contains(curr.next.data)) {
                //Remove
                curr.next = curr.next.next;
            } else {
                set.add(curr.next.data);
                curr = curr.next;
            }
        }
    }

}
