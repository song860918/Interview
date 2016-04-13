package ds.sorting;

import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(List<T> list) {

        if (list == null || list.isEmpty()) {
            return;
        }

        sortHelper(list, 0, list.size() - 1);

    }

    public void sortHelper(List<T> list, int start, int end) {

        if (start >= end) {
            return;
        } else if (end - start == 1) {
            Collections.swap(list, start, end);
        }

        //Find pivot
        int pivot = (start + end) / 2;
        Collections.swap(list, pivot, end);
        // i is the leftmost element that is >= pivot
        int i = end;
        // j is the rightmost unprocessed element
        int j = 0;
        while (i > j) {
            if (list.get(j).compareTo(list.get(end)) < 0) {
                j++;
            } else {
                i--;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i, end);
        sortHelper(list, start, i - 1);
        sortHelper(list, i + 1, end);
    }
}
