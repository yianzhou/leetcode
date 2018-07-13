package algorithm;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/

public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> output = new ArrayList<>();
        print(root, output);
        return output;
    }

    public void print(TreeNode node, List<Integer> output) {
        if (node==null) return;
        print(node.left, output);
        output.add(node.val);
        print(node.right, output);
    }
}
