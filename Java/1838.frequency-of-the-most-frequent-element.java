/*
 * @lc app=leetcode id=1838 lang=java
 *
 * [1838] Frequency of the Most Frequent Element
 */

// @lc code=start

import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length, l = 0, sum = 0, res = 0;
        Arrays.sort(nums);
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            if ((r - l + 1) * nums[r] - sum > k) {
                sum -= nums[l++];
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
// @lc code=end

