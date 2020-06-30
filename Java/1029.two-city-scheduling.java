import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1029 lang=java
 *
 * [1029] Two City Scheduling
 */

// @lc code=start
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int result = 0;
        PriorityQueue<Integer> temp = new PriorityQueue<>();
        for (int[] cost : costs) {
            temp.add(cost[1] - cost[0]);
            result += cost[0];
        }
        for (int i = 0; i < costs.length / 2; i++) {
            result += temp.poll();
        }
        return result;
    }
}
// @lc code=end

