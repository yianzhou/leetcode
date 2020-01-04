package algorithm;

import java.util.HashMap;

// https://leetcode.com/problems/majority-element/

public class LeetCode169 {
    public int majorityElement(int[] nums) {
        return majority(nums);
    }

    public int majority(int[] nums) {
        int length = nums.length;

        //boundary
        if (length == 0) return -1;
        if (length == 1) return nums[0];

        // 将（数字，出现次数）存进哈希表
        HashMap<Integer, Integer> counters = new HashMap<>();
        for (Integer num : nums) {
            if (!counters.containsKey(num)) {
                counters.put(num, 1);
            } else {
                counters.put(num, counters.get(num) + 1);
            }
        }

        for (Integer key : counters.keySet()) {
            if (counters.get(key) > length/2 ) {
                return key;
            }
        }
        return 0;
    }
}
