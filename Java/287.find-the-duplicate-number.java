import java.util.Arrays;

/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int res = -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (binarySearch(nums, nums[i], i + 1)) {
                res = nums[i];
                break;
            }
        }

        return res;
    }

    private boolean binarySearch(int[] nums, int target, int start) {
        int lo = start;
        int hi = nums.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return false;
    }
}
// @lc code=end

