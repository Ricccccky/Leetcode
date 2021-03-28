import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[] {building[0], building[2]});
            heights.add(new int[] {building[1], -building[2]});
        }
        Collections.sort(heights, (b1, b2) -> (b1[0] == b2[0] ? -Integer.compare(b1[1], b2[1]) : Integer.compare(b1[0], b2[0])));
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
        queue.offer(0);
        int preHeight = 0;
        for (int[] height : heights) {
            if (height[1] > 0) {
                queue.offer(height[1]);
            } else {
                queue.remove(-height[1]);
            }
            int curMax = queue.peek();
            if (curMax != preHeight) {
                res.add(List.of(height[0], curMax));
                preHeight = curMax;
            }
        }
        
        return res;
    }
}
// @lc code=end

