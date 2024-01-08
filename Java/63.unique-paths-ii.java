/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            dp[1][1] = 1;
        }
        for (int i = 2; i <= m; i++) {
            if (obstacleGrid[i - 1][0] == 1) {
                break;
            }
            dp[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            if (obstacleGrid[0][i - 1] == 1) {
                break;
            }
            dp[1][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

