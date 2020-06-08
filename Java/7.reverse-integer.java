/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long result = 0;
        if (x == 0) {
            return 0;
        } else {
            while (x != 0) {
                result = result * 10 + x % 10;
                x /= 10;
            }
        }
        if (result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE) {
            return (int)result;
        } else {
            return 0;
        }
    }
}
// @lc code=end

