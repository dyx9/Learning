package easy;

public class Palindrome {

    public static boolean isPalindrome(int x) {
        String input = Integer.toString(x);
        char [] array = input.toCharArray();;

        int i = 0;
        int j = array.length - 1;
        if (array[0] == '-') return false;
        else if (array.length % 2 == 0) {
            while (i <= array.length / 2 && j >= array.length / 2) {
                if (array[i] == array[j]) {
                    i++;
                    j--;
                }
                else return false;
            }
        }
        else {
            while (i < array.length / 2 && j > array.length / 2) {
                if (array[i] == array[j]) {
                    i++;
                    j--;
                }
                else return false;
            }
        }
        return true;
    }

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
