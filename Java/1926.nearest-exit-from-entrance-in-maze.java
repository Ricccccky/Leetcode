/*
 * @lc app=leetcode id=1926 lang=java
 *
 * [1926] Nearest Exit from Entrance in Maze
 */

// @lc code=start

import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length, res = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            int len = queue.size();
            res++;
            while (len-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == '.') {
                        if (x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                            return res;
                        }
                        queue.offer(new int[] {x, y});
                        maze[x][y] = '+';
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end

