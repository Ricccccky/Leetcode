/*
 * @lc app=leetcode id=476 lang=java
 *
 * [476] Number Complement
 */

// @lc code=start
class Solution {
    public int findComplement(int num) {
        int mask = 1 << 30;
        while ((mask & num) == 0) {
            mask >>= 1;
        }
        mask = (mask << 1) - 1;

        return num ^ mask;
    }
}
// @lc code=end

