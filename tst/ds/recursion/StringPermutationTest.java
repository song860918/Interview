package ds.recursion;

import org.junit.Test;

public class StringPermutationTest {

    private StringPermutation stringPermutation = new StringPermutation();

    @Test
    public void stringPermutationTest() {
        stringPermutation.allPermutation(null);
        stringPermutation.allPermutation("");
        stringPermutation.allPermutation("a");
        stringPermutation.allPermutation("ab");
        stringPermutation.allPermutation("abc");
        stringPermutation.allPermutation("abcd");
    }


}
