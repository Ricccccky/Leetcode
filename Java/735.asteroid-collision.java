import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.add(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() + asteroid < 0) {
                    stack.removeLast();
                }
                if (stack.isEmpty() || stack.peekLast() < 0) {
                    stack.add(asteroid);
                } else if (stack.peekLast() + asteroid == 0) {
                    stack.removeLast();
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.removeFirst();
        }
        return result;
    }
}
// @lc code=end

