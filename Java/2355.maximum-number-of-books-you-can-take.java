import java.util.*;

/*
 * @lc app=leetcode id=2355 lang=java
 *
 * [2355] Maximum Number of Books You Can Take
 */

// @lc code=start
class Solution {
    public long maximumBooks(int[] books) {
        Deque<Integer> stack = new LinkedList<>();
        long result = 0, sum = 0;
        for (int i = 0; i < books.length; i++) {
            while (!stack.isEmpty() && books[i] - books[stack.peek()] < i - stack.peek()) {
                // Previous one is larger, minus contribution of previous book and rebuild from i
                int top = stack.pop();
                sum -= getSum(books[top], stack.isEmpty() ? top + 1 : top - stack.peek());
            }
            // Previous one is smaller, add books[i] to current sum
            sum += getSum(books[i], stack.isEmpty() ? i + 1 : i - stack.peek());
            stack.push(i);
            result = Math.max(result, sum);
        }

        return result;
    }

    private long getSum(int num, int len) {
        // Sequence sum
        if (len >= num) {
            return (long)num * (num + 1) / 2;
        } else {
            return (long)len * ((num - len + 1) + num) / 2;
        }
    }
}
// @lc code=end

