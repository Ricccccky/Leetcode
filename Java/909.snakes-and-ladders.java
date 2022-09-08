import java.util.*;

/*
 * @lc app=leetcode id=909 lang=java
 *
 * [909] Snakes and Ladders
 */

// @lc code=start
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int result = 0;
        Deque<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(1);
        while (!queue.isEmpty()) {
            int len = queue.size();
            result++;
            while (len-- > 0) {
                int cur = queue.poll();
                for (int i = 1; i <= 6; i++) {
                    int next = cur + i;
                    int[] pos = num2pos(next, n);
                    if (board[pos[0]][pos[1]] > 0) {
                        next = board[pos[0]][pos[1]];
                    }
                    if (next == n * n) {
                        return result;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }

        return -1;
    }

    private int[] num2pos(int num, int n) {
        int row = (num - 1) / n;
        int col = (num - 1) % n;

        return new int[] {n - row - 1, row % 2 == 0 ? col : n - 1 - col};
    }
}
// @lc code=end

