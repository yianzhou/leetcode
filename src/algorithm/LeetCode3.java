package algorithm;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class LeetCode3 {

    /* Keep a HashMap (Character, position).
	 * keep two pointers which define the max substring - [left, right].
	 * Move the right pointer to scan through the string, and meanwhile update the HashMap.
	 * If the character is already in the HashMap, then move the left pointer to the right of the same character last found.
	 */

    public int idea(String s) {
        if (s == null) return 0; // boundary
        if (s.length() == 0) return 0; // boundary

        // variables
        Map<Character, Integer> map = new HashMap<>();
        int answer = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            answer = Math.max(answer, right - left + 1);
            map.put(c, right); // always override previous
        }

        return answer;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0; // boundary
        if (s.length() == 0) return 0; // boundary

        // variables
        int[] map = new int[128]; // default value: 0
        int answer = 0;

        for (int left = 0, right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map[c] > 0) {
                left = Math.max(left, map[c]); // no need to move the pointer because it already point to the next subscript
            }
            answer = Math.max(answer, right - left + 1);
            map[c] = right + 1;
            // we use subscript + 1 because the int[128] always have default value 0
            // in some boundary cases, this doesn't produce the right result
        }

        return answer;
    }
}
