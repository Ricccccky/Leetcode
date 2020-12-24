/*
 * @lc app=leetcode id=1254 lang=java
 *
 * [1254] Number of Closed Islands
 */

// @lc code=start
class Solution {
    public int closedIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
                    flood(grid, i, j);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    result++;
                    flood(grid, i, j);
                }
            }
        }
        return result;
    }

    private void flood(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 1) {
            return;
        }
        grid[x][y] = 1;
        flood(grid, x + 1, y);
        flood(grid, x - 1, y);
        flood(grid, x, y + 1);
        flood(grid, x, y - 1);
        return;
    }
}
// @lc code=end

