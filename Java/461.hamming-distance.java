/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        // return Integer.bitCount(x ^ y);

        int res = 0;
        int z = x ^ y;
        while (z != 0) {
            if ((z & 1) == 1) {
                res++;
            }
            z = z >> 1;
        }

        return res;
    }
}
// @lc code=end

