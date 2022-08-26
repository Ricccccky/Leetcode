import java.util.*;

/*
 * @lc app=leetcode id=2281 lang=java
 *
 * [2281] Sum of Total Strength of Wizards
 */

// @lc code=start
class Solution {
    public int totalStrength(int[] strength) {
        int result = 0, sum = 0;
        int mod = 1000000007;
        int n = strength.length;
        Deque<Integer> minStack = new LinkedList<>();
        int[] sumPrefix = new int[n + 2];
        for (int r = 0; r <= n; r++) {
            int w = r < n ? strength[r] : 0;
            sum = (sum + w) % mod;
            sumPrefix[r + 1] = (sum + sumPrefix[r]) % mod;
            while (!minStack.isEmpty() && strength[minStack.peekFirst()] > w) {
                int top = minStack.pop();
                int l = minStack.isEmpty() ? -1 : minStack.peek();
                long left_sum = l < 0 ? sumPrefix[top] : sumPrefix[top] - sumPrefix[l];
                long right_sum = sumPrefix[r] - sumPrefix[top];
                int ln = top - l, rn = r - top;
                result = (int)(result + (right_sum * ln - left_sum * rn) % mod * strength[top] % mod) % mod;
            }
            minStack.push(r);
        }

        return (result + mod) % mod;
    }
}
// @lc code=end

