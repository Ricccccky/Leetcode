import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=864 lang=java
 *
 * [864] Shortest Path to Get All Keys
 */

// @lc code=start
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0, locks = 0;
        int[] cur = null;
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    cur = new int[] {i, j, 0};
                } else if (Character.isLowerCase(c)) {
                    locks |= 1 << (c - 'a');
                }
            }
        }
        boolean[][][] visited = new boolean[grid.length][grid[0].length()][locks + 1];
        queue.add(cur);
        visited[cur[0]][cur[1]][cur[2]] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            res++;
            for (int i = 0; i < len; i++) {
                cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length()) {
                        char c = grid[x].charAt(y);
                        int key = cur[2];
                        if (c == '#' || (Character.isUpperCase(c) && (key & (1 << (c - 'A'))) == 0)) {
                            continue;
                        } else if (Character.isLowerCase(c)) {
                            key |= 1 << (c - 'a');
                        }
                        if (!visited[x][y][key]) {
                            if (key == locks) {
                                return res;
                            }
                            visited[x][y][key] = true;
                            queue.add(new int[] {x, y, key});
                        }
                    }
                }
            }
        }

        return -1;
    }
}
// @lc code=end

