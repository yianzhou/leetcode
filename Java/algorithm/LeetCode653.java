package algorithm;

import com.leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode653 {

    public boolean findTarget(TreeNode root, int k) {
        if (root==null) return false;

        Set<Integer> set = new HashSet<>();
        save(set, root);

        for (Integer value: set) {
            int diff = k - value;
            if (set.contains(diff) && diff!=value) return true;
        }
        return false;
    }

    // 将树的节点存进哈希表
    private void save(Set<Integer> set, TreeNode node) {
        if (node==null) return;
        set.add(node.val);
        save(set, node.left);
        save(set, node.right);
    }
}
