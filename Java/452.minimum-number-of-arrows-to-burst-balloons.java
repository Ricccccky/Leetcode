import java.util.*;

/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x, y) -> Integer.compare(x[1], y[1]));
        int res = 1;
        int prev = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prev) {
                res++;
                prev = points[i][1];
            }
        }

        return res;
    }
}
// @lc code=end

