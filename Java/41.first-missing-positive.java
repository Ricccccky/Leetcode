/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n + 1) {
                nums[i] = n + 1;
            }
        }
        // all numbers of nums in [1, n + 1]
        for (int num : nums) {
            num = Math.abs(num);
            if (num > n) {
                continue;
            }
            // make num in [0, n - 1]
            num--;
            // flip nums[num] for the first time visit it
            if (nums[num] > 0) {
                nums[num] *= -1;
            }
        }
        for (int i = 0; i < n; i++) {
            // check 1 to n
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
// @lc code=end

