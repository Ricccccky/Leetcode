import java.util.*;

/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i ,j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return result;
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            result++;
            while (len-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                        fresh--;
                        grid[x][y] = 2;
                        queue.offer(new int[] {x, y});
                    }
                }
                if (fresh == 0) {
                    return result;
                }
            }
        }
        
        return -1;
    }
}
// @lc code=end

