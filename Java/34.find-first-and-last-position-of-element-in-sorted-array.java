
/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int[] result = new int[2];
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
            result[0] = -1;
            result[1] = -1;
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
        if (nums[left - 1] == target) {
            result[1] = left - 1;
        } else {
            result[1] = -1;
        }
        return result;
    }
}
// @lc code=end

