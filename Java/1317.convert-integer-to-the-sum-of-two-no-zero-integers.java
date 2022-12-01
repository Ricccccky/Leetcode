/*
 * @lc app=leetcode id=1317 lang=java
 *
 * [1317] Convert Integer to the Sum of Two No-Zero Integers
 */

// @lc code=start
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (!containZero(i) && !containZero(n - i)) {
                return new int[] {i, n - i};
            }
        }

        return new int[] {-1};
    }

    private boolean containZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return true;
            }
            num /= 10;
        }
        
        return false;
    }
}
// @lc code=end

