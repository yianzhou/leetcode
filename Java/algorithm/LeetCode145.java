package algorithm;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-postorder-traversal/description/

public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> output = new ArrayList<>();
        print(root, output);
        return output;
    }

    public void print(TreeNode node, List<Integer> output) {
        if (node==null) return;
        print(node.left, output);
        print(node.right, output);
        output.add(node.val);
    }
}
