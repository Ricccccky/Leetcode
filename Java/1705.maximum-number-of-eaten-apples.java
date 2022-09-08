import java.util.*;

/*
 * @lc app=leetcode id=1705 lang=java
 *
 * [1705] Maximum Number of Eaten Apples
 */

// @lc code=start
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        int n = apples.length;
        int result = 0;
        for (int i = 0; i < n || !minHeap.isEmpty(); i++) {
            if (i < n) {
                minHeap.offer(new int[] {i + days[i], apples[i]});
            }
            while (!minHeap.isEmpty() && (minHeap.peek()[0] <= i || minHeap.peek()[1] <= 0)) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                result++;
                minHeap.peek()[1]--;
            }
        }

        return result;
    }
}
// @lc code=end

