import java.util.*;

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
        // Reverse input lists
        // l1 = reverse(l1);
        // l2 = reverse(l2);
        // ListNode dummy = new ListNode(-1);
        // ListNode ptr = dummy;
        // int carry = 0;
        // while (l1 != null || l2 != null || carry != 0) {
        //     if (l1 != null) {
        //         carry += l1.val;
        //         l1 = l1.next;
        //     }
        //     if (l2 != null) {
        //         carry += l2.val;
        //         l2 = l2.next;
        //     }
        //     ptr.next = new ListNode(carry % 10);
        //     ptr = ptr.next;
        //     carry /= 10;
        // }

        // return reverse(dummy.next);

        // Not reverse input lists
        ListNode dummy = new ListNode(-1);
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        int carry = 0;
        while (l1 != null) {
            s1.addLast(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.addLast(l2.val);
            l2 = l2.next;
        }
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            carry += s1.isEmpty() ? 0 : s1.removeLast();
            carry += s2.isEmpty() ? 0 : s2.removeLast();
            ListNode ptr = new ListNode(carry % 10);
            carry /= 10;
            ptr.next = dummy.next;
            dummy.next = ptr;
        }

        return dummy.next;
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

