/*
 * @lc app=leetcode id=546 lang=java
 *
 * [546] Remove Boxes
 */

// @lc code=start
class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                dp[i][i][k] = (k + 1) * (k + 1);
            }
        }
        for (int l = 1; l < n; l++) {
            for (int start = 0; start < n - l; start++) {
                int end = start + l;
                for (int k = 0; k <= start; k++) {
                    int res = (k + 1) * (k + 1) + dp[start + 1][end][0];
                    for (int p = start + 1; p <= end; p++) {
                        if (boxes[start] == boxes[p]) {
                            // k + 1: original k boxes plus the boxes[j]
                            res = Math.max(res, dp[start + 1][p - 1][0] + dp[p][end][k + 1]);
                        }
                    }
                    dp[start][end][k] = res;
                }
            }
        }
        
        return dp[0][n - 1][0];
    }
}
// @lc code=end

