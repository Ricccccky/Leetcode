import java.util.*;

/*
 * @lc app=leetcode id=1834 lang=java
 *
 * [1834] Single-Threaded CPU
 */

// @lc code=start
class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int taskIdx = 0, resIdx = 0, curTime = 1;
        int[] result = new int[n];
        int[][] threads = new int[n][3];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((t1, t2) -> t1[1] == t2[1] ? t1[2] - t2[2] : t1[1] - t2[1]);
        for (int i = 0; i < n; i++) {
            threads[i][0] = tasks[i][0];
            threads[i][1] = tasks[i][1];
            threads[i][2] = i;
        }
        Arrays.sort(threads, (t1, t2) -> t1[0] - t2[0]);
        while (taskIdx < n || !minHeap.isEmpty()) {
            if (minHeap.isEmpty() && curTime < threads[taskIdx][0]) {
                curTime = threads[taskIdx][0];
            }
            while (taskIdx < n && curTime >= threads[taskIdx][0]) {
                minHeap.offer(threads[taskIdx++]);
            }
            int[] next = minHeap.poll();
            curTime += next[1];
            result[resIdx++] = next[2];
        }

        return result;
    }
}
// @lc code=end

