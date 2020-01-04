package algorithm;

// https://leetcode.com/problems/longest-common-prefix/description/

public class LeetCode14 {

    /*
    my solution:
    1. 先遍历数组，找出最小长度，防止下标越界
    2. 逐个比较字符
     */
    public String solution1(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int length = strs.length;
        int minLength = strs[0].length();
        for (int i = 1; i < length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            boolean equal = false;
            char c = strs[0].charAt(i);
            for (int j = 1; j < length; j++) {
                equal = strs[j].charAt(i) == c;
                if (!equal) break;
            }
            if (equal) res.append(c);
            else break;
        }
        return res.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        String prefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            i++;
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        LeetCode14 solution = new LeetCode14();
        solution.longestCommonPrefix(strs);
    }
}
