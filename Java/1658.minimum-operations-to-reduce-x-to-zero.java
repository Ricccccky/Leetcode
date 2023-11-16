/*
 * @lc app=leetcode id=1658 lang=java
 *
 * [1658] Minimum Operations to Reduce X to Zero
 */
import java.util.*;
// @lc code=start
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0, l = 0, r = 0, n = nums.length, cur = 0, len = -1;
        for (int num : nums) {
            sum += num;
        }
        sum -= x;
        while (r < n) {
            cur += nums[r];
            while (cur > sum && l <= r) {
                cur -= nums[l++];
            }
            if (cur == sum) {
                len = Math.max(len, r - l + 1);
            }
            r++;
        }

        return len == -1 ? -1 : n - len;
    }
}
// @lc code=end

