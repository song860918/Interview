package ds;

import ds.queue.ArrayQueue;
import org.junit.Before;

public class ArrayQueueTest extends QueueTest {

    @Before
    public void setUp() {
        queue = new ArrayQueue<>();
    }

}
