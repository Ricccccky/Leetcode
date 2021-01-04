/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] result = new int[nums.length - k + 1];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (i % k != 0) {
                left[i] = Math.max(nums[i], left[i - 1]);
            } else {
                left[i] = nums[i];
            }
            if ((nums.length - i - 1) % k != 0) {
                right[nums.length - i - 1] = Math.max(nums[nums.length - i - 1], right[nums.length - i]);
            } else {
                right[nums.length - i - 1] = nums[nums.length - i - 1];
            }
        }
        int head = 0;
        for (int i = 0; i + k <= nums.length; i++) {
            result[head]= Math.max(left[i + k - 1], right[i]);
            head++;
        }
        return result;
    }
}
// @lc code=end

