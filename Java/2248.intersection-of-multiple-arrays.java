import java.util.*;

/*
 * @lc app=leetcode id=2248 lang=java
 *
 * [2248] Intersection of Multiple Arrays
 */

// @lc code=start
class Solution {
    public List<Integer> intersection(int[][] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int[] num : nums) {
            for (int n : num) {
                count.put(n, count.getOrDefault(n, 0) + 1);
            }
        }
        for (var entry : count.entrySet()) {
            if (entry.getValue() == nums.length) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        
        return result;
    }
}
// @lc code=end

