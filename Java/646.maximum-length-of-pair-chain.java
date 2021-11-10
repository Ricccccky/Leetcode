import java.util.*;

/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        int res = 1;
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}
// @lc code=end

