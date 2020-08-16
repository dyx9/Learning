package medium;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> existing = new HashSet<>();
        int n = s.length();

        int rightPtr = -1, length = 0;
        // i: left pointer
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                // remove char at original left pointer (i - 1)
                existing.remove(s.charAt(i - 1));
            }
            while (rightPtr + 1 < n && !existing.contains(s.charAt(rightPtr + 1))) {
                existing.add(s.charAt(rightPtr + 1));
                rightPtr++;
            }

            length = Math.max(length, rightPtr - i + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabc"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}