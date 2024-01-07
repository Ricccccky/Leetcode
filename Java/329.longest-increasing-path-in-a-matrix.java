/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, backtracking(matrix, dp, i, j));
            }
        }

        return res;
    }

    private int backtracking(int[][] matrix, int[][] dp, int x, int y) {
        int m = matrix.length, n = matrix[0].length, res = 1;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        for (int[] dir : dirs) {
            int i = x + dir[0], j = y + dir[1];
            if (i >= 0 && i < m && j >= 0 && j < n && matrix[i][j] > matrix[x][y]) {
                res = Math.max(res, 1 + backtracking(matrix, dp, i, j));
            }
        }
        dp[x][y] = res;

        return res;
    }
}
// @lc code=end

