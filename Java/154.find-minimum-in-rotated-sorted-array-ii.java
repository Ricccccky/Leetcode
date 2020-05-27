import java.util.Arrays;

/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                if (nums[mid] > nums[high]) {
                    low = mid + 1;
                } else {
                    high--;
                }
            } else {
                if (nums[mid] <= nums[high]) {
                    high = mid;
                }
            }
        }
        return nums[low];
    }
}
// @lc code=end

