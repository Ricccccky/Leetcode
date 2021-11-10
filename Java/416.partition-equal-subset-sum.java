/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        // Space of backpack
        int n = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            int weight = nums[i - 1];
            for (int j = 1; j <= n; j++) {
                if (j >= weight) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - weight];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[nums.length][n];
    }
}
// @lc code=end

