package ds.queue;

import ds.queue.Queue;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import util.TestUtil;

import java.util.List;

@Ignore
public class QueueTest {

    protected Queue<Integer> queue;

    @Test
    public void enqueuePeekAndDequeueTest() {
        List<Integer> list = TestUtil.randomIntegerList();

        for (int i = 0; i < queue.size(); i++) {
            queue.enqueue(i);
            Assert.assertEquals(i + 1, queue.size());
        }

        for (int i = 0; i < queue.size(); i++) {
            Assert.assertEquals(list.get(i), queue.peek());
            Assert.assertEquals(list.get(i), queue.dequeue());
        }

        Assert.assertTrue(queue.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void emptyTest() {
        queue.dequeue();
    }

    @Test
    public void nullTest() {
        queue.enqueue(1);
        queue.enqueue(null);
        queue.enqueue(2);
        Assert.assertEquals(1, queue.dequeue().intValue());
        Assert.assertNull(queue.dequeue());
        Assert.assertEquals(2, queue.dequeue().intValue());
    }

}
