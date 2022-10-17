import java.util.*;

/*
 * @lc app=leetcode id=2023 lang=java
 *
 * [2023] Number of Pairs of Strings With Concatenation Equal to Target
 */

// @lc code=start
class Solution {
    // O(m * n), m is the length of the longest word
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        for (String num : nums) {
            if (target.startsWith(num)) {
                String suffix = target.substring(num.length());
                result += map.getOrDefault(suffix, 0);
            }
            if (target.endsWith(num)) {
                String prefix = target.substring(0, target.length() - num.length());
                result += map.getOrDefault(prefix, 0);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return result;
    }
}
// @lc code=end

