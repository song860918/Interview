package ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates<T> {

    public void dedupWithSet(LinkedListNode<T> root) {
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

    public void dedup(LinkedListNode<T> root) {
        if (root == null) {
            return;
        }

        LinkedListNode<T> curr = root;

        while (curr != null) {
            LinkedListNode<T> runner = curr;
            while (runner.next != null) {
                if (curr.data.equals(runner.next.data)) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }

}
