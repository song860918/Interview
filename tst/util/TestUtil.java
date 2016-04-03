package util;

import ds.linkedlist.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestUtil {

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

    public static int size(LinkedListNode<Integer> root) {

        int count = 0;
        LinkedListNode<Integer> curr = root;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

}
