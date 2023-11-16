/*
 * @lc app=leetcode id=1751 lang=java
 *
 * [1751] Maximum Number of Events That Can Be Attended II
 */

// @lc code=start

import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (e1, e2) -> e1[0] - e2[0]);
        int[][] dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(events, k, 0, dp);
    }

    private int dfs(int[][] events, int count, int start, int[][] dp) {
        if (count == 0 || start == events.length) {
            return 0;
        }
        if (dp[count][start] != -1) {
            return dp[count][start];
        }
        int lo = 0, hi = events.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (events[mid][0] > events[start][1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        dp[count][start] = Math.max(dfs(events, count, start + 1, dp), events[start][2] + dfs(events, count - 1, lo, dp));

        return dp[count][start];
    }
}
// @lc code=end

