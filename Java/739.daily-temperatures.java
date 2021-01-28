import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peekFirst()]) {
                res[stack.peekFirst()] = i - stack.removeFirst();
            }
            stack.addFirst(i);
        }
        while (!stack.isEmpty()) {
            res[stack.removeFirst()] = 0;
        }

        return res;
    }
}
// @lc code=end

