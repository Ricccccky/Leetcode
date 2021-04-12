import java.util.Deque;
import java.util.LinkedList;

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
        for (int num : nums) {
            if (num <= i) {
                i = num;
            } else if (num <= j) {
                j = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

