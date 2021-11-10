/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // DFS
        // return dfs(nums, target, 0);

        /*
        DP: (P)ositive, (N)egative
        sum(P) - sum(N) = target
        sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
        2 * sum(P) = target + sum(nums)
        Find sum(P) = (target + sum(nums)) / 2
        */
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum += target;
        if (sum < 0 || sum % 2 == 1) {
            return 0;
        }
        int W = sum / 2;
        int N = nums.length;
        int[][] dp = new int[N + 1][W + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            int w = nums[i - 1];
            for (int j = 0; j <= W; j++) {
                // if (j >= w) {
                //     dp[i][j] = dp[i - 1][j] + dp[i - 1][j - w];
                // }
                if (j >= w) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - w];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][W];
    }

    private int dfs(int[] nums, int target, int idx) {
        if (idx == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return dfs(nums, target + nums[idx], idx + 1) + dfs(nums, target - nums[idx], idx + 1);
    }
}
// @lc code=end

