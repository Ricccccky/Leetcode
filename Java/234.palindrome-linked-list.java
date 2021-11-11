/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        // Reverse rear half of list and compare with front part
        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ptr = head;
        while (ptr.next != slow) {
            ptr = ptr.next;
        }
        ptr.next = null;
        fast = new ListNode(-1);
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            slow = next;
        }
        fast = fast.next;
        while (fast != null) {
            if (fast.val != head.val) {
                return false;
            }
            fast = fast.next;
            head = head.next;
        }

        return true;
    }
}
// @lc code=end

