package algorithm;

import java.util.HashMap;

// https://leetcode.com/problems/majority-element/

public class LeetCode169 {
    public int majorityElement(int[] nums) {
        return majority(nums);
    }

    public int majority(int[] nums) {
        //boundary
        if (nums.length==0) return -1;
        if (nums.length==1) return nums[0];

        HashMap<Integer, Integer> counters = new HashMap<>();
        for (Integer num : nums) {
            if (!counters.containsKey(num)) {
                counters.put(num, 1);
            } else {
                counters.put(num, counters.get(num) + 1);
            }
        }

        int _key = 0;
        int _value = 0;
        for (Integer key : counters.keySet()) {
            if (counters.get(key) > _value ) {
                _value = counters.get(key);
                _key = key;
            }
        }
        return _key;
    }
}
