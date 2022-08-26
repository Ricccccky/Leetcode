import java.util.*;

/*
 * @lc app=leetcode id=2130 lang=java
 *
 * [2130] Maximum Twin Sum of a Linked List
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
    public int pairSum(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        int len = 0;
        int result = 0;
        ListNode dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            len++;
        }
        dummy = head;
        for (int i = 0; i < len / 2; i++) {
            dummy = dummy.next;
        }
        for (int i = 0; i < len / 2; i++) {
            stack.push(dummy);
            dummy = dummy.next;
        }
        while (!stack.isEmpty()) {
            result = Math.max(result, head.val + stack.pop().val);
            head = head.next;
        }

        return result;
    }
}
// @lc code=end

