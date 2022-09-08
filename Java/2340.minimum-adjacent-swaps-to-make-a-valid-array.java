/*
 * @lc app=leetcode id=2340 lang=java
 *
 * [2340] Minimum Adjacent Swaps to Make a Valid Array
 */

// @lc code=start
class Solution {
    public int minimumSwaps(int[] nums) {
        int result = 0;
        int n = nums.length;
        int max = nums[0], min = nums[0];
        int maxIdx = 0, minIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                maxIdx = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
        }
        result = minIdx + n - maxIdx - 1;
        if (maxIdx < minIdx) {
            result--;
        }

        return result;
    }
}
// @lc code=end

