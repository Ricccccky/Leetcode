import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=918 lang=java
 *
 * [918] Maximum Sum Circular Subarray
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int res = A[0];
        int N = A.length;
        int[] prefix = new int[2 * N + 1];
        for (int i = 0; i < 2 * N; i++) {
            prefix[i + 1] = prefix[i] + A[i % N];
        }
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);
        for (int i = 1; i <= 2 * N; i++) {
            if (queue.peekFirst() < i - N) {
                queue.pollFirst();
            }
            res = Math.max(res, prefix[i] - prefix[queue.peekFirst()]);
            while (!queue.isEmpty() && prefix[i] <= prefix[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        return res;
    }
}
// @lc code=end

