package easy;

public class Palindrome {

    public static boolean isPalindrome(int x) {

        // negative nums or the last digit is 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        String s = Integer.toString(x);
        
        // pointer to the last digit
        int end = s.length()-1;

        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == s.charAt(end)) {
                end -= 1;
            }
            else {
                return false;
            }
        }
        return true;

    }

    // math version

    // public boolean isPalindrome(int x) {
    //     if (x < 0 || (x % 10 == 0 && x != 0)) {
    //         return false;
    //     }

    //     int revertedNumber = 0;
    //     while (x > revertedNumber) {
    //         revertedNumber = revertedNumber * 10 + x % 10;
    //         x /= 10;
    //     }

    //     return x == revertedNumber || x == revertedNumber / 10;
    // }



    public static boolean isPalindrome(String s) {
        StringBuilder preProcess = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                preProcess.append(Character.toLowerCase(c));
            }
        }

        StringBuilder reverse = new StringBuilder(preProcess).reverse();
        return preProcess.toString().equals(reverse.toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome("race a car"));
    }

}
