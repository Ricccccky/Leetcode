import java.util.*;

/*
 * @lc app=leetcode id=1091 lang=java
 *
 * [1091] Shortest Path in Binary Matrix
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1 ,0}, {-1, -1}, {-1 ,1}, {1, 1}, {1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int len = queue.size();
            res++;
            while (len-- > 0) {
                int[] cur = queue.poll();
                if (grid[cur[0]][cur[1]] == 1) {
                    continue;
                }
                if (cur[0] == row - 1 && cur[1] == col - 1) {
                    return res;
                }
                grid[cur[0]][cur[1]] = 1;
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end

