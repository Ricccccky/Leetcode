import java.util.*;

/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    // Greedy
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[1], y[1]));
        int prev = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) {
                res++;
            } else {
                prev = intervals[i][1];
            }
        }

        return res;
    }
}
// @lc code=end

