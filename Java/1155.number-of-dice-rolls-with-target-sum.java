import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1155 lang=java
 *
 * [1155] Number of Dice Rolls With Target Sum
 */

// @lc code=start
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        Map<String, Integer> map = new HashMap<>();
        return dp(d, f, target, map);
    }

    private int dp(int d, int f, int target, Map<String, Integer> map) {
        if (d == 0) {
            if (target > 0) {
                return 0;
            } else {
                return 1;
            }
        }
        if (map.containsKey(d + "," + target)) {
            return map.get(d + "," + target);
        }
        int count = 0;
        for (int i = 1; i <= f; i++) {
            if (target - i >= 0) {
                count += dp(d - 1, f, target - i, map);
                count %= 1000000007;
            }
        }
        map.put(d + "," + target, count);
        return count;
    }
}
// @lc code=end

