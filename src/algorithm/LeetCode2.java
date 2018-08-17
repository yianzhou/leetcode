package algorithm;

import com.leetcode.ListNode;

// https://leetcode.com/problems/add-two-numbers/description/

public class LeetCode2 {
    // Solution version 1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode firstNode = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            result.next = newNode;
            result = result.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }

        return firstNode.next; // The first node is no use
    }

}
