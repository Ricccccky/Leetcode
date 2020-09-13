/*
 * @lc app=leetcode id=1000 lang=java
 *
 * [1000] Minimum Cost to Merge Stones
 */

// @lc code=start
class Solution {
    public int mergeStones(int[] stones, int K) {
        if ((stones.length - 1) % (K - 1) != 0) {
            return -1;
        }

        int[][] dp = new int[stones.length][stones.length];
        int[] prefix = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }
        for (int l = K; l <= stones.length; l++) {
            for (int i = 0; i <= stones.length - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = i; m < j; m += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += prefix[j + 1] - prefix[i];
                }
            }
        }
        return dp[0][stones.length - 1];
    }
}
// @lc code=end

