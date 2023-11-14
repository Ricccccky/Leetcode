/*
 * @lc app=leetcode id=774 lang=java
 *
 * [774] Minimize Max Distance to Gas Station
 */

// @lc code=start
class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double lo = 0, hi = stations[n - 1] - stations[0];
        while (hi - lo > 1e-6) {
            double mid = lo + (hi - lo) / 2;
            int newCount = 0;
            for (int i = 0; i < n - 1; i++) {
                newCount += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }
            if (newCount > k) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
// @lc code=end

