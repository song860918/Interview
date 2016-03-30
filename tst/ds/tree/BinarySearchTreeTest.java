package ds.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTree;

    @Before
    public void setUp() {
        binarySearchTree = new BinarySearchTree<>();
    }

    private List<Integer> randomIntegerList() {
        Integer[] arr = new Integer[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        Collections.shuffle(list);

        return list;
    }

    @Test
    public void preOrderTraversalTest() {
        List<Integer> list = Arrays.asList(5, 1, 7, 3, 6, 4, 2);
        for (int i : list) {
            binarySearchTree.insert(i);
        }
        list.sort(Comparator.naturalOrder());

        Assert.assertEquals(Arrays.asList(5, 1, 3, 2, 4, 7, 6), binarySearchTree.preOrderTraversal());
    }

    @Test
    public void inOrderTraversalTest() {
        List<Integer> list = randomIntegerList();
        for (int i : list) {
            binarySearchTree.insert(i);
        }
        list.sort(Comparator.naturalOrder());

        Assert.assertEquals(list, binarySearchTree.inOrderTraversal());
    }

    @Test
    @Ignore
    public void postOrderTraversalTest() {
        List<Integer> list = Arrays.asList(5, 1, 7, 3, 6, 4, 2);
        for (int i : list) {
            binarySearchTree.insert(i);
        }
        list.sort(Comparator.naturalOrder());

        Assert.assertEquals(Arrays.asList(2, 4, 3, 1, 6, 7, 5), binarySearchTree.preOrderTraversal());
    }

    @Test
    public void insertTest() {
        List<Integer> list = randomIntegerList();

        for (int i : list) {
            binarySearchTree.insert(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int i : binarySearchTree) {
            result.add(i);
        }

        Collections.sort(list);

        Assert.assertTrue(result.equals(list));
    }

    @Test
    public void findTest() {
        List<Integer> list = randomIntegerList();

        for (int i : list) {
            binarySearchTree.insert(i);
        }

        for (int i : list) {
            Assert.assertTrue(binarySearchTree.find(i));
        }

        Assert.assertFalse(binarySearchTree.find(100));
    }

    @Test
    public void deleteTest() {
        List<Integer> list = randomIntegerList();
        //System.out.println(list);
        for (int i : list) {
            binarySearchTree.insert(i);
        }

        for (int i : list) {
            Assert.assertTrue(binarySearchTree.find(i));
            binarySearchTree.delete(i);
            Assert.assertFalse(binarySearchTree.find(i));
            //System.out.println("Verified " + i);
        }
    }

}
