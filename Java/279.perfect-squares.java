/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        // DP method
        // int[] result = new int[n + 1];
        // if (n == 1) {
        //     return 1;
        // }
        // for (int i = 1; i < n + 1; i++) {
        //     result[i] = Integer.MAX_VALUE;
        // }
        // result[1] = 1;

        // for (int i = 2; i <= n; i++) {
        //     if (Math.abs((int)(Math.sqrt(i)) * (int)(Math.sqrt(i)) - i) < 0.0001) {
        //         result[i] = 1;
        //         continue;
        //     }
        //     for (int j = 1; j < i; j++) {
        //         result[i] = Math.min(result[i], result[j] + result[i - j]);
        //     }
        // }
        // return result[n];

        // Lagrange
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }

        int i = 0;
        int rem;
        while (i * i <= n) {
            rem = (int)(Math.sqrt(n - i * i));
            if (i * i + rem * rem == n) {
                if (i != 0) {
                    i = 1;
                }
                if (rem != 0) {
                    rem = 1;
                }
                return i + rem;
            }
            i++;
        }
        return 3;
    }
}
// @lc code=end

