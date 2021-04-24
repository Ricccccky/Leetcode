
/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            result[0] = left;
        } else {
            return result;
        }

        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        result[1] = left - 1;

        return result;
    }
}
// @lc code=end

