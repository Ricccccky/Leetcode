import java.util.Arrays;

/*
 * @lc app=leetcode id=2294 lang=java
 *
 * [2294] Partition Array Such That Maximum Difference Is K
 */

// @lc code=start
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 1;
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            if (max - min > k) {
                result++;
                max = num;
                min = num;
            }
        }

        return result;
    }
}
// @lc code=end

