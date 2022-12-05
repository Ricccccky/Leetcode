
/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        //  side length of the maximum square whose bottom right corner is the cell
        int[] side = new int[n + 1];
        int result = 0, UpLeft = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = side[j];
                if (matrix[i - 1][j - 1] == '1') {
                    // min(top cell, left cell, up-left cell)
                    side[j] = Math.min(side[j - 1], Math.min(side[j], UpLeft)) + 1;
                    result = Math.max(result, side[j]);
                } else {
                    side[j] = 0;
                }
                UpLeft = temp;
            }
        }

        return result * result;
    }
}
// @lc code=end

