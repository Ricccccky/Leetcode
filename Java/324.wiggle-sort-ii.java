import java.util.Arrays;

/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        // O(nlogn) and O(n)
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int idx = nums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = tmp[idx--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = tmp[idx--];
        }
    }
}
// @lc code=end

