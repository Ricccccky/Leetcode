import java.util.*;

/*
 * @lc app=leetcode id=259 lang=java
 *
 * [259] 3Sum Smaller
 */

// @lc code=start
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            int sum = target - nums[i];
            while(low < high) {
                if (nums[low] + nums[high] < sum) {
                    result += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }

        return result;
    }
}
// @lc code=end

