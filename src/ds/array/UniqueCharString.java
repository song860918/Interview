package ds.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Cracking The Coding Interview 1.1
 */
public class UniqueCharString {

    public boolean isUniqueWithSet(String input) {
        Set<Character> set = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }

        return true;
    }

    public boolean isUniqueWithSort(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public boolean isUnique(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

}
