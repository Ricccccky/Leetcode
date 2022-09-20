
/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = searchPosition(nums, target);
        int last = searchPosition(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[] {-1, -1};
        } else {
            return new int[] {first, last};
        }
    }

    // find the position of first element or the position of insertion
    public int searchPosition(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
// @lc code=end

