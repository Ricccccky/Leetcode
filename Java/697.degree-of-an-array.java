import java.util.*;

/*
 * @lc app=leetcode id=697 lang=java
 *
 * [697] Degree of an Array
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        int res = nums.length;
        Map<Integer, Integer> counter = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, counter.get(nums[i]));
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            last.put(nums[i], i);
        }
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == degree) {
                res = Math.min(res, last.get(entry.getKey()) - first.get(entry.getKey()) + 1);
            }
        }

        return res;
    }
}
// @lc code=end

