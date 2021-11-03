/*
 * @lc app=leetcode id=633 lang=java
 *
 * [633] Sum of Square Numbers
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (long)Math.sqrt(c);
        while (i <= j) {
            long sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
// @lc code=end

