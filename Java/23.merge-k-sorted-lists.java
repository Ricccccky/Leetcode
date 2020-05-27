import java.util.Arrays;

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
        if (lists.length == 0) {
            return null;
        }
        else if (lists.length == 1) {
            return lists[0];
        }
        else if (lists.length == 2) {
            return merge2Lists(lists[0], lists[1]);
        }
        else {
            int mid = lists.length / 2;
            ListNode pre = mergeKLists(Arrays.copyOf(lists, mid));
            ListNode lat = mergeKLists(Arrays.copyOfRange(lists, mid, lists.length));
            return merge2Lists(pre, lat);
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

