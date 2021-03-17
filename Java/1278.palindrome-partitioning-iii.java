/*
 * @lc app=leetcode id=1278 lang=java
 *
 * [1278] Palindrome Partitioning III
 */

// @lc code=start
class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] changes = new int[n][n];
        int[][] dp = new int[k + 1][n];
        for (int i = 0; i < n; i++) {
            changes[i][i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    changes[i][j] = changes[i + 1][j - 1];
                } else {
                    changes[i][j] = changes[i + 1][j - 1] + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            dp[1][i] = changes[0][i];
        }
        for (int i = 2; i <= k; i++) {
            // At least i non-empty group, 1 character per group --> end = i - 1
            for (int end = i - 1; end < n; end++) {
                dp[i][end] = n;
                // In array changes, start + 1 < end
                for (int start = end - 1; start >= i - 2; start--) {
                    dp[i][end] = Math.min(dp[i][end], dp[i - 1][start] + changes[start + 1][end]);
                }
            }
        }

        return dp[k][n - 1];
    }
}
// @lc code=end

