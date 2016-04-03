package ds.recursion;

/**
 * Cracking The Coding Interview 9.5
 */
public class StringPermutation {

    public void allPermutation(String input) {
        if (input == null) {
            return;
        }
        allPermutationHelper(input, "");
    }

    private void allPermutationHelper(String input, String result) {

        if (input.isEmpty()) {
            System.out.println(result);
        }

        for (int i = 0; i < input.length(); i++) {
            allPermutationHelper(input.substring(0, i) + input.substring(i + 1), result + input.charAt(i));
        }

    }

}
