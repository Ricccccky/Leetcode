import java.util.*;

/*
 * @lc app=leetcode id=406 lang=java
 *
 * [406] Queue Reconstruction by Height
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? Integer.compare(x[1], y[1]) : Integer.compare(y[0], x[0]));
        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][]);
    }
}
// @lc code=end

