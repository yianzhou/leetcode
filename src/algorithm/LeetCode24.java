package algorithm;

// https://leetcode.com/problems/swap-nodes-in-pairs/description/

import com.leetcode.ListNode;

public class LeetCode24 {

    /*
    1 -> 2 -> 3 -> 4 -> NULL
     */
    public ListNode swapPairs(ListNode head) {
        return swap(head);
    }

    private ListNode swap(ListNode x) {
        if (x == null) return null;
        if (x.next == null) return x;

        ListNode second = x.next;
        x.next = swap(second.next);
        second.next = x;
        return second;
    }
}
