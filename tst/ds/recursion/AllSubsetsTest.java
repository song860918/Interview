package ds.recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class AllSubsetsTest {

    private AllSubsets<Integer> allSubsets = new AllSubsets<>();

    @Test
    public void allSubsetsTest() {
        System.out.println(allSubsets.allSubsets(new HashSet<>(Arrays.asList(1, 2, 3))));
    }

}
