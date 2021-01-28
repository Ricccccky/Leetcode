/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        int[][] dp = new int[nums.length][m + 1];
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 2; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            dp[i][1] = sums[i];
        }
        for (int i = 0; i < nums.length && i + 1 <= m; i++) {
            dp[i][i + 1] = nums[0];
            for (int j = 0; j <= i; j++) {
                dp[i][i + 1] = Math.max(dp[i][i + 1], nums[j]);
            }
        }
        for (int i = 2; i <= m; i++) {
            for (int j = i; j < nums.length; j++) {
                dp[j][i] = Integer.MAX_VALUE;
                for (int k = i - 2; k < j; k++) {
                    dp[j][i] = Math.min(dp[j][i], Math.max(dp[k][i - 1], sums[j] - sums[k]));
                }
            }
        }

        return dp[nums.length - 1][m];
    }
}
// @lc code=end

