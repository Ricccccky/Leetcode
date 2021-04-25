/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1;
        int hi = num;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long prod = (long)mid * mid;
            if (prod == num) {
                return true;
            } else if (prod > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }
}
// @lc code=end

