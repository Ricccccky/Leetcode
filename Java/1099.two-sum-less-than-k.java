import java.util.*;

/*
 * @lc app=leetcode id=1099 lang=java
 *
 * [1099] Two Sum Less Than K
 */

// @lc code=start
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);
        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2) {
            int sum = nums[p1] + nums[p2];
            if (sum < k) {
                result = Math.max(result, sum);
                p1++;
            } else {
                p2--;
            }
        }

        return result == 0 ? -1 : result;
    }
}
// @lc code=end

