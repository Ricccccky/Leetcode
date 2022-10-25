/*
 * @lc app=leetcode id=1413 lang=java
 *
 * [1413] Minimum Value to Get Positive Step by Step Sum
 */

// @lc code=start
class Solution {
    public int minStartValue(int[] nums) {
        int min = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }

        return Math.max(0 - min + 1, 1);
    }
}
// @lc code=end

