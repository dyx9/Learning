package easy;

import java.util.Arrays;
import java.util.List;

public class MaxEven {
    public static int getMaxEven(List<Integer> val) {
        int sum = 0;
        for (int number: val) {
            if (number > 0) {
                sum += number;
            }
        }

        if (sum % 2 == 0) return sum;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < val.size(); i++) {
            if (val.get(i) % 2 != 0) {
                if (val.get(i) > 0) {
                    ans = Math.max (sum, sum - val.get(i));
                }
                else {
                    ans = Math.max (sum, sum + val.get(i));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(5,-1,-2,-3,8,7);
        System.out.println(getMaxEven(test));
    }
}
