import java.util.*;

/*
 * @lc app=leetcode id=1438 lang=java
 *
 * [1438] Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxStack = new LinkedList<>();
        Deque<Integer> minStack = new LinkedList<>();
        int l = 0, r = 0;
        for (; r < nums.length; r++) {
            while (!maxStack.isEmpty() && nums[r] > maxStack.peek()) {
                maxStack.pop();
            }
            maxStack.push(nums[r]);
            while (!minStack.isEmpty() && nums[r] < minStack.peek()) {
                minStack.pop();
            }
            minStack.push(nums[r]);
            if (maxStack.peekLast() - minStack.peekLast() > limit) {
                if (nums[l] == maxStack.peekLast()) {
                    maxStack.pollLast();
                }
                if (nums[l] == minStack.peekLast()) {
                    minStack.pollLast();
                }
                l++;
            }
        }

        return r - l;
    }
}
// @lc code=end

