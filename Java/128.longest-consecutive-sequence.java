import java.util.*;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                sum = left + right + 1;
                map.put(num, sum);
                result = Math.max(result, sum);
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        
        return result;
    }
}
// @lc code=end

