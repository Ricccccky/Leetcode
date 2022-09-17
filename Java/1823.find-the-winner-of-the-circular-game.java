import java.util.*;

/*
 * @lc app=leetcode id=1823 lang=java
 *
 * [1823] Find the Winner of the Circular Game
 */

// @lc code=start
class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            int count = k;
            while (count-- > 1) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();

        // Math approach
        // if (n == 1) {
        //     return 1;
        // }

        // return (k + findTheWinner(n - 1, k) - 1) % n + 1;
    }
}
// @lc code=end

