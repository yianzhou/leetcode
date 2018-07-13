package algorithm;

import com.leetcode.TreeNode;

// https://leetcode.com/problems/balanced-binary-tree/description/

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return _isBalanced(root);
    }

    private boolean _isBalanced(TreeNode x) {
        if (x == null) return true;
        return (Math.abs(height(x.left)-height(x.right)) <= 1)
                && isBalanced(x.left)
                && isBalanced(x.right);
    }

    private int height(TreeNode x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }
}
