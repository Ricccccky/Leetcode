/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        Queue<int[]> queue = new PriorityQueue<>((s1, s2) -> Integer.compare(s1[1], s2[1]));
        queue.offer(new int[] {src, 0, K});
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            if (top[0] == dst) {
                return top[1];
            }
            if (top[2] >= 0) {
                Map<Integer, Integer> temp = map.getOrDefault(top[0], new HashMap<>());
                for (Map.Entry<Integer, Integer> e : temp.entrySet()) {
                    queue.offer(new int[] {e.getKey(), top[1] + e.getValue(), top[2] - 1});
                }
            }
        }
        
        return -1;
    }
}
// @lc code=end

