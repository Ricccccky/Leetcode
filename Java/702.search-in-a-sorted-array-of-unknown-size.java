/*
 * @lc app=leetcode id=702 lang=java
 *
 * [702] Search in a Sorted Array of Unknown Size
 */

// @lc code=start
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int lo = 0;
        int hi = 9999;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (reader.get(mid) > target) {
                hi = mid - 1;
            } else if (reader.get(mid) < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
// @lc code=end

