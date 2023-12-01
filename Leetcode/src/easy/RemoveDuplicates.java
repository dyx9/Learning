package easy;


/**
 * remove duplicates in a sorted array
 * return the length of the portion without duplicates
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        //  left pointer i points to the latest sorted unduplicated item
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // if value of left pointer != that of right pointer
            // which meams we find the next unduplicate value
            if (nums[i] != nums[j]) {
                // increment the left pointer, which give the new index to store the found duplicate
                i++;
                nums[i] = nums[j];
            }
            // if value of left pointer == that of right pointer
            // -> dupilicated value, keep moving right pointer
        }
        return i+1;
    }



    public static void main(String[] args) {
        int [] input = {0,1,1,2};
        System.out.println(removeDuplicates(input));
    }
}
