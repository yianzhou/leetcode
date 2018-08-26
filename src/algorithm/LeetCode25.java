package algorithm;

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/

import com.leetcode.ListNode;

public class LeetCode25 {
    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> NULL

    // 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 7 -> 8 -> NULL

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;

        // move k times
        int count = 0;
        while (count < k) {
            if (curr == null) return head; // number of nodes is NOT multiple of k
            curr = curr.next;
            count++;
        }

        curr = reverseKGroup(curr, k);

        while (count > 0) { // k - 1 times
            ListNode second = head.next;
            head.next = curr;
            curr = head;
            head = second;
            count--;
        }

        return curr;
    }
}
