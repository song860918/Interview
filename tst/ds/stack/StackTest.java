package ds.stack;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import util.TestUtil;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class StackTest {

    protected Stack<Integer> stack;

    @Test
    public void stackPushPeekAndPopTest() {
        List<Integer> list = TestUtil.randomIntegerList();

        for (int i : list) {
            stack.push(i);
        }

        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(list.get(list.size() - i - 1), stack.peek());
            newList.add(0, stack.pop());
        }

        Assert.assertArrayEquals(list.toArray(), newList.toArray());
    }

    @Test(expected = RuntimeException.class)
    public void emptyStackThrowsException() {
        stack.pop();
    }

    @Test
    public void nullTest() {
        stack.push(1);
        stack.push(null);
        stack.push(2);

        Assert.assertEquals(2, stack.pop().intValue());
        Assert.assertNull(stack.pop());
        Assert.assertEquals(1, stack.pop().intValue());

    }

}
