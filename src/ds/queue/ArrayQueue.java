package ds.queue;

public class ArrayQueue<T> implements Queue<T> {

    private static final int INITIAL_CAPACITY = 10;

    private T[] arr;
    private int start;
    private int end;

    public ArrayQueue() {
        arr = (T[]) new Object[INITIAL_CAPACITY];
        start = 0;
        end = -1;
    }

    @Override
    public void enqueue(T data) {

        arr[++end % arr.length] = data;

        if (size() == arr.length) {
            resize();
        }
    }

    private void resize() {

        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = start; i <= end; i++) {
            newArr[i - start] = arr[i % arr.length];
        }

        end -= start;
        start = 0;

        arr = newArr;

    }

    @Override
    public T dequeue() {
        if (end < start) {
            throw new RuntimeException("No element");
        }

        return arr[start++ % arr.length];
    }

    @Override
    public T peek() {
        return arr[start % arr.length];
    }

    @Override
    public int size() {
        return end - start + 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
