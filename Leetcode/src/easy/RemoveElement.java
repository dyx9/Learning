package easy;

import java.util.Arrays;

public class RemoveElement {

    static int removeElement(int[] nums, int val) {

        int L = 0;  // slow pointer, track the latest correct int
        int R = 0;  // quick pointer, keep moving right 

        while (R < nums.length) {
            // if the next int is not the one we want to remove
            if (nums[R] != val) {
                // which means we want this, so 'add' the int
                nums[L] = nums[R];
                // increment the slow pointer to 'append' next wanted int
                L++;
            }
            // keep moveing the quicker pointer
            R++;
        }

        return L;

        // int i = 0;
        // int tail = nums.length;
        // while (i < tail) {
        //     if (nums[i] == val) {
        //         nums[i] = nums[tail - 1];
        //         // reduce array size by one
        //         tail--;
        //     } else {
        //         i++;
        //     }
        // }
        // return tail;

    }

    public static void main(String[] args) {
        int [] nums = {2,2,4,7,5,32,4,2,1 };
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}
