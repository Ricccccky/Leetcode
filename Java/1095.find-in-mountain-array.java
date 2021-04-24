/*
 * @lc app=leetcode id=1095 lang=java
 *
 * [1095] Find in Mountain Array
 */

// @lc code=start
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int lo = 0;
        int hi = n - 1;
        int peak = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        peak = lo;
        lo = 0;
        hi = peak;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mountainArr.get(mid) < target) {
                lo = mid + 1;
            } else if (mountainArr.get(mid) > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        lo = peak;
        hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (mountainArr.get(mid) < target) {
                hi = mid - 1;
            } else if (mountainArr.get(mid) > target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
// @lc code=end

