package algorithm;

import com.leetcode.ListNode;

// https://leetcode.com/problems/reverse-linked-list/

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        // boundary
        if (head == null) { return null; }

        ListNode a = head;
        ListNode b = head.next;

        head.next = null; // head become tail

        // 原地、一次遍历翻转
        while (b!=null) {
            ListNode temp = b.next;
            b.next = a;
            a = b;
            b = temp;
        }

        return a;
    }
}
