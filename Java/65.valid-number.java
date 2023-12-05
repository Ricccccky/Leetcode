/*
 * @lc app=leetcode id=65 lang=java
 *
 * [65] Valid Number
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        boolean seenE = false, seenDot = false, seenDigit = false;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                seenDigit = false;
            } else if (c == '.') {
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else {
                return false;
            }
        }

        return seenDigit;
    }
}
// @lc code=end

