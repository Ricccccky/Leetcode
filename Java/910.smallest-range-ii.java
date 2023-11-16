import java.util.*;

/*
 * @lc app=leetcode id=910 lang=java
 *
 * [910] Smallest Range II
 */

// @lc code=start
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            // Divide nums into 2 parts, A and B. Add k to all num in A and sub k from all num in B
            /*
             * Divide nums into 2 parts at i, A and B. A[-1] = nums[i] and B[0] = nums[i + 1].
             * Add k to all num in A and sub k from all num in B.
             * Then, the maxVal for nums should be max(A[-1], B[-1]), and the minVal should be
             * min(A[0], B[0]).
             */
            int max = Math.max(nums[n - 1] - k, nums[i] + k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            result = Math.min(result, max - min);
        }

        return result;
    }
}
// @lc code=end

