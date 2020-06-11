/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int pre = 0;
        int cur = 1;
        int result = 0;
        for (int i = 2; i <= N; i++) {
            result = cur + pre;
            pre = cur;
            cur = result;
        }
        return result;
    }
}
// @lc code=end

