import java.util.*;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] cur = intervals[0];
        result.add(cur);
        for (int[] interval : intervals) {
            if (interval[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], interval[1]);
            } else {
                cur = interval;
                result.add(cur);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

