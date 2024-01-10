/*
 * @lc app=leetcode id=643 lang=java
 *
 * [643] Maximum Average Subarray I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length, max = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        
        for (int i = k; i < n; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            max = Math.max(max, sum);
        }

        return (double)max / k;
    }
}
// @lc code=end

