package ds.array;

import org.junit.Assert;
import org.junit.Test;

public class StringIsPermutationOfStringTest {

    private StringIsPermutationOfString stringIsPermutationOfString = new StringIsPermutationOfString();

    @Test
    public void isPermutationWithMapTest() {
        Assert.assertTrue(stringIsPermutationOfString.isPermutationWithMap("abcd", "cdba"));
        Assert.assertTrue(stringIsPermutationOfString.isPermutationWithMap("aabbcddc", "cddcabba"));
        Assert.assertFalse(stringIsPermutationOfString.isPermutationWithMap("aabbcddc", "cddabba"));
        Assert.assertFalse(stringIsPermutationOfString.isPermutationWithMap("aabbcddc", "cddabbb"));
    }

    @Test
    public void isPermutationWithSortTest() {
        Assert.assertTrue(stringIsPermutationOfString.isPermutationWithSort("abcd", "cdba"));
        Assert.assertTrue(stringIsPermutationOfString.isPermutationWithSort("aabbcddc", "cddcabba"));
        Assert.assertFalse(stringIsPermutationOfString.isPermutationWithSort("aabbcddc", "cddabba"));
        Assert.assertFalse(stringIsPermutationOfString.isPermutationWithSort("aabbcddc", "cddabbb"));
    }

}
