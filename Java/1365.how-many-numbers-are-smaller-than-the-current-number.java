import java.util.*;

/*
 * @lc app=leetcode id=1365 lang=java
 *
 * [1365] How Many Numbers Are Smaller Than the Current Number
 */

// @lc code=start
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] dummy = Arrays.copyOf(nums, nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(dummy);
        for (int i = 0; i < dummy.length; i++) {
            map.putIfAbsent(dummy[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }

        return nums;
    }
}
// @lc code=end

