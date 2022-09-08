import java.util.*;

/*
 * @lc app=leetcode id=1229 lang=java
 *
 * [1229] Meeting Scheduler
 */

// @lc code=start
class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((s1, s2) -> s1[0] - s2[0]);
        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration) {
                heap.offer(slot);
            }
        }
        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration) {
                heap.offer(slot);
            }
        }
        while (heap.size() > 1) {
            int[] first = heap.poll();
            int[] second = heap.peek();
            if (first[1] - second[0] >= duration) {
                result.add(second[0]);
                result.add(second[0] + duration);
                break;
            }
        }

        return result;
    }
}
// @lc code=end

