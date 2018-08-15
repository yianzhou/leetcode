package algorithm;

import com.sun.tools.javac.util.Assert;
import jdk.internal.jline.internal.TestAccessible;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/generate-parentheses/description/

public class LeetCode32 {

    public int longestValidParentheses(String s) {
        int max = 0; // the length of the Longest Valid Parentheses, to return

        Stack<Integer> stack = new Stack<>();
        int arrow = 0; // point to the leftest valid '('

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') { // 左括号
                stack.push(i); // 当前位置入栈
            }
            else if (stack.isEmpty()) { // 右括号且空栈
                arrow = i+1; // 记录当前位置
            }
            else { // 右括号，栈不为空
                stack.pop();
                if (stack.isEmpty()) max = Math.max(max, i - arrow + 1);
                else max = Math.max(max, i - stack.peek());
            }
        }

        return max;
    }

    public static void main(String args[]) {
        String case1 = "((()))";
        String case2 = "()(()";

        LeetCode32 solution = new LeetCode32();
        System.out.println(solution.longestValidParentheses(case1));
    }
}
