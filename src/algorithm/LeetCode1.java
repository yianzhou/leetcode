package algorithm;

// https://leetcode.com/problems/two-sum/description/

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        // 将（数值，位置）放进一个哈希表
        for (int i = 0; i < length; i++) {
            map.put(nums[i], i);
        }

        // 在哈希表中寻找差值
        for (int i = 0; i < length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i ) {
                result[0] = i;
                result[1] = map.get(diff);
                return result;
            }
        }

        return result;
    }
}
