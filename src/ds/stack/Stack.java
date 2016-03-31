package ds.stack;

public interface Stack<T> {

    void push(T data);

    T pop();

    T peek();

    int size();

    boolean isEmpty();

}
