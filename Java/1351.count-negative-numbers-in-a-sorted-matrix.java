/*
 * @lc app=leetcode id=1351 lang=java
 *
 * [1351] Count Negative Numbers in a Sorted Matrix
 */

// @lc code=start
class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int i = m - 1, j = 0;
        int result = 0;
        while (i >= 0 && j < n) {
            if (grid[i][j] < 0) {
                result += n - j;
                i--;
            } else {
                j++;
            }
        }

        return result;
    }
}
// @lc code=end

