import java.util.*;

/*
 * @lc app=leetcode id=1801 lang=java
 *
 * [1801] Number of Orders in the Backlog
 */

// @lc code=start
class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        int mod = 1000000007;
        int result = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                maxHeap.offer(order);
            } else {
                minHeap.offer(order);
            }
            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek()[0] >= minHeap.peek()[0]) {
                int amount = Math.min(maxHeap.peek()[1], minHeap.peek()[1]);
                maxHeap.peek()[1] -= amount;
                minHeap.peek()[1] -= amount;
                if (maxHeap.peek()[1] == 0) {
                    maxHeap.poll();
                }
                if (minHeap.peek()[1] == 0) {
                    minHeap.poll();
                }
            }
        }
        for (int[] buy : maxHeap) {
            result = (result + buy[1]) % mod;
        }
        for (int[] sell : minHeap) {
            result = (result + sell[1]) % mod;
        }

        return result;
    }
}
// @lc code=end

