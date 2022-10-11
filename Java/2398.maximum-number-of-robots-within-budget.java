import java.util.*;

/*
 * @lc app=leetcode id=2398 lang=java
 *
 * [2398] Maximum Number of Robots Within Budget
 */

// @lc code=start
class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> maxStack = new LinkedList<>();
        long sum = 0;
        int n = chargeTimes.length, l = 0;
        for (int r = 0; r < n; r++) {
            sum += runningCosts[r];
            while (!maxStack.isEmpty() && chargeTimes[maxStack.peekLast()] <= chargeTimes[r]) {
                maxStack.pollLast();
            }
            maxStack.addLast(r);
            if (chargeTimes[maxStack.getFirst()] + (r - l + 1) * sum > budget) {
                if (maxStack.getFirst() == l) {
                    maxStack.pollFirst();
                }
                // Never shrink the window
                sum -= runningCosts[l++];
            }
        }

        return n - l;
    }
}
// @lc code=end

