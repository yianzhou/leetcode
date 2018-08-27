package algorithm;

// https://leetcode.com/problems/remove-element/description/

public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;

        int pos = 0; // position
        int res = 0; // result: length
        int i = 0;
        while (i < length) {
            if (nums[i] != val) {
                nums[pos++] = nums[i];
                res++;
            }
            i++;
        }
        return res;
    }
}
