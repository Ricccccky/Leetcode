/*
 * @lc app=leetcode id=905 lang=java
 *
 * [905] Sort Array By Parity
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length, l = 0, r = 0;
        while (r < n) {
            if (nums[r] % 2 == 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
        }

        return nums;
    }
}
// @lc code=end

