/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int x = 0, y = n - 1;
            while (x < n && y >= 0) {
                if (matrix[x][y] <= mid) {
                    count += y + 1;
                    x++;
                } else {
                    y--;
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

