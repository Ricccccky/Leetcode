/*
 * @lc app=leetcode id=1590 lang=java
 *
 * [1590] Make Sum Divisible by P
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length, res = n, rem = 0, sum = 0;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        for (int num : nums) {
            rem = (rem + num) % p;
        }
        lastSeen.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % p;
            lastSeen.put(sum, i);
            int target = (sum - rem + p) % p;
            if (lastSeen.containsKey(target)) {
                res = Math.min(res, i - lastSeen.get(target));
            }
        }

        return res == n? -1 : res;
    }
}
// @lc code=end

