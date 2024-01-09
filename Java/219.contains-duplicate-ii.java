/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start

import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
// @lc code=end

