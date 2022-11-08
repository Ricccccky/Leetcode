/*
 * @lc app=leetcode id=829 lang=java
 *
 * [829] Consecutive Numbers Sum
 */

// @lc code=start
class Solution {
    public int consecutiveNumbersSum(int n) {
        int result = 0;
        int upperBound = (int)(Math.sqrt(2 * n + 0.25) - 0.5);
        for (int k = 1; k <= upperBound; k++) {
            if ((n - k * (k + 1) / 2) % k == 0) {
                result++;
            }
        }

        return result;
    }
}
// @lc code=end

