/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int maxFreq = 0;
        int freq = 0;
        int[] dict = new int[26];
        for (char task : tasks) {
            dict[task - 'A']++;
            if (freq == dict[task - 'A']) {
                maxFreq++;
            } else if (freq < dict[task - 'A']) {
                maxFreq = 1;
                freq = dict[task - 'A'];
            }
        }

        int idlePart = freq - 1;
        int idleLength = n - maxFreq + 1;
        int otherTasks = tasks.length - maxFreq * freq;
        int result = Math.max(0, idlePart * idleLength - otherTasks);
        return tasks.length + result;
    }
}
// @lc code=end

