import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map.Entry;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        Queue<int[]> queue = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[0], p2[0]));
        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            queue.offer(new int[] {dist, point[0], point[1]});
        }
        while (K > 0) {
            int[] temp = queue.poll();
            result[K - 1][0] = temp[1];
            result[K - 1][1] = temp[2];
            K--;
        }
        return result;
    }
}
// @lc code=end

