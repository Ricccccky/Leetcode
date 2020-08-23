import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            result++;
            for (int i = 0; i < len; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    fresh--;
                    grid[x + 1][y] = 2;
                    queue.offer(new int[] {x + 1, y});
                    if (fresh == 0) {
                        return result;
                    }
                }
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    fresh--;
                    grid[x - 1][y] = 2;
                    queue.offer(new int[] {x - 1, y});
                    if (fresh == 0) {
                        return result;
                    }
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    fresh--;
                    grid[x][y + 1] = 2;
                    queue.offer(new int[] {x, y + 1});
                    if (fresh == 0) {
                        return result;
                    }
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    fresh--;
                    grid[x][y - 1] = 2;
                    queue.offer(new int[] {x, y - 1});
                    if (fresh == 0) {
                        return result;
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end

