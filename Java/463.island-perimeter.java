/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0, adjacents = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        adjacents++;
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        adjacents++;
                    }
                }
            }
        }

        return res * 4 - adjacents * 2;
    }
}
// @lc code=end

