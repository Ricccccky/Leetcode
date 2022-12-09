/*
 * @lc app=leetcode id=790 lang=java
 *
 * [790] Domino and Tromino Tiling
 */

// @lc code=start
class Solution {
    public int numTilings(int n) {
        int mod = 1000000007;
        long previousFull = 1;
        long currentFull = 2;
        long currentPartial = 1;
        if (n <= 2) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            /* 
             * f[i - 1]: add a vertical domino
             * f[i - 2]: add two horizontal dominos
             * p[i - 1]: add a tromino
             */
            long tmp = currentFull;
            currentFull = (currentFull + previousFull + 2 * currentPartial) % mod;
            /* 
             * p[i - 1]: add a horizontal domino
             * f[i - 2]: add a tromino
             */
            currentPartial = (currentPartial + previousFull) % mod;
            previousFull = tmp;
        }

        return (int)currentFull;
    }
}
// @lc code=end

