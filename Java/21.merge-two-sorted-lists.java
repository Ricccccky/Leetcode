/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Iterative
        // ListNode head = new ListNode(-1);
        // ListNode temp = head;
        // while(l1 != null && l2 != null) {
        //     if (l1.val >= l2.val) {
        //         temp.next = l2;
        //         l2 = l2.next;
        //         temp = temp.next;
        //     } else {
        //         temp.next = l1;
        //         l1 = l1.next;
        //         temp = temp.next;
        //     }
        // }
        // if (l1 != null) {
        //     temp.next = l1;
        // }
        // if (l2 != null) {
        //     temp.next = l2;
        // }

        // return head.next;

        // Recursive
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }
}
// @lc code=end

