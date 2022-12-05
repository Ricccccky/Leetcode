import java.util.*;

/*
 * @lc app=leetcode id=163 lang=java
 *
 * [163] Missing Ranges
 */

// @lc code=start
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > next) {
                addRange(next, nums[i] - 1, res);
            }
            next = nums[i] + 1;
        }
        addRange(next, upper, res);

        return res;
    }

    private void addRange(int lower, int upper, List<String> res) {
        if (lower == upper) {
            res.add(String.valueOf(lower));
        } else if (lower < upper) {
            res.add(String.valueOf(lower) + "->" + String.valueOf(upper));
        }
    }
}
// @lc code=end

