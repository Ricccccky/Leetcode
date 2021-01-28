import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(entry.getKey() - k)) {
                    res++;
                }
            }
        }
        
        return res;
    }
}
// @lc code=end

