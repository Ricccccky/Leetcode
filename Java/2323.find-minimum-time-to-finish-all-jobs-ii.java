/*
 * @lc app=leetcode id=2323 lang=java
 *
 * [2323] Find Minimum Time to Finish All Jobs II
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int n = jobs.length, res = 0;
        for (int i = 0; i < n; i++) {
            int time = jobs[i] / workers[i];
            if (jobs[i] % workers[i] != 0) {
                time++;
            }
            res = Math.max(res, time);
        }

        return res;
    }
}
// @lc code=end

