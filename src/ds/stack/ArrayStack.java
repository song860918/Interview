package ds.stack;

public class ArrayStack<T> implements Stack<T> {

    private static final int INITIAL_CAPACITY = 10;

    private T[] arr;
    private int index; // Top of stack

    public ArrayStack() {
        arr = (T[]) new Object[INITIAL_CAPACITY];
        index = -1; // No element in stack
    }

    @Override
    public void push(T data) {

        arr[++index] = data;

        // Size is full. Resize.
        if (index == arr.length - 1) {
            resize();
        }
    }

    private void resize() {

        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;

    }

    @Override
    public T pop() {
        if (index < 0) {
            throw new RuntimeException("No element");
        }
        return arr[index--];
    }

    @Override
    public T peek() {
        if (index < 0) {
            throw new RuntimeException("No element");
        }
        return arr[index];
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index < 0;
    }
}
