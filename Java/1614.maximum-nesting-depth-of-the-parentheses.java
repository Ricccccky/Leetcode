/*
 * @lc app=leetcode id=1614 lang=java
 *
 * [1614] Maximum Nesting Depth of the Parentheses
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        int result = 0;
        char[] arr = s.toCharArray();
        int cur = 0;
        for (char c : arr) {
            if (c == '(') {
                cur++;
            }
            if (c == ')') {
                cur--;
            }
            result = Math.max(result, cur);
        }

        return result;
    }
}
// @lc code=end

