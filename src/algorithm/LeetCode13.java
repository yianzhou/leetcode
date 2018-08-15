package algorithm;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/description/

public class LeetCode13 {

    // 罗马数字字典
    private static Map<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public int romanToInt(String s) {
        int length = s.length();
        int result = 0; // final result
        int next = 0; // the value next to the current one

        // 反向遍历
        for (int i=length-1; i>=0; i--) {
            char key = s.charAt(i);
            int value = map.get(key);

            if (value >= next) {
                result += value;
            }
            else {
                result -= value;
            }

            next = value;
        }

        return result;
    }
}
