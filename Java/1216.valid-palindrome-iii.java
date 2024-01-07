/*
 * @lc app=leetcode id=1216 lang=java
 *
 * [1216] Valid Palindrome III
 */

// @lc code=start
class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] numRemoval = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // Same # of removal as s[i + 1, j - 1]
                    numRemoval[i][j] = numRemoval[i + 1][j - 1];
                } else {
                    // Either remove char at i or at j, choose the smaller # of removal in previous steps
                    numRemoval[i][j] = Math.min(numRemoval[i + 1][j], numRemoval[i][j - 1]) + 1;
                }
            }
        }

        return numRemoval[0][n - 1] <= k;
    }
}
// @lc code=end

