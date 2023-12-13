package easy;

public class MoveZeros {

    // https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked

    public void moveZeroes(int[] nums) {
        // slower pointer (i) store non-zero value
        // quicker pointer (j) iterate and record non-zero value
        // insert 0s after slower pointer, so the zeros are 'moved'
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}
