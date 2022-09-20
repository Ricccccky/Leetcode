/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, tank = 0;
        int result = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                // set next station as a new start
                tank = 0;
                result = i + 1;
            }
        }
        
        return sum >= 0 ? result : -1;
    }
}
// @lc code=end

