/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
    public ListNode deleteDuplicates(ListNode head) {
        // Recursive
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // head.next = deleteDuplicates(head.next);
        // if (head.val == head.next.val) {
        //     return head.next;
        // } else {
        //     return head;
        // }

        // Iterative
        ListNode ptr = head;
        while (ptr != null && ptr.next != null) {
            if (ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }

        return head;
    }
}
// @lc code=end

