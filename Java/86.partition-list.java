/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);
        ListNode lessPtr = lessHead;
        ListNode greaterPtr = greaterHead;
        while (head != null) {
            if (head.val < x) {
                lessPtr.next = head;
                lessPtr = lessPtr.next;
            } else {
                greaterPtr.next = head;
                greaterPtr = greaterPtr.next;
            }
            head = head.next;
        }
        greaterPtr.next = null;
        lessPtr.next = greaterHead.next;

        return lessHead.next;
    }
}
// @lc code=end

