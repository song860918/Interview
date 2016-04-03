package ds.array;

public class CompressString {

    public String compress(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }

        char[] chars = input.toCharArray();
        String result = "";
        //Init: last set to first char. count is 1
        char last = chars[0]; int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (last != chars[i]) {
                result = result + last + count;
                last = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        result = result + last + count;


        // return whichever is shorter
        return result.length() >= input.length() ? input : result;
    }

}
