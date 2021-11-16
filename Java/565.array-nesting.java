/*
 * @lc app=leetcode id=565 lang=java
 *
 * [565] Array Nesting
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int k = 0; k < nums.length; k++) {
            int count = 0;
            for (int i = k; nums[i] != -1;) {
                count++;
                int idx = nums[i];
                nums[i] = -1;
                i = idx;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}
// @lc code=end

