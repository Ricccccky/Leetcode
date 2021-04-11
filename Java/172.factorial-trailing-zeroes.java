/*
 * @lc app=leetcode id=172 lang=java
 *
 * [172] Factorial Trailing Zeroes
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        long factor = 5;
        while (n >= factor) {
            res += n / factor;
            factor *= 5;
        }

        return res;
    }
}
// @lc code=end

