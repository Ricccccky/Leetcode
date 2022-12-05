import java.util.*;

/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 */

// @lc code=start
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Deque<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int row = rooms.length;
        int col = rooms[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[] {i, j, rooms[i][j]});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = dir[0] + cur[0];
                int y = dir[1] + cur[1];
                if (x >= 0 && x < row && y >= 0 && y < col && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = cur[2] + 1;
                    queue.add(new int[] {x, y, rooms[x][y]});
                }
            }
        }
    }
}
// @lc code=end

