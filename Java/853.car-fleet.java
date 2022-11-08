import java.util.*;

/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int result = 0;
        double time = 0;
        Map<Integer, Double> map = new TreeMap<>((k1, k2) -> k2 - k1);
        for (int i = 0; i < n; i++) {
            map.put(position[i], (double)(target - position[i]) / speed[i]);
        }
        for (var entry : map.entrySet()) {
            if (entry.getValue() > time) {
                result++;
                time = entry.getValue();
            }
        }

        return result;
    }
}
// @lc code=end

