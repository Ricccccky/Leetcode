/*
 * @lc app=leetcode id=1470 lang=java
 *
 * [1470] Shuffle the Array
 */

// @lc code=start
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = n - 1;
        for (int j = nums.length - 1; j >= n; j--) {
            nums[j] <<= 10;
            nums[j] |= nums[i--];
        }
        i = 0;
        for (int j = n; j < nums.length; j++) {
            int low = nums[j] & 1023;
            int high = nums[j] >> 10;
            nums[i] = low;
            nums[i + 1] = high;
            i += 2;
        }

        return nums;
    }
}
// @lc code=end

