/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // int low = 0, high = nums.length - 1;
        // while (low <= high) {
        //     int mid = (low + high) / 2;
        //     if (nums[mid] == target) {
        //         return mid;
        //     }

        //     if (nums[low] <= nums[mid]) {
        //         if (nums[low] <= target && nums[mid] >= target) {
        //             high = mid;
        //         } else {
        //             low = mid + 1;
        //         }
        //     } else {
        //         if (nums[mid] <= target && nums[high] >= target) {
        //             low = mid;
        //         } else {
        //             high = mid - 1;
        //         }
        //     }
        // }

        int low = 0, high = nums.length;
        double midValue;
        while (low < high) {
            int mid = (low + high) / 2;
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                midValue = nums[mid];
            } else {
                if (target < nums[0]) {
                    midValue = Double.NEGATIVE_INFINITY;
                } else {
                    midValue = Double.POSITIVE_INFINITY;
                }
            }
            if (midValue < target) {
                low = mid + 1;
            } else if (midValue > target) {
                high = mid;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}
// @lc code=end

