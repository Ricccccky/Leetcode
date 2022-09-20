import java.util.*;

/*
 * @lc app=leetcode id=934 lang=java
 *
 * [934] Shortest Bridge
 */

// @lc code=start
class Solution {
    private int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int shortestBridge(int[][] A) {
        int res = 0;
        int row = A.length;
        int col = A[0].length;
        boolean found = false;
        Queue<int[]> queue = new LinkedList<>();
        // DFS flip an island to all -1's
        for (int i = 0; i < row; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    found = true;
                    break;
                }
            }
        }
        // BFS to expand the island found above
        while (!queue.isEmpty()) {
            int len = queue.size();
            while (len-- > 0) {
                int[] pos = queue.poll();
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        if (A[x][y] == 1) {
                            return res;
                        } else if (A[x][y] == 0) {
                            A[x][y] = -1;
                            queue.offer(new int[] {x, y});
                        }
                    }
                }
            }
            res++;
        }

        return -1;
    }

    private void dfs(int[][] A, int i, int j, Queue<int[]> queue) {
        queue.offer(new int[] {i, j});
        A[i][j] = -1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < A.length && y >= 0 && y < A[0].length && A[x][y] == 1) {
                dfs(A, x, y, queue);
            }
        }
    }
}
// @lc code=end

