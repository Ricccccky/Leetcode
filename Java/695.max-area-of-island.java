import java.util.*;

/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        // Recursive
        // int res = 0;
        // int row = grid.length;
        // int col = grid[0].length;
        // for (int i = 0; i < row; i++) {
        //     for (int j = 0; j < col; j++) {
        //         res = Math.max(res, helper(grid, i, j));
        //     }
        // }
        
        // return res;

        // Iterative
        int result = 0;
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] pos = queue.poll();
                        int x = pos[0];
                        int y = pos[1];
                        if (grid[x][y] == -1) {
                            continue;
                        }
                        grid[x][y] = -1;
                        area++;
                        for (int[] dir : dirs) {
                            int newX = x + dir[0];
                            int newY = y + dir[1];
                            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                                queue.offer(new int[] {newX, newY});
                            }
                        }
                    }
                    result = Math.max(result, area);
                }
            }
        }

        return result;
    }

    public int helper(int[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;

        return 1 + helper(grid, x, y + 1) + helper(grid, x, y - 1) + helper(grid, x + 1, y) + helper(grid, x - 1, y);
    }
}
// @lc code=end

