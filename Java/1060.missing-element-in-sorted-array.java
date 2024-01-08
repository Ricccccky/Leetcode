/*
 * @lc app=leetcode id=1060 lang=java
 *
 * [1060] Missing Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length, left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - (nums[0] + mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        /*
         * l is the first index we have at least k missing numebrs, so we want to start from l - 1.
         * nums[l - 1] - (nums[0] + l - 1) missing number at l - 1, we need additional k - (nums[l - 1] - (nums[0] + l - 1)) missing numbers.
         * The target number should be k - (nums[l - 1] - (nums[0] + l - 1)) + nums[l - 1] = k + nums[0] + l - 1.
         */

        return k + nums[0] + left - 1;
    }
}
// @lc code=end

