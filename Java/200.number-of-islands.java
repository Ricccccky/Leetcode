/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    lookAround(i, j, grid);
                }
            }
        }
        return result;
    }

    public void lookAround(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        lookAround(row - 1, col, grid);
        lookAround(row + 1, col, grid);
        lookAround(row, col - 1, grid);
        lookAround(row, col + 1, grid);
    }
}
// @lc code=end

