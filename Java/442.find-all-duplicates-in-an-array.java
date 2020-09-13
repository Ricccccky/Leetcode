import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=442 lang=java
 *
 * [442] Find All Duplicates in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                result.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }
        return result;
    }
}
// @lc code=end

