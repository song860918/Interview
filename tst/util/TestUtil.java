package util;

import ds.array.Interval;
import ds.graph.GraphNode;
import ds.linkedlist.LinkedListNode;
import ds.linkedlist.ListNode;

import java.util.*;

public class TestUtil {

    public static int[] sortedIncrementedArray(int count) {

        int[] arr = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = i;
        }

        return arr;
    }

    public static List<Integer> randomIntegerList() {
        return randomIntegerList(100);
    }

    public static List<Integer> randomIntegerList(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        Collections.shuffle(list);

        System.out.println(list);
        return list;
    }

    public static LinkedListNode<Integer> integerLinkedList(int... integers) {

        LinkedListNode<Integer> root = new LinkedListNode<Integer>(-1);
        LinkedListNode<Integer> curr = root;
        for (int i : integers) {
            curr.next = new LinkedListNode<Integer>(i);
            curr = curr.next;
        }

        return root.next;
    }

    public static ListNode intLinkedList(int... integers) {

        ListNode root = new ListNode(-1);
        ListNode curr = root;
        for (int i : integers) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        return root.next;
    }

    public static int size(LinkedListNode<Integer> root) {

        int count = 0;
        LinkedListNode<Integer> curr = root;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    public static GraphNode<Character> characterGraph(char[] chars, char root, String edgeString) {
        Map<Character, GraphNode<Character>> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, new GraphNode<>(c));
        }

        // edge is expected in the formact of "a->b"
        String[] edges = edgeString.split(",");

        for (String edge : edges) {
            edge = edge.trim();
            String[] nodePair = edge.split("->");
            map.get(nodePair[0].charAt(0)).neighbors.add(map.get(nodePair[1].charAt(0)));
        }

        return map.get(root);
    }

    public static List<Interval> intervalList(int... times) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < times.length; i += 2) {
            list.add(new Interval(times[i], times[i + 1]));
        }
        return list;
    }

}
