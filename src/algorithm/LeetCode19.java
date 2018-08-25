package algorithm;

import com.leetcode.ListNode;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

public class LeetCode19 {
    /*
    1 -> 2 -> 3 -> 4 -> 5;
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode aux = new ListNode(0);
        aux.next = head; // auxiliary node

        ListNode front = aux, back = aux;

        // front pointer moves first
        int i = 0;
        while (i <= n) {
            front = front.next; // move n+1 times
            i++;
        }

        // two pointers move together
        while(front != null) {
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;

        return aux.next;
    }
}
