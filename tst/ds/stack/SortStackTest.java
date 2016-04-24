package ds.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class SortStackTest {

    private SortStack sortStack = new SortStack();

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(3);
        stack.push(10);
        stack.push(1);
        stack.push(12);
        stack = sortStack.sort(stack);
        Assert.assertEquals(1, stack.pop().intValue());
        Assert.assertEquals(3, stack.pop().intValue());
        Assert.assertEquals(8, stack.pop().intValue());
        Assert.assertEquals(10, stack.pop().intValue());
        Assert.assertEquals(12, stack.pop().intValue());
    }

}
