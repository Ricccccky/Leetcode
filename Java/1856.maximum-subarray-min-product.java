import java.util.*;

/*
 * @lc app=leetcode id=1856 lang=java
 *
 * [1856] Maximum Subarray Min-Product
 */

// @lc code=start
class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;
        long result = 0;
        long[] preSum = new long[n + 1];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        for (int r = 0; r <= n; r++) {
            int num = r == n ? -1 : nums[r];
            while (!stack.isEmpty() && nums[stack.peek()] >= num) {
                int min = stack.pop();
                int l = stack.isEmpty() ? 0 : stack.peek() + 1;
                result = Math.max(result, nums[min] * (preSum[r] - preSum[l]));
            }
            stack.push(r);
        }

        return (int)(result % mod);
    }
}
// @lc code=end

