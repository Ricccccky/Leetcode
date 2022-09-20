/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
            if (num == 0 && result / 10 > 0) {
                num = result;
                result = 0;
            }
        }

        return result;
    }
}
// @lc code=end

