/*
 * @lc app=leetcode id=743 lang=java
 *
 * [743] Network Delay Time
 */

// @lc code=start
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (N == 0 || times.length == 0) {
            return -1;
        }
        int result = 0;
        boolean flag = true;
        int[] endTime = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            endTime[i] = Integer.MAX_VALUE;
        }
        endTime[K] = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < times.length; i++) {
                if (endTime[times[i][0]] != Integer.MAX_VALUE) {
                    int temp = endTime[times[i][1]];
                    endTime[times[i][1]] = Math.min(endTime[times[i][1]], endTime[times[i][0]] + times[i][2]);
                    if (temp != endTime[times[i][1]]) {
                        flag = true;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (endTime[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(endTime[i], result);
        }
        return result;
    }
}
// @lc code=end

