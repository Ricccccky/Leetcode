/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        // Count the boundary of the number of '('
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            // Assume '*' as ')', obain the lower boundary
            if (c == '(') {
                low++;
            } else {
                low--;
            }
            // Assume '*' as '(', obain the upper boundary
            if (c != ')') {
                high++;
            } else {
                high--;
            }
            
            if (high < 0) {
                break;
            }
            low = Math.max(low, 0);
        }

        return low == 0;
    }
}
// @lc code=end

