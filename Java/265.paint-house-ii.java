/*
 * @lc app=leetcode id=265 lang=java
 *
 * [265] Paint House II
 */

// @lc code=start
class Solution {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int prev_min = 0, prev_sec = 0;
        int prev_idx = -1;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE, sec = Integer.MAX_VALUE, min_idx = -1;
            for (int j = 0; j < k; j++) {
                int cost = costs[i][j];
                if (j == prev_idx) {
                    cost += prev_sec;
                } else {
                    cost += prev_min;
                }
                if (cost < min) {
                    sec = min;
                    min = cost;
                    min_idx = j;
                } else if (cost < sec) {
                    sec = cost;
                }
            }
            prev_min = min;
            prev_sec = sec;
            prev_idx = min_idx;
        }

        return prev_min;
    }
}
// @lc code=end

