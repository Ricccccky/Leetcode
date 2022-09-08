/*
 * @lc app=leetcode id=688 lang=java
 *
 * [688] Knight Probability in Chessboard
 */

// @lc code=start
class Solution {
    static int[][] dirs = new int[][] {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        return knightProbability(n, k, row, column, dp);
    }

    private double knightProbability(int n, int k, int row, int column, double[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[row][column][k] != 0) {
            return dp[row][column][k];
        }
        double prob = 0;
        for (int[] dir : dirs) {
            prob += 1.0 / 8.0 * knightProbability(n, k - 1, row + dir[0], column + dir[1], dp);
        }
        dp[row][column][k] = prob;

        return prob;
    }
}
// @lc code=end

