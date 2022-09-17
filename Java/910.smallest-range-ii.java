import java.util.*;

/*
 * @lc app=leetcode id=910 lang=java
 *
 * [910] Smallest Range II
 */

// @lc code=start
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(nums[n - 1] - k, nums[i] + k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            result = Math.min(result, max - min);
        }

        return result;
    }
}
// @lc code=end

