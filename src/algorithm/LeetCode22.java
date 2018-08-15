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
        // 深度优先的思路
        // 优先画左括号，直到左括号的数量为 n，右括号不会出现在左括号前
        if (left < n) {
            dfs(combination+"(", left+1, right, n);
        }

        // 为了使括号成对，当右括号数量小于左括号时，加上右括号
        if (left > right) {
            dfs(combination+")", left, right+1, n);
        }

        // 当左右括号数量都为 n 时，得到一个结果
        if (left == n && right == n) {
            result.add(combination);
        }
    }

    public static void main(String args[]) {
        LeetCode22 solution = new LeetCode22();
        System.out.println(solution.generateParenthesis(3));
    }

    // output: ["((()))","(()())","(())()","()(())","()()()"]
}
