/*
 * @lc app=leetcode id=1186 lang=java
 *
 * [1186] Maximum Subarray Sum with One Deletion
 */

// @lc code=start
class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length, res = arr[0];
        // Divide the subarray into two parts at the deletion index
        int[] maxEnds = new int[n], maxStarts = new int[n];
        maxEnds[0] = arr[0];
        maxStarts[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            maxEnds[i] = Math.max(arr[i], maxEnds[i - 1] + arr[i]);
            res = Math.max(res, maxEnds[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            maxStarts[i] = Math.max(arr[i], maxStarts[i + 1] + arr[i]);
            res = Math.max(res, maxStarts[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            // Delete arr[i]
            res = Math.max(res, maxEnds[i - 1] + maxStarts[i + 1]);
        }

        return res;
    }
}
// @lc code=end

