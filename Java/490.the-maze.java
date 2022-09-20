import java.util.*;

/*
 * @lc app=leetcode id=490 lang=java
 *
 * [490] The Maze
 */

// @lc code=start
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(start);
        maze[start[0]][start[1]] = 2;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            if (top[0] == destination[0] && top[1] == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] != 1) {
                    x += dir[0];
                    y += dir[1];
                }
                if (maze[x - dir[0]][y - dir[1]] != 2) {
                    queue.offer(new int[] {x - dir[0], y - dir[1]});
                    maze[x - dir[0]][y - dir[1]] = 2;
                }
            }
        }

        return false;
    }
}
// @lc code=end

