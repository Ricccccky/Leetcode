import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        boolean isInserted = false;
        while (i < intervals.length) {
            if (intervals[i][1] < newInterval[0] && !isInserted) {
                result.add(intervals[i]);
                i++;
                continue;
            }
            isInserted = true;
            if (intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            } else {
                break;
            }
        }
        result.add(newInterval);
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

