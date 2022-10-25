import java.util.*;

/*
 * @lc app=leetcode id=862 lang=java
 *
 * [862] Shortest Subarray with Sum at Least K
 */

// @lc code=start
class Solution {
    // O(n)
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int result = n + 1;
        long[] prefix_sum = new long[n + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            prefix_sum[i + 1] = prefix_sum[i] + nums[i];
        }
        for (int i = 0; i <= n; i++) {
            while (!queue.isEmpty() && prefix_sum[i] - prefix_sum[queue.peekFirst()] >= k) {
                result = Math.min(result, i - queue.pollFirst());
            }
            while (!queue.isEmpty() && prefix_sum[i] <= prefix_sum[queue.getLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }

        return result == n + 1 ? -1 : result;
    }
}
// @lc code=end

