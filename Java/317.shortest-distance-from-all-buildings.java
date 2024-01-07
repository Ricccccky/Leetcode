/*
 * @lc app=leetcode id=317 lang=java
 *
 * [317] Shortest Distance from All Buildings
 */

// @lc code=start

import java.util.*;

class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = Integer.MAX_VALUE, numBuildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numBuildings++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res = Math.min(res, bfs(grid, numBuildings, i, j));
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int bfs(int[][] grid, int numBuildings, int x, int y) {
        int m = grid.length, n = grid[0].length;
        int dist = 0, cnt = 0, total = 0;
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                int[] cur = queue.poll();
                if (grid[cur[0]][cur[1]] == 1) {
                    cnt++;
                    total += dist;
                    continue;
                }
                for (int[] dir : dirs) {
                    int i = dir[0] + cur[0], j = dir[1] + cur[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j] && grid[i][j] != 2) {
                        queue.offer(new int[] {i, j});
                        visited[i][j] = true;
                    }
                }
            }
            dist++;
        }
        if (cnt != numBuildings) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0 &&  visited[i][j]) {
                        grid[i][j] = 2;
                    }
                }
            }
        }

        return cnt == numBuildings ? total : Integer.MAX_VALUE;
    }
}
// @lc code=end

