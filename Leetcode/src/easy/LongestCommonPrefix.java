package easy;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] str) {
        if (str == null || str.length == 0) {
            return "";
        }

        int length = str[0].length();
        int amount = str.length;
        for (int i = 0; i < length; i++) {
            char c = str[0].charAt(i);
            // start from the second element
            for (int j = 1; j < amount; j++) {
                // compare length before accessing the next element
                // if reverse the order, ["aa", "a"] will throw exception
                if (str[j].length() == i || str[j].charAt(i) != c) {
                    return str[0].substring(0,i);
                }
            }
        }
        return str[0];
    }

    public static void main(String[] args) {
        String [] input = new String [] {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(input));
    }

}
