import java.util.*;

/*
 * @lc app=leetcode id=1836 lang=java
 *
 * [1836] Remove Duplicates From an Unsorted Linked List
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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode ptr = dummy.next;
        while (ptr != null) {
            count.put(ptr.val, count.getOrDefault(ptr.val, 0) + 1);
            ptr = ptr.next;
        }
        ptr = dummy.next;
        while (ptr != null) {
            if (count.get(ptr.val) > 1) {
                prev.next = ptr.next;
                ptr = prev;
            }
            prev = ptr;
            ptr = ptr.next;
        }

        return dummy.next;
    }
}
// @lc code=end

