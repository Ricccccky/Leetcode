/*
 * @lc app=leetcode id=2060 lang=java
 *
 * [2060] Check if an Original String Exists Given Two Encoded Strings
 */

// @lc code=start
class Solution {
    // O(mn*2*10^3)
    public boolean possiblyEquals(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        /*
         * Since the number of consecutive digits does not exceed 3, the largest sequence length is 999.
         * The length difference can be from 999 to -999, then select 2000.
         * 
         * Positive diff means s1 has more wildcards, negative - the other one.
         */
        boolean[][][] visited = new boolean[m + 1][n + 1][2000];
        return dfs(s1, s2, 0, 0, 0, visited);
    }

    private boolean dfs(String s1, String s2, int x, int y, int diff, boolean[][][] visited) {
        int m = s1.length(), n = s2.length();
        if (x == m && y == n) {
            return diff == 0;
        }

        // 3rd dimension represent [-999, 999], so add 1000 in advance
        if (!visited[x][y][diff + 1000]) {
            visited[x][y][diff + 1000] = true;

            if (x < m && Character.isDigit(s1.charAt(x))) {
                // Convert digits all possible count and backtracking
                int len = 0, k = 0;
                while (x + k < m && Character.isDigit(s1.charAt(x + k))) {
                    len = len * 10 + s1.charAt(x + k) - '0';
                    k++;
                    if (dfs(s1, s2, x + k, y, diff + len, visited)) return true;
                }
                return false;
            }

            if (y < n && Character.isDigit(s2.charAt(y))) {
                // Convert digits all possible count and backtracking
                int len = 0, k = 0;
                while (y + k < n && Character.isDigit(s2.charAt(y + k))) {
                    len = len * 10 + s2.charAt(y + k) - '0';
                    k++;
                    if (dfs(s1, s2, x, y + k, diff - len, visited)) return true;
                }
                return false;
            }

            if (diff > 0) {
                // s1 has more wildcards
                return y < n && dfs(s1, s2, x, y + 1, diff - 1, visited);
            } else if (diff < 0) {
                // s2 has more wildcards
                return x < m && dfs(s1, s2, x + 1, y, diff + 1, visited);
            } else {
                // s1 and s2 have equal wildcards
                return x < m && y < n && s1.charAt(x) == s2.charAt(y) && dfs(s1, s2, x + 1, y + 1, diff, visited);
            }
        }

        return false;
    }
}
// @lc code=end

