import java.util.*;

/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> rows = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int row = 0;
        boolean goingDown = false;
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        for (char c : s.toCharArray()) {
            rows.get(row).append(c);
            if (row == 0 || row == rows.size() - 1) {
                goingDown = !goingDown;
            }
            row += goingDown ? 1 : -1;
        }

        for (var sb : rows) {
            result.append(sb);
        }

        return result.toString();
    }
}
// @lc code=end

