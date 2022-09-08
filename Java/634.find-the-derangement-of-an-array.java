/*
 * @lc app=leetcode id=634 lang=java
 *
 * [634] Find the Derangement of An Array
 */

// @lc code=start
class Solution {
    public int findDerangement(int n) {
        if (n == 1) {
            return 0;
        }
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            // swap + not swap
            dp[i] = (i - 1) * (dp[i - 2] + dp[i - 1]) % mod;
        }

        return (int)dp[n];
    }
}
// @lc code=end

