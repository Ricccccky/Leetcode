/*
 * @lc app=leetcode id=1444 lang=java
 *
 * [1444] Number of Ways of Cutting a Pizza
 */

// @lc code=start
class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        int[][][] dp = new int[k][m][n];
        int[][] sufSum = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                sufSum[i][j] = sufSum[i][j + 1] + sufSum[i + 1][j] - sufSum[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
            }
        }

        return dfs(m, n, k - 1, dp, sufSum, 0, 0);
    }

    private int dfs(int m, int n, int k, int[][][] dp, int[][] sufSum, int x, int y) {
        if (sufSum[x][y] == 0) {
            // The right-bottom part doesn't have apple, invalid
            return 0;
        }
        if (k == 0) {
            // Cut finished, one possible way
            return 1;
        }
        if (dp[k][x][y] != 0) {
            return dp[k][x][y];
        }
        int result = 0;
        int mod = 1000000007;
        for (int i = x + 1; i < m; i++) {
            if (sufSum[x][y] - sufSum[i][y] > 0) {
                // The upper part has apple, check lower part further
                result = (result + dfs(m, n, k - 1, dp, sufSum, i, y)) % mod;
            }
        }
        for (int j = y + 1; j < n; j++) {
            if (sufSum[x][y] - sufSum[x][j] > 0) {
                // The left part has apple, check right part further
                result = (result + dfs(m, n, k - 1, dp, sufSum, x, j)) % mod;
            }
        }
        dp[k][x][y] = result;

        return result;
    }
}
// @lc code=end

