/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int day = 1;
            int load = 0;
            for (int i = 0; i < weights.length; i++) {
                load += weights[i];
                if (load > mid) {
                    day++;
                    load = weights[i];
                }
            }
            if (day > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

