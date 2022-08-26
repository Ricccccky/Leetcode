/*
 * @lc app=leetcode id=1567 lang=java
 *
 * [1567] Maximum Length of Subarray With Positive Product
 */

// @lc code=start
class Solution {
    public int getMaxLen(int[] nums) {
        int negIndex = -1, zeroIndex = -1;
        int negNum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (negIndex == -1) {
                    negIndex = i;
                }
                negNum++;
            }
            if (nums[i] == 0) {
                negIndex = -1;
                negNum = 0;
                zeroIndex = i;
            } else {
                if (negNum % 2 == 0) {
                    result = Math.max(result, i - zeroIndex);
                } else {
                    result = Math.max(result, i - negIndex);
                }
            }
        }

        return result;
    }
}
// @lc code=end

