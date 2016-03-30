package ds.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(List<T> list) {
        if (list == null && list.isEmpty()) {
            return;
        }

        sortHelper(list, 0, list.size() - 1);
    }

    private void sortHelper(List<T> list, int start, int end) {
        // No element or 1 element
        if (start >= end) {
            return;
        }

        // First sort
        int mid = (start + end) / 2;
        sortHelper(list, start, mid);
        sortHelper(list, mid + 1, end);

        //Then merge, remember to use a temp array for merging
        merge(list, start, mid, end);

    }

    private void merge(List<T> list, int start1, int end1, int end2) {
        int start2 = end1 + 1;
        List<T> temp = new ArrayList<>();

        int i1 = start1; int i2 = start2;
        while (i1 <= end1 && i2 <= end2) {
            if (list.get(i1).compareTo(list.get(i2)) < 0) {
                temp.add(list.get(i1++));
            } else {
                temp.add(list.get(i2++));
            }
        }

        // Cleaning loose ends
        while (i1 <= end1) {
            temp.add(list.get(i1++));
        }
        while (i2 <= end2) {
            temp.add(list.get(i2++));
        }

        for (int i = start1; i <= end2; i++) {
            list.set(i, temp.get(i - start1));
        }

    }
}
