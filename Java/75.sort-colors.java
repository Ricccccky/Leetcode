
/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        // Two-pass
        // int[] counter = {0, 0, 0};
        // for (int i = 0; i < nums.length; i ++) {
        //     counter[nums[i]]++;
        // }
        // for (int i = 0; i < counter[0]; i++) {
        //     nums[i] = 0;
        // }

        // for (int i = counter[0]; i < counter[0] + counter[1]; i++) {
        //     nums[i] = 1;
        // }

        // for (int i = counter[0] + counter[1]; i < counter[0] + counter[1] + counter[2]; i++) {
        //     nums[i] = 2;
        // }

        //One-pass
        int n = nums.length, i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 2) {
                swap(nums, j, k);
                k--;
            } else {
                j++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
// @lc code=end

