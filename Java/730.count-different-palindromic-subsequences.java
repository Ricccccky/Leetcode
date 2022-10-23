/*
 * @lc app=leetcode id=730 lang=java
 *
 * [730] Count Different Palindromic Subsequences
 */

// @lc code=start
class Solution {
    // O(n^3)
    public int countPalindromicSubsequences(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][n];
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if (arr[i] == arr[j]) {
                    int l = i + 1;
                    int r = j - 1;
                    while (l <= r && arr[l] != arr[i]) {
                        l++;
                    }
                    while (l <= r && arr[r] != arr[i]) {
                        r--;
                    }
                    if (l > r) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (l == r) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[l + 1][r - 1];
                    }
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + mod : dp[i][j] % mod;
            }
        }

        return dp[0][n - 1];
    }
}
// @lc code=end

