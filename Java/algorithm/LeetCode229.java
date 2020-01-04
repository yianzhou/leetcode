package algorithm;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;


// https://leetcode.com/problems/majority-element-ii/description/

public class LeetCode229 {
    public List<Integer> majorityElement(int[] nums) {
        return majority(nums);
    }

    public List<Integer> majority(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // 将（数字，出现次数）存进哈希表
        HashMap<Integer, Integer> counters = new HashMap<>();
        for (Integer num : nums) {
            if (!counters.containsKey(num)) {
                counters.put(num, 1);
            } else {
                counters.put(num, counters.get(num) + 1);
            }
        }

        int threshold = nums.length/3;
        for (Integer key : counters.keySet()) {
            if (counters.get(key) > threshold ) {
                result.add(key);
            }
        }
        return result;
    }
}
