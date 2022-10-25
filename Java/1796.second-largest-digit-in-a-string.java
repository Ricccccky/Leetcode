/*
 * @lc app=leetcode id=1796 lang=java
 *
 * [1796] Second Largest Digit in a String
 */

// @lc code=start
class Solution {
    public int secondHighest(String s) {
        boolean[] visited = new boolean[10];
        boolean seen = false;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                visited[c - '0'] = true;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (visited[i]) {
                if (seen) {
                    return i;
                }
                seen = true;
            }
        }

        return -1;
    }
}
// @lc code=end

