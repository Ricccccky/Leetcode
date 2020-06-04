/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];
        int[] result1 = new int[nums.length - 1];
        int[] result2 = new int[nums.length - 1];

        for (int i = 0; i < result1.length; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i + 1];
            result1[i] = -1;
            result2[i] = -1;
        }
        result1[0] = nums[0];
        result1[1] = Math.max(nums[0], nums[1]);
        result2[0] = nums[1];
        result2[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < nums.length - 1; i++) {
            result1[i] = Math.max(result1[i - 1], nums1[i] + result1[i - 2]);
            result2[i] = Math.max(result2[i - 1], nums2[i] + result2[i - 2]);
        }
        return Math.max(result1[nums.length - 2], result2[nums.length - 2]);
    }
}
// @lc code=end

