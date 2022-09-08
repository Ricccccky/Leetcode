/*
 * @lc app=leetcode id=2221 lang=java
 *
 * [2221] Find Triangular Sum of an Array
 */

// @lc code=start
class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int len = n - 1; len >= 0; len--) {
            for (int i = 0; i < len; i++) {
                nums[i] += nums[i + 1];
                nums[i] %= 10;
            }
        }

        return nums[0];
    }
}
// @lc code=end

