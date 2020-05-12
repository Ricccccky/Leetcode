import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> temp = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (temp.containsKey(target - nums[i])) {
                result[0] = temp.get(target - nums[i]);
                result[1] = i;
            }
            temp.put(nums[i], i);
        }
        return result;
    }
}
// @lc code=end

