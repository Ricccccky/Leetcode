/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length
            res += count(s, i, i);
            // even length
            res += count(s, i, i + 1);
        }

        return res;

        // DP
        // int res = 0;
        // int n = s.length();
        // boolean[][] dp = new boolean[n][n];
        // for (int i = 0; i < n; i++) {
        //     dp[i][i] = true;
        //     res++;
        // }
        // for (int i = 0; i < n - 1; i++) {
        //     if (s.charAt(i) == s.charAt(i + 1)) {
        //         dp[i][i + 1] = true;
        //         res++;
        //     }
        // }
        // for (int len = 3; len <= n; len++) {
        //     for (int i = 0; i + len - 1 < n; i++) {
        //         int j = i + len - 1;
        //         if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
        //             dp[i][j] = true;
        //             res++;
        //         }
        //     }
        // }

        // return res;
    }

    private int count(String s, int start, int end) {
        int res = 0;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start--;
            end++;
            // layer
            res++;
        }

        return res;
    }
}
// @lc code=end

