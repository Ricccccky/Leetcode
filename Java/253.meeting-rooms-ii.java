import java.util.*;

/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
        for (int[] interval : intervals) {
            if (!queue.isEmpty() && queue.peek()[1] <= interval[0]) {
                queue.poll();
            }
            queue.add(interval);
            res = Math.max(res, queue.size());
        }

        return res;
    }
}
// @lc code=end

