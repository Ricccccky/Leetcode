/*
 * @lc app=leetcode id=1420 lang=java
 *
 * [1420] Build Array Where You Can Find The Maximum Exactly K Comparisons
 */

// @lc code=start
class Solution {
    public int numOfArrays(int n, int m, int k) {
        int mod = 1000000007;
        long res = 0;
        // Length, Maximum element, Cost
        long[][][] ways = new long[n + 1][m + 1][k + 1];
        for (int i = 1; i < m + 1; i++) {
            ways[1][i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int p = 1; p <= k; p++) {
                    long sum = 0;
                    sum = (sum + j * ways[i - 1][j][p]) % mod;
                    for (int q = 1; q < j; q++) {
                        sum = (sum + ways[i - 1][q][p - 1]) % mod;
                    }
                    ways[i][j][p] = (ways[i][j][p] + sum) % mod;
                }
            }
        }
        for (int j = 1; j <= m; j++) {
            res = (res += ways[n][j][k]) % mod;
        }

        return (int)res;
    }
}
// @lc code=end

