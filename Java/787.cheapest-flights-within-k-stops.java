import java.util.*;

/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    // Dijkstra, O(V^2logV)
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        int[] distance = new int[n];
        int[] hops = new int[n];
        // triple [node, cost, hops]
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((s1, s2) -> s1[1] - s2[1]);
        Arrays.fill(distance, 10001);
        Arrays.fill(hops, n);
        distance[src] = 0;
        hops[src] = 0;
        minHeap.offer(new int[] {src, 0, 0});
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            if (top[0] == dst) {
                return top[1];
            }
            if (top[2] > K) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                // flight exists
                if (graph[top[0]][i] > 0) {
                    int cost = graph[top[0]][i];
                    if (cost + top[1] < distance[i]) {
                        // Better cost
                        minHeap.offer(new int[] {i, cost + top[1], top[2] + 1});
                        distance[i] = cost + top[1];
                        hops[i] = top[2];
                    } else if (top[2] < hops[i]) {
                        // Better hops
                        minHeap.offer(new int[] {i, cost + top[1], top[2] + 1});
                    }
                }
            }
        }

        return distance[dst] == 10001 ? -1 : distance[dst];
    }
}
// @lc code=end

