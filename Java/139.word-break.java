import java.util.*;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i))) {
                    dp[i] |= dp[j];
                }
            }
        }
        
        return dp[m];
    }
}
// @lc code=end

