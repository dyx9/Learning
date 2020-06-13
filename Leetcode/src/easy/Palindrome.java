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

}
