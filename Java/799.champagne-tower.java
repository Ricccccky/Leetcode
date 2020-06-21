/*
 * @lc app=leetcode id=799 lang=java
 *
 * [799] Champagne Tower
 */

// @lc code=start
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row + 2];
        dp[0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = i; j >= 0; j--) {
                dp[j] = Math.max((dp[j] - 1) / 2, 0.0);
                dp[j + 1] += dp[j];
            }
        }
        return Math.min(dp[query_glass], 1.0);
    }
}
// @lc code=end

