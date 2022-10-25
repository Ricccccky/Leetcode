/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    // O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int result = n + 1;
        int sum = 0, i = 0;
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (sum >= target) {
                result = Math.min(result, j + 1 - i);
                sum -= nums[i++];
            }
        }

        return result == n + 1 ? 0 : result;
    }
}
// @lc code=end

