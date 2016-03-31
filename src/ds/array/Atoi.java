package ds.array;


/**
 * The following use cases are covered:
 * 1. null or empty string
 * 2. white spaces
 * 3. +/- sign
 * 4. handle min & max
 */
public class Atoi {

    public int atoi(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        input = input.trim();

        boolean isNegative = false;

        if (input.charAt(0) == '-') {
            isNegative = true;
            input = input.substring(1);
        } else if (input.charAt(0) == '+') {
            input = input.substring(1);
        }

        int result = 0;

        for (char c : input.toCharArray()) {
            if (!isDigit(c)) {
                break;
            }

            int digit = (c - '0');

            if (willOverflow(result, digit, isNegative)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
        }

        if (isNegative) {
            result = 0 - result;
        }

        return result;
    }

    private boolean isDigit(char c) {
        return c - '0' >= 0 && c - '9' <= 0;
    }

    private boolean willOverflow(int result, int digit, boolean isNegative) {
        if (isNegative) {
            return (Integer.MIN_VALUE + digit) / 10 > (0 - result);
        } else {
            return (Integer.MAX_VALUE - digit) / 10 < result;
        }

    }

}
