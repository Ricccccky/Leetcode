import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=1296 lang=java
 *
 * [1296] Divide Array in Sets of K Consecutive Numbers
 */

// @lc code=start
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) > 0) {
                int temp = map.get(num);
                for (int i = 0; i < k; i++) {
                    if (map.getOrDefault(num + i, 0) < temp) {
                        return false;
                    }
                    map.put(num + i, map.get(num + i) - temp);
                }
            }
        }

        return true;
    }
}
// @lc code=end

