/*
 * @lc app=leetcode id=674 lang=java
 *
 * [674] Longest Continuous Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length, res = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
        }

        return res;
    }
}
// @lc code=end

