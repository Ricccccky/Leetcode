/*
 * @lc app=leetcode id=1541 lang=java
 *
 * [1541] Minimum Insertions to Balance a Parentheses String
 */

// @lc code=start
class Solution {
    public int minInsertions(String s) {
        int n = s.length(), left = 0, res = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (i + 1 < n && s.charAt(i + 1) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    // Insert a '('
                    res++;
                }
                // Skip the duplicate ')'
                i++;
            } else {
                if (left > 0) {
                    left--;
                    res++;
                } else {
                    res += 2;
                }
            }
        }

        return res + left * 2;
    }
}
// @lc code=end

