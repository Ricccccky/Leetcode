/*
 * @lc app=leetcode id=296 lang=java
 *
 * [296] Best Meeting Point
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    cols.add(j);
                }
            }
        }
        int medRow = rows.get(rows.size() / 2);
        int medCol = cols.get(cols.size() / 2);
        for (Integer r : rows) {
            res += Math.abs(medRow - r);
        }
        for (Integer c : cols) {
            res += Math.abs(medCol - c);
        }

        return res;
    }
}
// @lc code=end

