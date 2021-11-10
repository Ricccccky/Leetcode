/*
 * @lc app=leetcode id=650 lang=java
 *
 * [650] 2 Keys Keyboard
 */

// @lc code=start
class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        // At least two operations: copy + paste
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }

        return dp[n];
    }
}
// @lc code=end

