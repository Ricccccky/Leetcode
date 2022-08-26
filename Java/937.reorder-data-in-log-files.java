import java.util.*;

/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (l1, l2) -> {
            boolean isL1Letter = !Character.isDigit(l1.split(" ")[1].charAt(0));
            boolean isL2Letter = !Character.isDigit(l2.split(" ")[1].charAt(0));
            if (isL1Letter && isL2Letter) {
                String[] log1 = l1.split(" ", 2);
                String[] log2 = l2.split(" ", 2);
                if (log1[1].compareTo(log2[1]) == 0) {
                    return log1[0].compareTo(log2[0]);
                } else {
                    return log1[1].compareTo(log2[1]);
                }
            }
            if (isL1Letter) {
                return -1;
            }
            if (isL2Letter) {
                return 1;
            }
            return 0;
        });

        return logs;
    }
}
// @lc code=end

