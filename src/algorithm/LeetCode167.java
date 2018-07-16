package algorithm;

// https://leetcode.com/problems/two-sum/description/

import java.util.HashMap;
import java.util.Map;

public class LeetCode167 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<length;i++) {
            map.put(nums[i], i);
        }
        for (int i=0;i<length;i++) {
            int diff = target-nums[i];
            if (map.containsKey(diff) && map.get(diff)!=i ) {
                result[0] = i;
                result[1] = map.get(diff);
                return result;
            }
        }
        return result;
    }
}
