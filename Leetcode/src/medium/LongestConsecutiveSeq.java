package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
        public static int longestConsecutive(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        // add each int to a set
        for (int i : nums) hashset.add(i);

        int longest  = 0;

        // for each element in the set
        for (int num : hashset) {
            // if the num is a start of a sequence
            // (by checking if the element before exists in the set)
            if (!hashset.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;
                
                // O(1) for seaching a set
                while (hashset.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longest = longest > currentLength ? longest : currentLength;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of the longest consecutive elements sequence is: " + longestConsecutive(nums));
    }
}
