/*
 * @lc app=leetcode id=1034 lang=java
 *
 * [1034] Coloring A Border
 */

// @lc code=start
class Solution
{
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color)
    {
        int cur_color = grid[r0][c0];
        dfs(grid, r0, c0, cur_color);
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] == -cur_color)
                {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int cur)
    {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == cur)
        {
            grid[row][col] = -cur;
            dfs(grid, row + 1, col, cur);
            dfs(grid, row - 1, col, cur);
            dfs(grid, row, col + 1, cur);
            dfs(grid, row, col - 1, cur);
            if (row > 0 && row < grid.length - 1 && col > 0 && col < grid[row].length - 1
                    && cur == Math.abs(grid[row + 1][col]) && cur == Math.abs(grid[row - 1][col])
                    && cur == Math.abs(grid[row][col + 1]) && cur == Math.abs(grid[row][col - 1]))
            {
                grid[row][col] = cur;
            }
        }
    }
}
// @lc code=end
