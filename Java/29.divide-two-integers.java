/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int HALF_MIN_VALUE = Integer.MIN_VALUE / 2;
        int negatives = 2;
        int res = 0;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }
        // O(log^2N), save all power and value pairs to get O(logN)
        while (dividend <= divisor) {
            int power = -1;
            int value = divisor;
            while (value >= HALF_MIN_VALUE && value + value >= dividend) {
                value += value;
                power += power;
            }
            res += power;
            dividend -= value;
        }
        if (negatives != 1) {
            res = -res;
        }

        return res;
    }
}
// @lc code=end

