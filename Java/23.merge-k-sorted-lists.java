/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return null;
        } else if (end - start == 1) {
            return lists[start];
        } else if (end - start == 2) {
            return merge2Lists(lists[start], lists[start + 1]);
        } else {
            int mid = start + (end - start) / 2;
            return merge2Lists(mergeKLists(lists, start, mid), mergeKLists(lists, mid, end));
        }
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return head.next;
    }
}
// @lc code=end

