package algorithm;

import java.util.List;
import java.util.LinkedList;
import com.leetcode.TreeNode;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new LinkedList<>();
        levelOrder(root, result);
        return result;
    }

    public void levelOrder(TreeNode node, List<List<Integer>> result) {
        if (node == null) return; //boundary

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size(); // only loop for the current size!
            for (int i=0; i<size; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            result.add(level);
        }
    }
}
