import java.util.*;

/*
 * @lc app=leetcode id=1762 lang=java
 *
 * [1762] Buildings With an Ocean View
 */

// @lc code=start
class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (max < heights[i]) {
                max = heights[i];
                list.add(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - i - 1);
        }

        return result;
    }
}
// @lc code=end

