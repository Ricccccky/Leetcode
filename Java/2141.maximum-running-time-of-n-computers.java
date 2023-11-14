/*
 * @lc app=leetcode id=2141 lang=java
 *
 * [2141] Maximum Running Time of N Computers
 */

// @lc code=start

import java.util.*;

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        Arrays.sort(batteries);
        for (int b : batteries) {
            sum += b;
        }
        int i = 0, m = batteries.length;
        while (batteries[m - 1 - i] > sum / (n - i)) {
            sum -= batteries[m - 1 - i++];
        }
        // Use the rest of batteries less than average time, can use all of them
        return sum / (n - i);
    }
}
// @lc code=end

