/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
// @lc code=end

