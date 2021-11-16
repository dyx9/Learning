package easy;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i]++;
                return digits;
            }
        }
        // if all elements are 9
        int[] result = new int[n+1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,9,9};
        System.out.println(Arrays.toString(plusOne(array)));
    }
}
