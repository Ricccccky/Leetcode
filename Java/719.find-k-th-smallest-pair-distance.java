import java.util.Arrays;

/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 */

// @lc code=start
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0;
        int hi = nums[n - 1] - nums[0];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            // Tow pointer to find how many pairs no more than mid
            for (int i = 0, j = 0; i < n; i++) {
                while (nums[i] - nums[j] > mid) {
                    j++;
                }
                count += i - j;
            }
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
// @lc code=end

