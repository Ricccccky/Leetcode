import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */

// @lc code=start
class Solution {
    // O(n * sqrt(n))
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            if (i > 0 && stones[i] - stones[i - 1] > i) {
                return false;
            }
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(1);
        for (int stone : stones) {
            if (map.get(stone).isEmpty()) {
                return false;
            }
            for (int jump : map.get(stone)) {
                int next = stone + jump;
                if (next == stones[stones.length - 1]) {
                    return true;
                }
                if (map.containsKey(next)) {
                    for (int i = jump + 1; i >= jump - 1 && i > 0; i--) {
                        map.get(next).add(i);
                    }
                }
            }
        }

        return false;
    }
}
// @lc code=end

