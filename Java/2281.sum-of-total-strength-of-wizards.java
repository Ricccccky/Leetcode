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
        int mod = (int)1e9+7;
        int n = strength.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] pre_sum = new int[n + 2];
        for (int r = 0; r < n; r++) {
            sum = (sum + strength[r]) % mod;
            pre_sum[r + 1] = (sum + pre_sum[r]) % mod;
            while (!stack.isEmpty() && strength[stack.peekLast()] > strength[r]) {
                int i = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek();
                long lacc = l < 0 ? pre_sum[i] : pre_sum[i] - pre_sum[l], racc = pre_sum[r] - pre_sum[i];
                int ln = i - l, rn = r - i;
                result = (int)(result + (racc * ln - lacc * rn) % mod * strength[i] % mod) % mod;
            }
            stack.push(r);
        }

        return result % mod;
    }
}
// @lc code=end

