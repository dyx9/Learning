package medium;

public class nextPermutation {
    public void nextPermutation(int[] nums) {

        // start from the last 2 items
        int i = nums.length - 2;
        // if the left >= right, e.g., 1,2,[4],[3]
        // moving left to find left < right, e.g., 1,[2],[4],3
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        // if i >= 0, it means such a pair (nums[i], nums[i + 1]) was found
        // so it's possible to have a higher permutation
        if (i >= 0) {
            // start fron the last item
            int j = nums.length - 1;
            // moving left to find the relatively small int, e.g., 1,2(i),4,3(j)
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // swap the relatively samll int with cur i, e.g., 1,3,4,2
            swap(nums, i, j);
        }
        // sort the following to ensure the next (smallest) permutation
        // 1,[3],4,2 --> 1,[3],2,4
        reverse(nums, i + 1);

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // given an array, sort elements start from 'start'
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
