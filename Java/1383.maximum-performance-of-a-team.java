import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1383 lang=java
 *
 * [1383] Maximum Performance of a Team
 */

// @lc code=start
class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long res = 0;
        long sum_speed = 0;
        long mod = 1000000007;
        int[][] pairs = new int[n][2];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {speed[i], efficiency[i]};
        }
        Arrays.sort(pairs, (e1, e2) -> -Integer.compare(e1[1], e2[1]));
        for (int i = 0; i < n; i++) {
            sum_speed += pairs[i][0];
            if (queue.size() == k) {
                sum_speed -= queue.poll();
            }
            queue.offer(pairs[i][0]);
            res = Math.max(res, sum_speed * pairs[i][1]);
        }

        return (int)(res % mod);
    }
}
// @lc code=end

