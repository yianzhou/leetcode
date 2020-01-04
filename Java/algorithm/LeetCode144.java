package algorithm;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> output = new ArrayList<>();
        print(root, output);
        return output;
    }

    public void print(TreeNode node, List<Integer> output) {
        if (node==null) return;
        output.add(node.val);
        print(node.left, output);
        print(node.right, output);
    }
}
