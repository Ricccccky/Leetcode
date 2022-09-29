/*
 * @lc app=leetcode id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int l = 0, r = n - 1, i = n - 1;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                result[i--] = nums[l] * nums[l];
                l++;
            } else {
                result[i--] = nums[r] * nums[r];
                r--;
            }
        }

        return result;
    }
}
// @lc code=end

