
/*
 * @lc app=leetcode id=1775 lang=java
 *
 * [1775] Equal Sum Arrays With Minimum Number of Operations
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
            return -1;
        }
        int sum1 = 0, sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        if (sum1 > sum2) {
            return minOperations(nums2, nums1, sum2, sum1);
        }
        return minOperations(nums1, nums2, sum1, sum2);
    }

    private int minOperations(int[] nums1, int[] nums2, int sum1, int sum2) {
        int[] count = new int[6];
        int result = 0, diff = sum2 - sum1;
        for (int num : nums1) {
            count[6 - num]++;
        }
        for (int num : nums2) {
            count[num - 1]++;
        }
        for (int i = 5; i > 0 && diff > 0; i--) {
            int tmp = Math.min(count[i], diff / i + (diff % i != 0 ? 1 : 0));
            diff -= tmp * i;
            result += tmp;
        }

        return result;
    }
}
// @lc code=end

