package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        // i is the 'fixed' index
        // i < num.length - 2 ensures there're at least 3 items
        for (int i = 0; i < nums.length - 2; i ++) {
            // process the first item
            // remove duplicates if current item == the previous one
            if (i == 0 || i > 0 && (nums[i] != nums[i-1])) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    // if found a match
                    if (nums[i] + nums[j] + nums[k] == 0  ) {
                        // add triplets to list
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        // remove duplicates, also ensure j < k
                        while (j < k && nums[j+1] == nums[j]) j++;
                        while (j < k && nums[k-1] == nums[k]) k--;
                        // since the array is sorted, and removed duplicates
                        // both pointers will be moved at this time
                        // beacause if move only one of them at this time will
                        // definitely cause nums[i] + nums[j] + nums[k] != 0
                        j++;
                        k--;
                    }
                    // if sum < 0, try larger item by increment j
                    else if (nums[i] + nums[j] + nums[k] < 0) j++;
                    // if sum > 0, try samller item by decrement k
                    else k--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums).toString());
    }
}
