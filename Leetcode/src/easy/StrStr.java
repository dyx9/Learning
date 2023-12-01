package easy;

// https://leetcode-cn.com/problems/implement-strstr/

public class StrStr {
    // brute force, O(m*n)
    public static int strStr(String haystack, String needle) {
        // go through each char of a given string
        // i + substing len should <= string len, to avoid unnecessary check or Out-of-Bounds in 'while' 
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            
            // set another var stores i
            // because directly modifing i in 'while' can also alter i in 'for'
            int start = i;
            // set a pointer to go through substring
            int needlePtr = 0;

            // if char matches
            while (haystack.charAt(start) == needle.charAt(needlePtr)) {
                start++;
                needlePtr++;
                // break if reach the end of substring
                if (needlePtr >= needle.length()) break;
            }
            // if the substring has an occouance, return the start index
            if (needlePtr == needle.length()) return i;
        }
        return -1;
    }

    // KMP Algorithm O(m+n)
    public static int strStrKMP(String haystack, String needle) {
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
