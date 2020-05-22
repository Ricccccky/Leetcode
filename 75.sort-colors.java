/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int[] counter = {0, 0, 0};
        for (int i = 0; i < nums.length; i ++) {
            counter[nums[i]]++;
        }
        for (int i = 0; i < counter[0]; i++) {
            nums[i] = 0;
        }

        for (int i = counter[0]; i < counter[0] + counter[1]; i++) {
            nums[i] = 1;
        }

        for (int i = counter[0] + counter[1]; i < counter[0] + counter[1] + counter[2]; i++) {
            nums[i] = 2;
        }
    }
}
// @lc code=end

