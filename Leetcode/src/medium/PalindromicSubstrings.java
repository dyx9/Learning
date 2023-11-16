package medium;


// https://leetcode.cn/problems/palindromic-substrings/solutions/154773/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/

public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int ans = 0;

        for (int centre = 0; centre < 2 * s.length() - 1; centre++) {
            int left = centre / 2 ;
            int right = left + centre % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }

        return ans;
    }
}
