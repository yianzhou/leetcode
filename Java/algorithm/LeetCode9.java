package algorithm;

// https://leetcode.com/problems/palindrome-number/

public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int origin = x;
        int result = 0;
        while (x != 0) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        return origin == result;
    }
}
