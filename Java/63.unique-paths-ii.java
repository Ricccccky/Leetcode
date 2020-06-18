/*
 * @lc app=leetcode id=63 lang=java
 *
 * [63] Unique Paths II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else {
            dp[1][1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            if (obstacleGrid[i - 1][0] == 1) {
                break;
            }
            dp[i][1] = 1;
        }
        for (int i = 2; i < dp[0].length; i++) {
            if (obstacleGrid[0][i - 1] == 1) {
                break;
            }
            dp[1][i] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < dp[0].length; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
// @lc code=end

