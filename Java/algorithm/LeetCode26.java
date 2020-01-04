package algorithm;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;

        // nums[0] is in its final place
        int res = 1;
        int curr = 1;
        int i = 1;
        while (i < length) {
            if (nums[i] != nums[i-1]) {
                nums[curr++] = nums[i];
                res++;
            }
            i++;
        }
        return res;
    }
}
