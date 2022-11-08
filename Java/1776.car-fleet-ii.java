import java.util.*;

/*
 * @lc app=leetcode id=1776 lang=java
 *
 * [1776] Car Fleet II
 */

// @lc code=start
class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] result = new double[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            result[i] = -1.0;
            int pos = cars[i][0], spd = cars[i][1];
            while (!stack.isEmpty()) {
                int top = stack.peek(), top_pos = cars[top][0], top_spd = cars[top][1];
                /*
                 * if i can collide top || (if i can collide top before top collide its next car && has top collided next car)
                 * if top has collided next car, top's speed must be slowed down, i will collide the fleet with slower speed
                 * The status fleet can be represented as the next car collided by top
                */
                if (spd <= top_spd || 1.0 * (top_pos - pos) / (spd - top_spd) >= result[top] && result[top] > 0) {
                    // i cannot collide top / i collide the slow fleet including top
                    stack.poll();
                } else {
                    // i will collide top
                    break;
                }
            }
            if (!stack.isEmpty()) {
                int top = stack.peek(), top_pos = cars[top][0], top_spd = cars[top][1];
                result[i] = 1.0 * (top_pos - pos) / (spd - top_spd);
            }
            stack.push(i);
        }

        return result;
    }
}
// @lc code=end

