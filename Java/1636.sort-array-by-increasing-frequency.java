import java.util.*;

/*
 * @lc app=leetcode id=1636 lang=java
 *
 * [1636] Sort Array by Increasing Frequency
 */

// @lc code=start
class Solution {
    // O(nlogn)
    public int[] frequencySort(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> map.get(x) == map.get(y) ? y - x : map.get(x) - map.get(y));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
// @lc code=end

