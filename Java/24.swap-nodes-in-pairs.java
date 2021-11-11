/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Recursive
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode dummy = head.next;
        // head.next = swapPairs(dummy.next);
        // dummy.next = head;

        // return dummy;

        // Iterative
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode ptr = pre.next;
            ListNode next = ptr.next;
            pre.next = next;
            ptr.next = next.next;
            next.next = ptr;
            pre = ptr;
        }

        return dummy.next;
    }
}
// @lc code=end

