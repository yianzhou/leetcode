package algorithm;

// https://leetcode.com/problems/longest-palindromic-substring/description/

public class LeetCode5 {

    /*
    The idea:
    For each char in string, extend to both side and find the longest Palindrome.
     */

    // [lo, hi] is the final longest Palindrome
    private int startIndex = 0;
    private int endIndex = 0;

    private int len = 0; // string's length

    public String longestPalindrome(String s) {
        if (s == null) return null;

        len = s.length();

        if (len <= 1) return s;

        char[] chs = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            extend(chs, i, i); // try to find palindrome which length is odd
            extend(chs, i, i+1); // try to find palindrome which length is even
        }

        return s.substring(startIndex, endIndex+1);
        // startIndex: inclusive
        // endIndex: exclusive
    }

    private void extend(char[] s, int lo, int hi) {
        while (lo >= 0 && hi < len && s[lo] == s[hi]) {
            lo--;
            hi++;
        }
        lo++; hi--; // back to the last valid match

        if ((endIndex - startIndex) < (hi - lo)) {
            startIndex = lo;
            endIndex = hi;
        }
    }

    public static void main(String[] args) {
        LeetCode5 solution = new LeetCode5();

        String s1 = "babad";

        System.out.printf(solution.longestPalindrome(s1));
    }
}
