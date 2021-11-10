/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int code = s.charAt(i - 1) - '0';
            // Add to the tail if not zero
            if (code > 0) {
                dp[i] += dp[i - 1];
            }
            // Construct two-digit number
            if (code + 10 * (s.charAt(i - 2) - '0') <= 26 && code + 10 * (s.charAt(i - 2) - '0') >= 10) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}
// @lc code=end

