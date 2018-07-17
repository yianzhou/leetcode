package algorithm;

import com.leetcode.TreeNode;

public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    private TreeNode invert(TreeNode x) {
        if (x==null) return null;

        TreeNode exch = x.left;
        x.left = x.right;
        x.right = exch;
        invert(x.left);
        invert(x.right);
        return x;
    }
}
