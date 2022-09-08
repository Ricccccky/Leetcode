import java.util.*;

/*
 * @lc app=leetcode id=871 lang=java
 *
 * [871] Minimum Number of Refueling Stops
 */

// @lc code=start
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int result = 0, location = 0;
        for (int[] station : stations) {
            startFuel -= station[0] - location;
            while (!maxHeap.isEmpty() && startFuel < 0) {
                startFuel += maxHeap.poll();
                result++;
            }
            if (startFuel < 0) {
                return -1;
            }
            maxHeap.offer(station[1]);
            location = station[0];
        }
        startFuel -= target - location;
        while (!maxHeap.isEmpty() && startFuel < 0) {
            startFuel += maxHeap.poll();
            result++;
        }

        return startFuel < 0 ? -1 : result;
    }
}
// @lc code=end

