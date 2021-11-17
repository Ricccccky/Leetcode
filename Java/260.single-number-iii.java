/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        int[] res = new int[2];
        for (int num : nums) {
            xor ^= num;
        }
        int rightDiff = xor & (-xor);
        for (int num : nums) {
            /*
            Use new mask rightDiff to divide nums into two groups:
            1. x and all other num with the last diff digit is 1;
            2. y and all other num with the last diff digit is 0.
            Then, the new mask can find x and y in the groups, separately.
            */
            if ((num & rightDiff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }
}
// @lc code=end

