package easy;

import java.util.Arrays;

/**
 * remove duplicates in a sorted array
 * return the length of the portion without duplicates
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

/*    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                if (i != j-1) swap(nums,i+1,j);
                i++;
            }
        }

        int count = 0;
        for (int k = 1; k < nums.length; k++) {
            if (nums[k] > nums[k-1]) {
                count++;
            }
        else break;
        }
        return count+1;
}

    private static void swap(int [] nums, int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
*/


    public static void main(String[] args) {
        int [] input = {0,1,1,2};
        System.out.println(removeDuplicates(input));
    }
}
