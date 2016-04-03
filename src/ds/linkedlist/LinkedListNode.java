package ds.linkedlist;

public class LinkedListNode<T> {

    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this(data, null);
    }

    public LinkedListNode(T data, LinkedListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedListNode<T> curr = this;
        while(curr != null) {
            sb.append(curr.data);
            sb.append("->");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public int size() {

        int count = 0;
        LinkedListNode<T> curr = this;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

}
