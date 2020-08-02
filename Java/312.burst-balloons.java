/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        int n = 1;
        for (int num : nums) {
            if (num > 0) {
                arr[n] = num;
                n++;
            }
        }
        arr[0] = arr[n++] = 1;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int start = 0; start < n - len; start++) {
                int end = start + len;
                for (int i = start + 1; i < end; i++) {
                    dp[start][end] = Math.max(dp[start][end],
                            arr[start] * arr[i] * arr[end] + dp[start][i] + dp[i][end]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
// @lc code=end
