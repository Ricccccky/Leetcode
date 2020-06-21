/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int max = 0;
        int result = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == farthest) {
                result++;
                farthest = max;
            }
        }
        return result;
    }
}
// @lc code=end

