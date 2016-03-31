package ds.array;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    private ReverseString reverseString = new ReverseString();

    @Test
    public void reverseStringTest() {
        Assert.assertEquals(null, reverseString.reverse(null));
        Assert.assertEquals("", reverseString.reverse(""));
        Assert.assertEquals("a", reverseString.reverse("a"));
        Assert.assertEquals("ba", reverseString.reverse("ab"));
        Assert.assertEquals("edcba", reverseString.reverse("abcde"));
        Assert.assertEquals("fedcba", reverseString.reverse("abcdef"));
    }
}
