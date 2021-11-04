
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
        int p0 = -1;
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                p0++;
                swap(nums, p0, p1);
                p1++;
            } else if (nums[p1] == 1) {
                p1++;
            } else {
                swap(nums, p1, p2);
                p2--;
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

