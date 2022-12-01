import java.util.*;

/*
 * @lc app=leetcode id=1559 lang=java
 *
 * [1559] Detect Cycles in 2D Grid
 */

// @lc code=start
class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], -2);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == -2 && containsCycle(grid, i, j, visited, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean containsCycle(char[][] grid, int x, int y, int[][] visited, int rank) {
        int m = grid.length, n = grid[0].length;
        boolean result = false;
        char c = grid[x][y];
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        visited[x][y] = rank;
        for (int[] dir : dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == c && rank != visited[i][j] + 1) {
                if (visited[i][j] > 0 && rank > visited[i][j]) {
                    return true;
                } else {
                    result = result || containsCycle(grid, i, j, visited, rank + 1);
                }
            }
        }

        return result;
    }
}
// @lc code=end

