package ds.array;

import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    private LRUCache lruCache = new LRUCache(1);

    @Test
    public void test() {
        lruCache.set(2, 1);
        Assert.assertEquals(1, lruCache.get(2));
    }

}
