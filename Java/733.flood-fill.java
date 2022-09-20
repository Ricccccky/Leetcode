import java.util.*;

/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        Deque<int[]> queue = new LinkedList<>();
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int c = image[sr][sc];
        queue.offer(new int[] {sr, sc});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            image[top[0]][top[1]] = color;
            for (int[] dir : dirs) {
                int x= top[0] + dir[0];
                int y = top[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && image[x][y] == c) {
                    queue.offer(new int[] {x, y});
                }
            }
        }

        return image;
    }
}
// @lc code=end

