/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        int lo = 1, hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            long prod = (long)mid * mid;
            if (prod > x) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }

        return lo;
    }
}
// @lc code=end

