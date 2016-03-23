package ood.reservation.restaurant;

import java.util.List;

public class TimeSlots {

    Node<TimeRange> occupiedTimeRangeHead;

    //TODO
    public List<TimeRange> getFreeTimeRages() {
        return occupiedTimeRangeHead.toList();
    }

    //TODO
    public boolean isFree(long start, long end) {
        Node<TimeRange> prev = null;
        Node<TimeRange> curr = occupiedTimeRangeHead;

        if (curr == null) return true;

        // Skip nodes till we find our potential time slot
        while(curr != null && curr.data.getStart() < end) {
            prev = curr;
            curr = curr.next;
        }

        // Covers:
        // 1) curr is null, then as long as prev.end < start, it's okay to insert;
        // 2) Find the slot, same thing, as long as prev.end < start, it's okay to insert.
        return prev.data.getEnd() < start;
    }

    //TODO
    public boolean tryReserve(long start, long end) {
        Node<TimeRange> prev = null;
        Node<TimeRange> curr = occupiedTimeRangeHead;

        if (curr == null) {
            occupiedTimeRangeHead = insert(prev, start, end);
            return true;
        }

        // Skip nodes till we find our potential time slot
        while(curr != null && curr.data.getStart() < end) {
            prev = curr;
            curr = curr.next;
        }

        // Covers:
        // 1) curr is null, then as long as prev.end < start, it's okay to insert;
        // 2) Find the slot, same thing, as long as prev.end < start, it's okay to insert.
        if (prev.data.getEnd() < start) {
            insert(prev, start, end);
            return true;
        } else {
            return false;
        }
    }

    private Node<TimeRange> insert(Node<TimeRange> node, long start, long end) {
        if (node == null) {
            return new Node<TimeRange>(new TimeRange(start, end), null);
        }

        Node<TimeRange> next = node.next;
        node.next = new Node<TimeRange>(new TimeRange(start, end), next);
        return node;
    }

    //TODO
    public void setToDefault() {

    }
}
