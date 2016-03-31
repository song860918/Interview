package ds.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UniqueCharStringTest {

    private UniqueCharString uniqueCharString;

    @Before
    public void setUp() {
        uniqueCharString = new UniqueCharString();
    }

    @Test
    public void nonUniqueStringTest() {

        String input = "12e3ajbowifgwo869nbfj";
        Assert.assertFalse(uniqueCharString.isUnique(input));
        Assert.assertFalse(uniqueCharString.isUnique(input));
        Assert.assertFalse(uniqueCharString.isUnique(input));
    }

    @Test
    public void uniqueStringTest() {
        String input = "xyzhijklmnrstopqabcdefg9876543210";
        Assert.assertTrue(uniqueCharString.isUnique(input));
        Assert.assertTrue(uniqueCharString.isUnique(input));
        Assert.assertTrue(uniqueCharString.isUnique(input));

    }

}
