/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int idx = 1;
        for (int i = 1; i < 32; i += 2) {
            int tmp = n >>> i;
            int mask = 1 << (16 - idx);
            res |= tmp & mask;
            tmp = n << i;
            mask = 1 << (15 + idx++);
            res |= tmp & mask;
        }

        return res;
    }
}
// @lc code=end

