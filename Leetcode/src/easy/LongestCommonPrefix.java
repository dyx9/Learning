package easy;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // make the first string as the prefix
        String prefix = strs[0];

        // start from the second string
        for (int i = 1; i < strs.length; i++) {
            // while the prefix does not appear in any other strings
            while (strs[i].indexOf(prefix) != 0) {
                // shorten the prefix by remove the last char
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String [] input = new String [] {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(input));
    }

}
