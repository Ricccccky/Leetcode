/*
 * @lc app=leetcode id=233 lang=java
 *
 * [233] Number of Digit One
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        long res = 0;
        for (long i = 1; i <= n; i *= 10) {
            long base = i * 10;
            res += (n / base) * i + Math.min(Math.max(n % base - i + 1, 0), i);
        }

        return (int)res;
    }
}
// @lc code=end

