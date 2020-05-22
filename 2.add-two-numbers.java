/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode pre = head;
        int temp = 0;
        while (l1 != null || l2 != null || temp != 0) {
            ListNode result = new ListNode();
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += temp;
            temp = 0;

            if (sum < 10) {
                result.val = sum;
            } else {
                temp = sum / 10;
                result.val = sum % 10;
            }
            head.next = result;
            head = head.next;
        }
        return pre.next;
    }
}
// @lc code=end

