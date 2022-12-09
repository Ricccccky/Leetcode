
/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int k : nums) {
            if (k <= i) {
                i = k;
            } else if (k <= j) {
                j = k;
            } else {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

