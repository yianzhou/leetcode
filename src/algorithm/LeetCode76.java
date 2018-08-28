package algorithm;

// https://leetcode.com/problems/minimum-window-substring/description/

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    /*
    题目描述：If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
    思路：
    1. 从下标 0 开始伸展，直到包含所有 target 里的字符，确定窗口的右端点；
    2. 再从下标 0 开始缩小，确定窗口的左端点。
    3. 滑动窗口
     */

    public String minWindow(String s, String t) {
        // init a HashMap of target
        int[] map = new int[128]; // ASCII
        for(char c: t.toCharArray()) // t.toCharArray() is executed only once.
            map[c]++;

        int wStart = -1; // final window start index
        int wSize = Integer.MAX_VALUE; // final window end index

        int left = 0;
        int right = 0;
        int counter = 0; // include all chars in target

        while (right < s.length()) { // right pointer slides
            if (map[s.charAt(right)] > 0) {
                counter++; // match
            }
            map[s.charAt(right)]--; // If char does not exist in t, will be negative.
            right++;
            while (counter == t.length()) { // window contains all chars
                if ((right - left) < wSize) {
                    wStart = left;
                    wSize = right - left;
                }
                map[s.charAt(left)]++; // left pointer slides
                if (map[s.charAt(left)] > 0) {
                    counter--; // When char exists in t, decrease counter.
                }
                left++;
            }
        }
        return wStart != -1 ? s.substring(wStart, wStart + wSize) : "";
    }
}
