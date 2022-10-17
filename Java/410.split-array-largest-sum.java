import java.util.*;

/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        // DP
        // int n = nums.length;
        // int[] prefix = new int[n + 1];
        // int[][] dp = new int[n + 1][m + 1];
        // for (int i = 1; i <= n; i++) {
        //     prefix[i] = prefix[i - 1] + nums[i - 1];
        // }
        // for (int i = 0; i <= n; i++) {
        //     Arrays.fill(dp[i], prefix[n]);
        // }
        // dp[0][0] = 0;
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= m; j++) {
        //         for (int k = 0; k < i; k++) {
        //             dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], prefix[i] - prefix[k]));
        //         }
        //     }
        // }

        // return dp[n][m];

        // Binary Search
        int lo = 0;
        int hi = 0;
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            hi += num;
            lo = Math.max(lo, num);
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int sum = 0;
            int groups = 1;
            for (int num : nums) {
                if (sum + num <= mid) {
                    sum += num;
                } else {
                    sum = num;
                    groups++;
                }
            }
            if (groups > m) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
                res = Math.min(res, mid);
            }
        }

        return res;
    }
}
// @lc code=end

