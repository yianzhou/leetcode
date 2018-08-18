package algorithm;

import com.leetcode.ListNode;

// https://leetcode.com/problems/add-two-numbers/description/

public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode firstNode = result; // The first node is no use
        int carry = 0;

        while (l1 != null || l2 != null) { // stop when l1 and l2 both reach the end
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            result.next = new ListNode(carry % 10);
            result = result.next;
            carry /= 10;
        }

        if (carry > 0) { // the remain carry should take a new node
            result.next = new ListNode(carry);
        }

        return firstNode.next; // The first node is no use
    }
}
