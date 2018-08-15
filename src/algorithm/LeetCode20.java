package algorithm;

// https://leetcode.com/problems/valid-parentheses/description/

import java.util.Stack;

public class LeetCode20 {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c); // 左括号则入栈
            }
            else if (stack.isEmpty()) {
                return false; // 空栈时出现右括号，返回false
            }
            else {
                char toMatch = stack.pop();
                if (toMatch == '(' && c == ')') ; // match
                else if (toMatch == '[' && c == ']') ; // match
                else if (toMatch == '{' && c == '}') ; // match
                else { return false; } // 括号不匹配，返回false
            }
        }

        return stack.isEmpty();
    }
}
