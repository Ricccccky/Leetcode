/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n];
        // boolean[] dp = new boolean[n];
        // for (int i = 0; i < n; i++) {
        //     cuts[i] = Integer.MAX_VALUE;
        //     for (int j = 0; j <= i; j++) {
        //         if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1])) {
        //             dp[j] = true;
        //             if (j == 0) {
        //                 cuts[i] = 0;
        //             } else {
        //                 cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
        //             }
        //         } else {
        //             dp[j] = false;
        //         }
        //     }
        // }

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            cuts[i] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j == 0) {
                        cuts[i] = 0;
                        break;
                    } else {
                        cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                    }
                }
            }
        }
        
        return cuts[n - 1];
    }
}
// @lc code=end

