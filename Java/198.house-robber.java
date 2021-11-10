/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int last = 0;
        int before_last = 0;
        for (int num : nums) {
            int cur = Math.max(last, before_last + num);
            before_last = last;
            last = cur;
        }

        return last;
    }
}
// @lc code=end

