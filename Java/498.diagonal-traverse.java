/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start

import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, k = 0;
        int[] res = new int[m * n];
        // List<Integer> list = new ArrayList<>();
        for (int sum = 0; sum <= m - 1 + n - 1; sum++) {
            if (sum % 2 == 1) {
                // From first row
                for (int i = Math.max(sum - n + 1, 0); i <= Math.min(sum, m - 1); i++) {
                    int j = sum - i;
                    res[k++] = mat[i][j];
                }
            } else {
                // From last row
                for (int i = Math.min(sum, m - 1); i >= Math.max(sum - n + 1, 0); i--) {
                    int j = sum - i;
                    res[k++] = mat[i][j];
                }
            }
        }

        return res;
    }
}
// @lc code=end

