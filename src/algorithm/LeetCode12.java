package algorithm;

// https://leetcode.com/problems/integer-to-roman/description/

import java.util.Collections;

public class LeetCode12 {
    public String intToRoman(int num) {
        int[] intergers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        int i = 0;
        while (num > 0) {
            int truncated = num / intergers[i];
            if (truncated > 0) {
                // repeat a roman for n times
                result.append(String.join("", Collections.nCopies(truncated, romans[i])));
                num -= intergers[i] * truncated;
            }
            i++;
        }

        return result.toString();
    }
}
