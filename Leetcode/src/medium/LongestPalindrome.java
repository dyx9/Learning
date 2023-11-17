package medium;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int maxLength = 0;
        int maxLeft = 0;
        int maxRight = 0;

        for (int centre=0; centre < 2 * s.length() - 1; centre++) {
            int left = centre / 2;
            int right = left + centre % 2;

            while (left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
                if (right-left+1 > maxLength) {
                    maxLength = right-left+1;
                    maxLeft = left;
                    maxRight = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(maxLeft, maxRight+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcbabc"));
    }
}
