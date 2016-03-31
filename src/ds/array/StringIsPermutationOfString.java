package ds.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Cracking The Coding Interview 1.3
 */
public class StringIsPermutationOfString {

    public boolean isPermutationWithMap(String s1, String s2) {

        if (s1 == s2) {
            return true;
        }

        // Null check
        if (s1 == null || s2 == null) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        // Store s1 into map
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        // Decrement s2 from map
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            int count = map.get(c);
            count--;
            if (count == 0) {
                map.remove(c);
            } else {
                map.put(c, count);
            }
        }

        return map.isEmpty();
    }

    public boolean isPermutationWithSort(String s1, String s2) {

        if (s1 == s2) {
            return true;
        }

        // Null check
        if (s1 == null || s2 == null) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1); Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

}
