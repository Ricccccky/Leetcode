/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = null, cur = head;
        while (left > 1) {
            pre = cur;
            cur = cur.next;
            left--;
            right--;
        }
        ListNode prev = pre, tail = cur;
        while (right-- > 0) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (prev != null) {
            prev.next = pre;
        } else {
            head = pre;
        }
        tail.next = cur;

        return head;
    }
}
// @lc code=end

