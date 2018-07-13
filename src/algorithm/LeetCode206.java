package algorithm;

import com.leetcode.ListNode;

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        // boundary
        if (head == null) { return null; }

        ListNode a = head;
        ListNode b = head.next;

        head.next = null;

        while (b!=null) {
            ListNode temp = b.next;
            b.next = a;
            a = b;
            b = temp;
        }

        return a;
    }
}
