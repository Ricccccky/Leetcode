/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int last = 0;
        int before_last = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int cur = Math.max(last, before_last + nums[i]);
            before_last = last;
            last = cur;
        }
        res = Math.max(res, last);
        last = 0;
        before_last = 0;
        for (int i = 1; i < nums.length; i++) {
            int cur = Math.max(last, before_last + nums[i]);
            before_last = last;
            last = cur;
        }
        res = Math.max(res, last);

        return res;
    }
}
// @lc code=end

