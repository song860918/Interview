package ds.array;

import org.junit.Assert;
import org.junit.Test;

public class CompressStringTest {

    private CompressString compressString = new CompressString();

    @Test
    public void test() {
        Assert.assertEquals(null, compressString.compress(null));
        Assert.assertEquals("", compressString.compress(""));
        Assert.assertEquals("a", compressString.compress("a"));
        Assert.assertEquals("abcd", compressString.compress("abcd"));
        Assert.assertEquals("aabb", compressString.compress("aabb"));
        Assert.assertEquals("aaab", compressString.compress("aaab"));
        Assert.assertEquals("a4", compressString.compress("aaaa"));
        Assert.assertEquals("a3b2", compressString.compress("aaabb"));
        Assert.assertEquals("a1b2c3d4", compressString.compress("abbcccdddd"));
        Assert.assertEquals("a4b3c2d1", compressString.compress("aaaabbbccd"));
    }

}
