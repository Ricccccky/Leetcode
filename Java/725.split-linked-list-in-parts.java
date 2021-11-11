/*
 * @lc app=leetcode id=725 lang=java
 *
 * [725] Split Linked List in Parts
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode[] res = new ListNode[k];
        ListNode ptr = head;
        while (ptr != null) {
            n++;
            ptr = ptr.next;
        }
        int mod = n % k;
        int m = n / k;
        ptr = head;
        for (int i = 0; i < k; i++) {
            if (ptr == null) {
                break;
            }
            res[i] = ptr;
            int size = m + (i < mod ? 1 : 0);
            for (int j = 0; j < size - 1; j++) {
                ptr = ptr.next;
            }
            ListNode next = ptr.next;
            ptr.next = null;
            ptr = next;
        }

        return res;
    }
}
// @lc code=end

