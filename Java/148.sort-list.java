
/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode ptr = res;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ptr.next = l2;
                l2 = l2.next;
            } else {
                ptr.next = l1;
                l1 = l1.next;
            }
            ptr = ptr.next;
        }
        if (l1 == null) {
            ptr.next = l2;
        } else {
            ptr.next = l1;
        }

        return res.next;
    }

    private ListNode findMid(ListNode head) {
        ListNode p = new ListNode();
        p.next = head;
        while (head != null && head.next != null) {
            p = p.next;
            head = head.next.next;
        }
        ListNode mid = p.next;
        p.next = null;

        return mid;
    }
}
// @lc code=end

