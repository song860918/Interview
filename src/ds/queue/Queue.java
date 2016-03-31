package ds.queue;

public interface Queue<T> {

    void enqueue(T data);

    T dequeue();

    T peek();

    int size();

    boolean isEmpty();

}
