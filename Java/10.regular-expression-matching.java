/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        // '*' doesn't work
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        // '*' works, matches zero or more of the preceding element || not match
                        dp[i + 1][j + 1] = (dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}
// @lc code=end

