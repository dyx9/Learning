package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    // public static int lengthOfLongestSubstring(String s) {

    //     Set<Character> existing = new HashSet<>();
    //     int n = s.length();

    //     int rightPtr = -1, length = 0;
    //     // i: left pointer
    //     for (int i = 0; i < n; i++) {
    //         if (i != 0) {
    //             // remove char at original left pointer (i - 1)
    //             existing.remove(s.charAt(i - 1));
    //         }
    //         while (rightPtr + 1 < n && !existing.contains(s.charAt(rightPtr + 1))) {
    //             existing.add(s.charAt(rightPtr + 1));
    //             rightPtr++;
    //         }

    //         length = Math.max(length, rightPtr - i + 1);
    //     }
    //     return length;
    // }

    public static int lengthOfLongestSubstring(String s) {

        // a map tracks each character and its index in String s
        HashMap<Character, Integer> map = new HashMap<>();
        
        // the start point of the longest substring
        int left = 0;

        // current max length of the longest substring
        int max = 0;

        // loop each char in String s
        for (int i = 0; i < s.length(); i++) {

            // if the current char appears in the longest substring
            if (map.containsKey(s.charAt(i))) {

                // move the start pointer to the new longest substring
                // it is important to check if the new start point ( map.get(s.charAt(i)) + 1 ) 
                // > original start point (left), e.g., a test case would be "abba"
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }

            // add each char and its index to the map, or update its latest index if exists
            map.put(s.charAt(i), i);

            // compare the length of found max substring (max) and the current substring (i - left + 1)
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}