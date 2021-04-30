import java.util.List;

/*
 * @lc app=leetcode id=445 lang=java
 *
 * [445] Add Two Numbers II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ptr.next = new ListNode(carry % 10);
            ptr = ptr.next;
            carry /= 10;
        }

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode l) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = l;
        while (ptr != null) {
            ListNode next = ptr.next;
            ptr.next = dummy;
            dummy = ptr;
            ptr = next;
        }
        ptr = dummy;
        while (ptr.next.val >= 0) {
            ptr = ptr.next;
        }
        ptr.next = null;

        return dummy;
    }
}
// @lc code=end

