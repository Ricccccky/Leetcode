/*
 * @lc app=leetcode id=664 lang=java
 *
 * [664] Strange Printer
 */

// @lc code=start
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i < n - 1) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 1;
                } else {
                    dp[i][i + 1] = 2;
                }
            }
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                dp[i][i + len] = len + 1;
                for (int j = i; j < i + len; j++) {
                    int max = dp[i][j] + dp[j + 1][i + len];
                    if (s.charAt(j) == s.charAt(i + len)) {
                        dp[i][i + len] = Math.min(dp[i][i + len], max - 1);
                    } else {
                        dp[i][i + len] = Math.min(dp[i][i + len], max);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end

