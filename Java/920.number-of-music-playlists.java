/*
 * @lc app=leetcode id=920 lang=java
 *
 * [920] Number of Music Playlists
 */

// @lc code=start
class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int mod = 1000000007;
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (n - (j - 1))) % mod;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][j] * (j - k)) % mod) % mod;
                }
            }
        }

        return (int)dp[goal][n];
    }
}
// @lc code=end

