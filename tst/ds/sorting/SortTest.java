package ds.sorting;

import org.junit.Assert;
import org.junit.Test;
import util.TestUtil;

import java.util.List;

public abstract class SortTest {

    protected Sort<Integer> sort;

    @Test
    public void sortTest() {
        List<Integer> list = TestUtil.randomIntegerList();
        sort.sort(list);

        verifySorted(list);
    }

    private void verifySorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 2; i++) {
            if (list.get(i) > list.get(i + 1)) {
                Assert.fail();
            }
        }
    }

}
