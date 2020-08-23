import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int len = queue.size();
                        for (int k = 0; k < len; k++) {
                            int[] pos = queue.poll();
                            int x = pos[0];
                            int y = pos[1];
                            if (grid[x][y] == -1) {
                                continue;
                            }
                            grid[x][y] = -1;
                            area++;
                            if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                                queue.offer(new int[] {x + 1, y});
                            }
                            if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                                queue.offer(new int[] {x - 1, y});
                            }
                            if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                                queue.offer(new int[] {x, y + 1});
                            }
                            if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                                queue.offer(new int[] {x, y - 1});
                            }
                        }
                    }
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }
}
// @lc code=end

