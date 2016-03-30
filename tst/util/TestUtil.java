package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestUtil {

    public static List<Integer> randomIntegerList() {
        return randomIntegerList(100);
    }

    public static List<Integer> randomIntegerList(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        Collections.shuffle(list);

        System.out.println(list);
        return list;
    }

}
