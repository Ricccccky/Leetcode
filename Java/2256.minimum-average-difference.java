/*
 * @lc app=leetcode id=2256 lang=java
 *
 * [2256] Minimum Average Difference
 */

// @lc code=start
class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long sum = 0, leftSum = 0, rightSum = 0, min = Long.MAX_VALUE;
        int result = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            rightSum = sum - leftSum;
            long leftAve = leftSum / (i + 1);
            // Right part may have 0 element
            long rightAve = i == n - 1 ? 0 : rightSum / (n - i - 1);
            long diff = Math.abs(leftAve - rightAve);
            if (diff < min) {
                min = diff;
                result = i;
            }
        }

        return result;
    }
}
// @lc code=end

