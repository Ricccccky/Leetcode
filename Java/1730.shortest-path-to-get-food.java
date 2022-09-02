import java.util.*;

/*
 * @lc app=leetcode id=1730 lang=java
 *
 * [1730] Shortest Path to Get Food
 */

// @lc code=start
class Solution {
    public int getFood(char[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            result++;
            while (len-- > 0) {
                int[] idx = queue.poll();
                for (int[] dir : dirs) {
                    int x = idx[0] + dir[0];
                    int y = idx[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (grid[x][y] == '#') {
                        return result;
                    }
                    if (grid[x][y] == 'O') {
                        queue.offer(new int[] {x, y});
                        grid[x][y] = 'X';
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end

