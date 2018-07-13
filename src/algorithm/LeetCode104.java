package algorithm;

import com.leetcode.TreeNode;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        // write your code here
        return depth(root);
    }

    private int depth(TreeNode x) {
        if (x==null) return 0;
        return 1+Math.max(depth(x.left), depth(x.right));
    }

    public static void main(String[] args) {
        // write your code here
    }
}
