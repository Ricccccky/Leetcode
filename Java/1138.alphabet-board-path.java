import java.util.Collection;
import java.util.Collections;

/*
 * @lc app=leetcode id=1138 lang=java
 *
 * [1138] Alphabet Board Path
 */

// @lc code=start
class Solution {
    public String alphabetBoardPath(String target) {
        int x = 0, y = 0;
        StringBuilder result = new StringBuilder();
        char[] targetArray = target.toCharArray();
        for (char c : targetArray) {
            int new_x = (c - 'a') % 5;
            int new_y = (c - 'a') / 5;
            result.append(String.join("", Collections.nCopies(Math.max(0, y - new_y), "U")));
            result.append(String.join("", Collections.nCopies(Math.max(0, x - new_x), "L")));
            result.append(String.join("", Collections.nCopies(Math.max(0, new_y - y), "D")));
            result.append(String.join("", Collections.nCopies(Math.max(0, new_x - x), "R")));
            x = new_x;
            y = new_y;
            result.append("!");
        }
        return result.toString();
    }
}
// @lc code=end

