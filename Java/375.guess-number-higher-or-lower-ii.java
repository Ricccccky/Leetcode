/*
 * @lc app=leetcode id=375 lang=java
 *
 * [375] Guess Number Higher or Lower II
 */

// @lc code=start
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int cost = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int temp = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    cost = Math.min(cost, temp);
                }
                dp[i][j] = i == j - 1 ? i : cost;
            }
        }

        return dp[1][n];
    }

    // public int getMoneyAmount(int n) {
    //     int[][] dp = new int[n + 1][n + 1];
    //     return helper(dp, 0, n);
    // }

    private int helper(int[][] dp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        if (dp[start][end] > 0) return dp[start][end];
        for (int i = start; i <= end; i++) {
            int cost = i + Math.max(helper(dp, start, i - 1), helper(dp, i + 1, end));
            result = Math.min(result, cost);
        }
        dp[start][end] = result;

        return result;
    }
}
// @lc code=end

