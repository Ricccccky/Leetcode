/*
 * @lc app=leetcode id=852 lang=java
 *
 * [852] Peak Index in a Mountain Array
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > arr[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
// @lc code=end

