/*
 * @lc app=leetcode id=2365 lang=java
 *
 * [2365] Task Scheduler II
 */

// @lc code=start

import java.util.*;

class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> schedule = new HashMap<>();
        long res = 0;
        for (int task : tasks) {
            if (schedule.containsKey(task)) {
                res = Math.max(res, schedule.get(task) + space);
            }
            schedule.put(task, ++res);
        }

        return res;
    }
}
// @lc code=end

