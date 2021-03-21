import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=857 lang=java
 *
 * [857] Minimum Cost to Hire K Workers
 */

// @lc code=start
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        int sum = 0;
        int[][] pairs = new int[n][2];
        double res = Double.MAX_VALUE;
        // Largest quality on the top
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {quality[i], wage[i]};
        }
        // Asending order, guarantee paid
        Arrays.sort(pairs, (w1, w2) -> Double.compare((double)w1[1] / w1[0], (double)w2[1] / w2[0]));
        for (int[] pair : pairs) {
            if (queue.size() == K) {
                sum -= queue.poll();
            }
            queue.offer(pair[0]);
            sum += pair[0];
            if (queue.size() == K) {
                double ratio = (double)pair[1] / pair[0];
                res = Math.min(res, ratio * sum);
            }
        }

        return res;
    }
}
// @lc code=end

