/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min;
        int[][] dp = new int[3][prices.length];
        for (int i = 1; i < 3; i++) {
            dp[i][0] = 0;
            min = prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
                min = Math.min(min, prices[j] - dp[i - 1][j - 1]);
            }
        }
        return dp[2][prices.length - 1];
    }
}
// @lc code=end 
