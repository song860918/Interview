package ds.sorting;

import util.TODO;

import java.util.Collections;
import java.util.List;

public class BinarySearch {

    @TODO
    public static <T extends Comparable<T>> int find(List<T> list, T key) {
        return Collections.binarySearch(list, key);
    }

    @TODO
    public static <T extends Comparable<T>> int findWithinRange(List<T> list, T key, int startIndex, int endIndex) {
        return Collections.binarySearch(list, key);
    }

}
