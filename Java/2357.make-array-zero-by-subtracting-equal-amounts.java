/*
 * @lc app=leetcode id=2357 lang=java
 *
 * [2357] Make Array Zero by Subtracting Equal Amounts
 */

// @lc code=start

import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length, result = 0, minusSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > minusSum) {
                int diff = nums[i] - minusSum;
                minusSum += diff;
                result++;
            }
        }

        return result;
    }
}
// @lc code=end

