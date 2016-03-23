package ood.reservation.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    public T data;
    public Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    // Convert node and all subsequent nodes into a list
    public List<T> toList() {
        Node<T> node = this;
        List<T> list = new ArrayList<>();
        while(node != null) {
            list.add(node.data);
            node = node.next;
        }
        return list;
    }
}
