/*
 * @lc app=leetcode id=689 lang=java
 *
 * [689] Maximum Sum of 3 Non-Overlapping Subarrays
 */

// @lc code=start
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Pick [i, i + k], then select maximum left subarray from [0, i) and right subarray from (i + k, n - 1]
        int n = nums.length, max = 0;
        int[] prefixSum = new int[n + 1], leftArrStart = new int[n], rightArrStart = new int[n], res = new int[3];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        for (int i = k, sum = prefixSum[k] - prefixSum[0]; i < n; i++) {
            if (prefixSum[i + 1] - prefixSum[i + 1 - k] > sum) {
                sum = prefixSum[i + 1] - prefixSum[i + 1 - k];
                leftArrStart[i] = i + 1 - k;
            } else {
                leftArrStart[i] = leftArrStart[i - 1];
            }
        }
        rightArrStart[n - k] = n - k;
        for (int i = n - k - 1, sum = prefixSum[n] - prefixSum[n - k]; i >= 0; i--) {
            if (prefixSum[i + k] - prefixSum[i] >= sum) {
                rightArrStart[i] = i;
                sum = prefixSum[i + k] - prefixSum[i];
            } else {
                rightArrStart[i] = rightArrStart[i + 1];
            }
        }
        for (int i = k; i <= n - 2 * k; i++) {
            int leftStart = leftArrStart[i - 1], rightStart = rightArrStart[i + k];
            int sum = prefixSum[leftStart + k] - prefixSum[leftStart] + prefixSum[i + k] - prefixSum[i] + prefixSum[rightStart + k] - prefixSum[rightStart];
            if (sum > max) {
                max = sum;
                res[0] = leftStart;
                res[1] = i;
                res[2] = rightStart;
            }
        }

        return res;
    }
}
// @lc code=end

