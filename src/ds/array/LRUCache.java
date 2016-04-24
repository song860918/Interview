package ds.array;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node fetched = map.get(key);
        if (fetched == null) {
            return -1;
        }
        int result = fetched.value;
        // Most recent used, first take it out, then move to head
        removeNode(fetched);
        moveToHead(fetched);
        return result;
    }

    private void removeNode(Node toRemove) {
        // Special Nodes 1) toRemove is head, re-point head to next; 2) toRemove is tail, repoint tail to prev
        if (head == toRemove) {
            head = head.next;
        }
        if (tail == toRemove) {
            tail = tail.prev;
        }
        // Normal use case
        if (toRemove.prev != null) {
            toRemove.prev.next = toRemove.next;
        }
        if (toRemove.next != null) {
            toRemove.next.prev = toRemove.prev;
        }
    }

    private void moveToHead(Node fetched) {
        // if head == null, meaning fetched is the only element
        if (head == null) {
            head = fetched;
            tail = fetched;
        } else {
            fetched.next = head;
            head.prev = fetched;
            head = fetched;
        }
    }

    public void set(int key, int value) {
        Node toUpsert;
        // Does node already exists?
        if (map.containsKey(key)) {
            toUpsert = map.get(key);
            removeNode(toUpsert);
            toUpsert.value = value;
        } else {
            toUpsert = new Node(key, value);
            map.put(key, toUpsert);
        }
        moveToHead(toUpsert);
        // Should we remove LRU item?
        if (map.size() > capacity) {
            //Remove tail item
            map.remove(tail.key);
            tail = tail.prev;
        }
    }

}
