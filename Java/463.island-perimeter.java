/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        int up, down, left, right;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        up = 0;
                    } else {
                        up = grid[i - 1][j];
                    }
                    if (j == 0) {
                        left = 0;
                    } else {
                        left = grid[i][j - 1];
                    }
                    if (i == row - 1) {
                        down = 0;
                    } else {
                        down = grid[i + 1][j];
                    }
                    if (j == col - 1) {
                        right = 0;
                    } else {
                        right = grid[i][j + 1];
                    }
                    res += 4 - up - down - left - right;
                }
            }
        }

        return res;
    }
}
// @lc code=end

