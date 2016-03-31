package ds.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AtoiTest {

    private Atoi atoi;


    @Before
    public void setUp() {
        atoi = new Atoi();
    }

    @Test
    public void positiveNumberTest() {
        Assert.assertEquals(12345, atoi.atoi("12345"));
        Assert.assertEquals(1, atoi.atoi("1"));
    }

    @Test
    public void negativeNumberTest() {
        Assert.assertEquals(-12345, atoi.atoi("-12345"));
        Assert.assertEquals(-1, atoi.atoi("-1"));
    }

    @Test
    public void zeroNumberTest() {
        Assert.assertEquals(0, atoi.atoi("0"));
        Assert.assertEquals(0, atoi.atoi("-0"));
    }

    @Test
    public void boundryNumberTest() {
        Assert.assertEquals(-2147483648, atoi.atoi("-2147483648")); // -2^31
        Assert.assertEquals(2147483647, atoi.atoi("2147483647")); // 2^31 - 1
        Assert.assertEquals(-2147483648, atoi.atoi("-3000000000"));
        Assert.assertEquals(2147483647, atoi.atoi("3000000000"));
    }

    @Test
    public void notDigitSuffixTest() {
        Assert.assertEquals(12345, atoi.atoi("12345.678"));
        Assert.assertEquals(12345, atoi.atoi("12345abc"));
    }


    @Test
    public void whitespaceTest() {
        Assert.assertEquals(12345, atoi.atoi(" 12345 "));
    }

    @Test
    public void emptyTest() {
        Assert.assertEquals(0, atoi.atoi(null));
        Assert.assertEquals(0, atoi.atoi(""));
    }
}
