package algorithm;

import com.leetcode.TreeNode;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

public class LeetCode111 {
    public int minDepth(TreeNode root) {
        // write your code here
        return _minDepth(root);
    }

    private int _minDepth(TreeNode x) {
        if (x==null) return 0;
        if (x.left==null) return 1+_minDepth(x.right);
        if (x.right==null) return 1+_minDepth(x.left);

        return 1+Math.min(_minDepth(x.left), _minDepth(x.right));
    }
}
