/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[m - 1][n - 1];
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            int count = 0;
            for (int i = 0; i < m && matrix[i][0] <= mid; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    count++;
                }
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
// @lc code=end

