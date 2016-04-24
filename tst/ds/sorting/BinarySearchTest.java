package ds.sorting;

import org.junit.Assert;
import org.junit.Test;
import util.TestUtil;

public class BinarySearchTest {

    private BinarySearch bs = new BinarySearch();

    @Test
    public void findTest() {
        int[] arr = TestUtil.sortedIncrementedArray(100);
        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(i, bs.find(arr, i));
        }

        Assert.assertEquals(-1, bs.find(arr, 100));
    }

    @Test
    public void findIterativeTest() {
        int[] arr = TestUtil.sortedIncrementedArray(100);
        for (int i = 0; i < 100; i++) {
            Assert.assertEquals(i, bs.findIterative(arr, i));
        }

        Assert.assertEquals(-1, bs.find(arr, 100));
    }

    @Test
    public void searchTest() {
        int[] arr = new int[]{4,5,6,7,8,1,2,3};

        Assert.assertEquals(4, bs.search(arr, 8));
    }

    @Test
    public void findMinTest() {

    }

    @Test
    public void findMinWithDuplicatesTest() {
        int[] arr = new int[] {3, 3, 1, 3};

        Assert.assertEquals(1, bs.findMin(arr));
    }
}
