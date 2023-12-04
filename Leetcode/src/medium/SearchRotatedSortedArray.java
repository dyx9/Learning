package medium;

public class SearchRotatedSortedArray {

    public int searchRotatedSortedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        // left and right pointer for binary search
        int left = 0, right = nums.length - 1;

        // use <= to include cases like only two elements (consider all)
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // split the array by mid element
            // either the left side or the right side must be sorted
            // if the left part is sorted:
            if (nums[left] <= nums[mid]) {
                // typical binary search
                // left <= target < mid
                //  <= left to include the end element
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            // or the right part is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }    
}
