/*
 * @lc app=leetcode id=935 lang=java
 *
 * [935] Knight Dialer
 */

// @lc code=start
class Solution {
    public int knightDialer(int n) {
        int[][] dirs = new int[][] {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int mod = 1000000007;
        int[][] dp = new int[n + 1][10];
        int res = 0;
        for (int i = 0; i < dp[0].length; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int dir : dirs[j]) {
                    dp[i][j] += dp[i - 1][dir];
                    dp[i][j] %= mod;
                }
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            res += dp[n][i];
            res %= mod;
        }

        return res;
    }
}
// @lc code=end

