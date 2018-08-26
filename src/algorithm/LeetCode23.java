package algorithm;

// https://leetcode.com/problems/merge-k-sorted-lists/description/

import com.leetcode.ListNode;

public class LeetCode23 {

    // divide and conquer
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        if (lists.length == 0) return null;

        return divideAndConquer(lists, 0, lists.length -1);
    }

    private ListNode divideAndConquer(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = lo + (hi - lo)/2;
        ListNode l1 = divideAndConquer(lists, lo, mid);
        ListNode l2 = divideAndConquer(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    // merge two LinkedList
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
