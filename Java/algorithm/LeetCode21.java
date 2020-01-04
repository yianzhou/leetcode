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

        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
