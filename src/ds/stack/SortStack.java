package ds.stack;

import java.util.Stack;

/**
 * Cracking the Coding Interview 3.6
 * This is a insertion sort using stack
 */
public class SortStack {

    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!r.isEmpty() && r.peek() < tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }

}
