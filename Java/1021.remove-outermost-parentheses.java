/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String S) {
        if (S == null || S.length() <= 2) {
            return "";
        }
        int left = 0, right = 0;
        int top = 1;
        String result = "";
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            }
            if (S.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                result += S.substring(top, i);
                top = i + 2;
            }
        }
        return result;
    }
}
// @lc code=end

