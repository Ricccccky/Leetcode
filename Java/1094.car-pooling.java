import java.util.*;

/*
 * @lc app=leetcode id=1094 lang=java
 *
 * [1094] Car Pooling
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> locations = new TreeMap<>();
        int cur = 0;
        for (int[] trip : trips) {
            locations.put(trip[1], locations.getOrDefault(trip[1], 0) + trip[0]);
            locations.put(trip[2], locations.getOrDefault(trip[2], 0) - trip[0]);
        }
        for (Map.Entry<Integer, Integer> entry : locations.entrySet()) {
            cur += entry.getValue();
            if (cur > capacity) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

