package ds.array;

/**
 * Cracking The Coding Interview 1.2
 * WARNING: This problem is not ideal to solve using Java.
 */
public class ReverseString {

    public String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            swap(chars, i, chars.length - i - 1);
        }

        return new String(chars);
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

}
