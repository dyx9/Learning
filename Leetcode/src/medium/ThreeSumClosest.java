package medium;

import java.util.Arrays;

public class ThreeSumClosest {
        public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // process the first iteration and remove duplicates
            if (i == 0 || i > 0 && (nums[i] != nums[i-1])) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) return target;
                    else if (sum < target) {
                        res = Math.abs(target - res) < target - sum ? res : sum;
                        j++;
                    }
                    else {
                        res = Math.abs(target - res) < sum - target ? res : sum;
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
