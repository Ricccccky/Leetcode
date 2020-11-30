import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edge = new HashMap<>();
        int result = 0;
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                edge.put(sum, edge.getOrDefault(sum, 0) + 1);
                result = Math.max(result, edge.get(sum));
            }
        }
        return wall.size() - result;
    }
}
// @lc code=end

