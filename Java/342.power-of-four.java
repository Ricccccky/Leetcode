/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        int p = 1;
        while (n != 0) {
            int xor = n & 1;
            n >>>= 1;
            if (xor == 1 && p % 2 == 0) {
                return false;
            }
            count += xor;
            p++;
        }

        return count == 1;
    }
}
// @lc code=end

