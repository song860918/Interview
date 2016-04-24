package ds.stack;

public interface MyStack<T> {

    void push(T data);

    T pop();

    T peek();

    int size();

    boolean isEmpty();

}
