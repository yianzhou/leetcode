package algorithm;

// https://leetcode.com/problems/3sum-closest/description/

import java.util.Arrays;

public class LeetCode16 {
    /*
    1. 先排序
    2. 遍历数组，头尾指针分别向中间移动。
     */
    public int threeSumClosest(int[] nums, int target) {
        int res = 0; // result value
        if (nums == null || nums.length < 3) return res; // boundary

        Arrays.sort(nums); // sort

        int length = nums.length;
        res = nums[0] + nums[1] + nums[length - 1]; // initial value
        for (int i = 0; i < length - 2; i++) {
            int lo = i + 1;
            int hi = length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];

                // move pointers
                if (sum > target) hi--;
                else lo++;

                if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
            }
        }
        return res;
    }
}
