import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
            int max = 0;
            int same = 0;
            for (int j = i + 1; j < points.length; j++) {
                int delta_y = points[j][1] - points[i][1];
                int delta_x = points[j][0] - points[i][0];
                if (delta_y == 0 && delta_x == 0) {
                    same++;
                    continue;
                }
                int gcd = getGCD(delta_y, delta_x);
                int slope_y = delta_y / gcd;
                int slope_x = delta_x / gcd;
                map.put(new Pair<>(slope_y, slope_x), map.getOrDefault(new Pair<>(slope_y, slope_x), 0) + 1);
                max = Math.max(max, map.get(new Pair<>(slope_y, slope_x)));
            }
            res = Math.max(res, max + same + 1);
        }
        
        return res;
    }

    private int getGCD(int x, int y) {
        if (y == 0) {
            return x;
        }

        return getGCD(y, x % y);
    }
}
// @lc code=end

