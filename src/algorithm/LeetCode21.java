package algorithm;

import com.leetcode.ListNode;

// https://leetcode.com/problems/merge-two-sorted-lists/description/

public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;

        ListNode x;
        if (l1.val < l2.val) {
            x = l1;
            x.next = merge(l1.next, l2);
        }
        else {
            x = l2;
            x.next = merge(l1, l2.next);
        }
        return x;
    }
}
