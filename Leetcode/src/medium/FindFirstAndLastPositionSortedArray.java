package medium;

public class FindFirstAndLastPositionSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return new int[]{-1, -1};

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};

    }

    private static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = -1;

        while (left <= right) {
            int mid  = (left + right) / 2;
            // if mid appears on the right side of the target
            // which means the first occurance may appear before mid
            if (nums[mid] >= target) {
                // keep searching the left part
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            // update the index if found an occurance
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    private static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, index = -1;

        while (left <= right) {
            int mid  = (left + right) / 2;
            // if mid appears on the left side of the target
            // which means the last occurance could appear after mid
            if (nums[mid] <= target) {
                // keep searching the right part
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
            // update the index if found an occurance
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10}; // Example array
        int target = 8;

        int[] positions = searchRange(nums, target);
        System.out.println("First position: " + positions[0]);
        System.out.println("Last position: " + positions[1]);
    }
}
