import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1030 lang=java
 *
 * [1030] Matrix Cells in Distance Order
 */

// @lc code=start
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> temp = new LinkedList<>();
        int[][] result = new int[R * C][2];
        int[] top;
        int order = 0;
        temp.offer(new int[] {r0, c0});
        while (!temp.isEmpty()) {
            top = temp.poll();
            if (top[0] < 0 || top[0] > R - 1 || top[1] < 0 || top[1] > C - 1) {
                continue;
            }
            if (visited[top[0]][top[1]]) {
                continue;
            }
            result[order] = top;
            order++;
            visited[top[0]][top[1]] = true;
            temp.offer(new int[] {top[0] + 1, top[1]});
            temp.offer(new int[] {top[0] - 1, top[1]});
            temp.offer(new int[] {top[0], top[1] + 1});
            temp.offer(new int[] {top[0], top[1] - 1});
        }
        return result;
    }
}
// @lc code=end

