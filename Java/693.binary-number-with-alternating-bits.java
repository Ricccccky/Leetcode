/*
 * @lc app=leetcode id=693 lang=java
 *
 * [693] Binary Number with Alternating Bits
 */

// @lc code=start
class Solution {
    public boolean hasAlternatingBits(int n) {
        int m = n ^ (n >> 1);
        // Change 011...11 to 100...00
        return (m & (m + 1)) == 0;
    }
}
// @lc code=end

