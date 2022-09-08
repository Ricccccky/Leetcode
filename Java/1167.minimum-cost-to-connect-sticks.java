import java.util.*;

/*
 * @lc app=leetcode id=1167 lang=java
 *
 * [1167] Minimum Cost to Connect Sticks
 */

// @lc code=start
class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int result = 0;
        for (int stick : sticks) {
            minHeap.offer(stick);
        }
        while (minHeap.size() > 1) {
            int s1 = minHeap.poll();
            int s2 = minHeap.poll();
            result += s1 + s2;
            minHeap.offer(s1 + s2);
        }

        return result;
    }
}
// @lc code=end

