/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int lo = 1;
        int hi = x;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > x / mid) {
                hi = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                lo = mid + 1;
            }
        }

        return 0;
    }
}
// @lc code=end

