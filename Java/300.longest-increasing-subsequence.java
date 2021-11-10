/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // Binary search
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int left = 0;
            int right = len;
            // Find insert pos of num
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = num;
            if (left == len) {
                len++;
            }
        }

        return len;

        // DP
        // int res = 0;
        // int n = nums.length;
        // int[] dp = new int[n];
        // for (int i = 0; i < n; i++) {
        //     int max = 1;
        //     for (int j = 0; j < i; j++) {
        //         if (nums[i] > nums[j]) {
        //             max = Math.max(max, dp[j] + 1);
        //         }
        //     }
        //     dp[i] = max;
        // }
        // for (int i : dp) {
        //     res = Math.max(res, i);
        // }

        // return res;
    }
}
// @lc code=end

