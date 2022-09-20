/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j] is the minimum steps of converting word1[:i] to word2[:j]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            // remove i times
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            // insert i times
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Swap/Insert/Remove
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
// @lc code=end

