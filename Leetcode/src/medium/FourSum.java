package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
        public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                
                // be careful of where j should start
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (j > 0 && nums[j] != nums[j - 1])) {

                        int left = j + 1, right = nums.length - 1;
                        while (left < right) {
                            long sum = nums[i] + nums[j] + nums[left] + nums[right];
                            if (sum == target) {
                                quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                while (left < right && nums[left + 1] == nums[left]) left++;
                                while (left < right && nums[right - 1] == nums[right]) right--;
                                left++;
                                right--;
                            }
                            else if (sum < target) {
                                // try larger sum
                                left++;
                            }
                            else {
                                // try smaller sum
                                right--;
                            }
                        }
                    }
                }
            }
        }
        return quadruplets;
    }
}
