package algorithm;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/description/

public class LeetCode22 {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return result;
    }

    private void dfs(String combination, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(combination);
            return;
        }
        if (left < n) {
            dfs(combination+"(", left+1, right, n);
        }
        if (left > right) {
            dfs(combination+")", left, right+1, n);
        }
    }

    public static void main(String args[]) {
        LeetCode22 solution = new LeetCode22();
        System.out.println(solution.generateParenthesis(3));
    }

    // output: ["((()))","(()())","(())()","()(())","()()()"]
}
