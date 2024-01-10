/*
 * @lc app=leetcode id=2109 lang=java
 *
 * [2109] Adding Spaces to a String
 */

// @lc code=start
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int m = s.length(), n = spaces.length, j = 0;
        for (int i = 0; i < m; i++) {
            if (j < n && i == spaces[j]) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
// @lc code=end

