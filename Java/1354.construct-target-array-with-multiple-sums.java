import java.util.*;

/*
 * @lc app=leetcode id=1354 lang=java
 *
 * [1354] Construct Target Array With Multiple Sums
 */

// @lc code=start
class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        int sum = Arrays.stream(target).sum();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int t : target) {
            queue.offer(t);
        }
        while (queue.peek() > 1) {
            int max = queue.poll();
            int rest = sum - max;
            if (rest == 1) {
                return true;
            }
            int origin = max % rest;
            if (origin == 0 || origin == max) {
                return false;
            }
            sum = rest + origin;
            queue.offer(origin);
            
        }

        return true;
    }
}
// @lc code=end

