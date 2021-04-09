import java.util.Arrays;

/*
 * @lc app=leetcode id=280 lang=java
 *
 * [280] Wiggle Sort
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 1 && nums[i] < nums[i - 1]) {
                swap(nums, i);
            } else if (i % 2 == 0 && nums[i] > nums[i - 1]) {
                swap(nums, i);
            }
        }
    }

    private void swap(int[] nums, int i) {
        int tmp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = tmp;
    }
}
// @lc code=end

