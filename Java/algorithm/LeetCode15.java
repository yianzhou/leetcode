package algorithm;

// https://leetcode.com/problems/3sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    /*
    1. 先排序
    2. 遍历数组，头尾指针分别向中间移动。
    3. 注意跳过重复的数字，节省时间。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // result value

        if (nums == null || nums.length < 3) return res; // boundary

        Arrays.sort(nums);

        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // repeated numbers
            int lo = i + 1;
            int hi = length - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++; // repeated numbers
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--; // repeated numbers
                    lo++; hi--;
                }
                else if (sum > 0) hi--;
                else lo++;
            }
        }
        return res;
    }
}
