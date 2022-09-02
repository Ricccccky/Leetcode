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
        Deque<Integer> stack = new LinkedList<>();
        int len = 0;
        int result = 0;
        ListNode dummy = head;
        while (dummy != null) {
            dummy = dummy.next;
            len++;
        }
        len /= 2;
        dummy = head;
        while (len-- > 0) {
            stack.push(dummy.val);
            dummy = dummy.next;
        }
        while (!stack.isEmpty()) {
            result = Math.max(result, dummy.val + stack.pop());
            dummy = dummy.next;
        }

        return result;
    }
}
// @lc code=end

