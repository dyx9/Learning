package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    // O(n)
    public static int[] twoSumHash(int [] nums, int target) {

        // use hashmap to remember previous visited number
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            // store visited number and its index 
            map.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int [] input = new int[] {1,1,1,1,1,4,1,1,1,1,1,7,1,1,1,1,1};
        System.out.println(Arrays.toString(twoSumHash(input, 11)));
    }
}
