import java.util.*;

/*
 * @lc app=leetcode id=1338 lang=java
 *
 * [1338] Reduce Array Size to The Half
 */

// @lc code=start
class Solution {
    public int minSetSize(int[] arr) {
        int result = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (var key : map.keySet()) {
            heap.offer(key);
        }
        while (sum < arr.length / 2) {
            int top = heap.poll();
            sum += map.get(top);
            result++;
        }

        return result;
    }
}
// @lc code=end

