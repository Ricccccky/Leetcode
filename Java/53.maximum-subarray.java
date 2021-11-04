/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // DP
        // int[] dp = new int[nums.length];
        // dp[0] = nums[0];
        // int result = dp[0];
        // for (int i = 1; i < nums.length; i++) {
        //     dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        //     result = Math.max(result, dp[i]);
        // }

        // return result;

        // Greedy
        int current = nums[0];
        int res = current;
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], nums[i] + current);
            res = Math.max(res, current);
        }

        return res;
    }
}
// @lc code=end

