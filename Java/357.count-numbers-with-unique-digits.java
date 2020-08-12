/*
 * @lc app=leetcode id=357 lang=java
 *
 * [357] Count Numbers with Unique Digits
 */

// @lc code=start
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int result = 10;
        int num = 9;
        int temp = 9;
        for (int i = 1; i < n; i++) {
            num *= temp;
            temp--;
            result += num;
        }
        return result;
    }
}
// @lc code=end

