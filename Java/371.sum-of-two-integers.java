/*
 * @lc app=leetcode id=371 lang=java
 *
 * [371] Sum of Two Integers
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        int carry = (a & b) << 1;
        int sum = a ^ b;
        if (carry != 0) {
            return getSum(sum, carry);
        } else {
            return sum;
        }
    }
}
// @lc code=end

