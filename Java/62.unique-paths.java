/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][1];
        }
        for (int i = 2; i <= m; i++) {
            dp[1][i] = dp[1][i - 1];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n][m];
    }
}
// @lc code=end

