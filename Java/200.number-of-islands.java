import java.util.*;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    // DFS
    // public int numIslands(char[][] grid) {
    //     int result = 0;
    //     for (int i = 0; i < grid.length; i++) {
    //         for (int j = 0; j < grid[0].length; j++) {
    //             if (grid[i][j] == '1') {
    //                 result++;
    //                 dfs(i, j, grid);
    //             }
    //         }
    //     }
        
    //     return result;
    // }

    // BFS, space O(min(M, N))
    public int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    Deque<int[]> queue = new LinkedList<>();
                    queue.add(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] next = queue.poll();
                        for (int[] dir : dirs) {
                            int x = next[0] + dir[0];
                            int y = next[1] + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                queue.offer(new int[] {x, y});
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }

    public void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(row - 1, col, grid);
        dfs(row + 1, col, grid);
        dfs(row, col - 1, grid);
        dfs(row, col + 1, grid);
    }
}
// @lc code=end

